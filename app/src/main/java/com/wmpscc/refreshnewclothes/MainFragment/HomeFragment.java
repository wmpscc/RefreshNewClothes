package com.wmpscc.refreshnewclothes.MainFragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.alibaba.fastjson.JSON;
import com.lzy.okgo.model.Response;
import com.wmpscc.refreshnewclothes.Bean.FirstFragmentBean.CommodityArray;
import com.wmpscc.refreshnewclothes.Bean.FirstFragmentBean.FirstJsonContent;
import com.wmpscc.refreshnewclothes.Bean.FirstFragmentBean.JSON_first_fragment;
import com.wmpscc.refreshnewclothes.Bean.FirstFragmentBean.RecommendMessageArray;
import com.wmpscc.refreshnewclothes.Bean.FirstFragmentBean.TopBannerArray;
import com.wmpscc.refreshnewclothes.Bean.FirstFragmentBean.TradeShowArray;
import com.wmpscc.refreshnewclothes.Bean.GlobalData;
import com.wmpscc.refreshnewclothes.Binder.DesignerTransationInfoItemViewBinder;
import com.wmpscc.refreshnewclothes.Item.DesignerTransationInfoItem;
import com.wmpscc.refreshnewclothes.Item.GalleryItem;
import com.wmpscc.refreshnewclothes.Binder.GalleryItemViewBinder;
import com.wmpscc.refreshnewclothes.Item.BannerItem;
import com.wmpscc.refreshnewclothes.Binder.BannerItemViewBinder;
import com.wmpscc.refreshnewclothes.Item.Label;
import com.wmpscc.refreshnewclothes.Binder.LabelViewBinder;
import com.wmpscc.refreshnewclothes.R;
import com.wmpscc.refreshnewclothes.Item.ShowDealsItem;
import com.wmpscc.refreshnewclothes.Binder.ShowDealsItemViewBinder;
import com.wmpscc.refreshnewclothes.Item.RecomNewsItem;
import com.wmpscc.refreshnewclothes.Binder.RecomNewsItemViewBinder;
import com.wmpscc.refreshnewclothes.RecycleViewDivider;
import com.wmpscc.refreshnewclothes.Utils.SpacesItemDecoration;

import java.util.ArrayList;
import java.util.List;

import me.drakeet.multitype.Items;
import me.drakeet.multitype.MultiTypeAdapter;

public class HomeFragment extends Fragment {
    private RecyclerView mRecyclerView;
    private MultiTypeAdapter mAdapter;
    private Items mItems;
    private View mView;
    private JSON_first_fragment mJSONFirstFragment;
    private List<TopBannerArray> mTopBannerArray = new ArrayList<>();
    private List<CommodityArray> mCommodityArray = new ArrayList<>();
    private List<RecommendMessageArray> mRecommendMessageArray = new ArrayList<>();
    private List<TradeShowArray> mTradeShowArray = new ArrayList<>();


    public HomeFragment() {
        // Required empty public constructor
    }


    public static HomeFragment newInstance(String param1, String param2) {
        HomeFragment fragment = new HomeFragment();
        Bundle args = new Bundle();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        mView = inflater.inflate(R.layout.fragment_home, container, false);
        analyzeJson();
        initView();
        initRecycleItem();
        return mView;
    }

    private void analyzeJson() {
        mJSONFirstFragment = JSON.parseObject(FirstJsonContent.content, JSON_first_fragment.class);
        mCommodityArray = mJSONFirstFragment.getCommodity();
        mRecommendMessageArray = mJSONFirstFragment.getRecommendMessage();
        mTopBannerArray = mJSONFirstFragment.getTopBanner();
        mTradeShowArray = mJSONFirstFragment.getTradeShow();
        GlobalData.sCommodityArrays = mCommodityArray;


    }

    private void initView() {
        mRecyclerView = mView.findViewById(R.id.rv_homePager);
        mRecyclerView.addItemDecoration(new SpacesItemDecoration(20));
//        mRecyclerView.addItemDecoration(new RecycleViewDivider(
//                mView.getContext(), LinearLayoutManager.VERTICAL, 100, getResources().getColor(R.color.colorGary)));
    }

    private void initRecycleItem() {
        mAdapter = new MultiTypeAdapter();
        mAdapter.register(BannerItem.class, new BannerItemViewBinder());
        mAdapter.register(ShowDealsItem.class, new ShowDealsItemViewBinder());
        mAdapter.register(RecomNewsItem.class, new RecomNewsItemViewBinder());
        mAdapter.register(GalleryItem.class, new GalleryItemViewBinder());
        mAdapter.register(Label.class, new LabelViewBinder());

        mRecyclerView.setAdapter(mAdapter);

        mItems = new Items();
        mItems.add(new BannerItem(mTopBannerArray));
        mItems.add(new Label("设计师作品"));
        mItems.add(new GalleryItem(mCommodityArray));
        mItems.add(new Label("成交作品展示"));


        for (int i = 1; i < mTradeShowArray.size(); i++) {
            mItems.add(new ShowDealsItem(mTradeShowArray.get(i)));
        }

        for (int i = 0; i < mRecommendMessageArray.size(); i++) {
            mItems.add(new RecomNewsItem(mRecommendMessageArray.get(i)));
        }


        mAdapter.setItems(mItems);
        mAdapter.notifyDataSetChanged();

    }

}
