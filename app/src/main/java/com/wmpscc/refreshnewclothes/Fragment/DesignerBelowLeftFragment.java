package com.wmpscc.refreshnewclothes.Fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.alibaba.fastjson.JSON;
import com.wmpscc.refreshnewclothes.Bean.DealJSONList.DealJsonContent;
import com.wmpscc.refreshnewclothes.Bean.DealJSONList.JSON_deal_list;
import com.wmpscc.refreshnewclothes.Bean.StaticData;
import com.wmpscc.refreshnewclothes.Item.DesignerTransationInfoItem;
import com.wmpscc.refreshnewclothes.Binder.DesignerTransationInfoItemViewBinder;
import com.wmpscc.refreshnewclothes.R;

import java.util.ArrayList;
import java.util.List;
import java.util.zip.Inflater;

import me.drakeet.multitype.Items;
import me.drakeet.multitype.MultiTypeAdapter;

public class DesignerBelowLeftFragment extends Fragment {
    private RecyclerView mRecyclerView;
    private MultiTypeAdapter mAdapter;
    private Items mItems;
    private View mView;
    private List<JSON_deal_list> mJSONDealLists = new ArrayList<>();

    public DesignerBelowLeftFragment() {
        // Required empty public constructor
    }


    public static DesignerBelowLeftFragment newInstance(String param1, String param2) {
        DesignerBelowLeftFragment fragment = new DesignerBelowLeftFragment();
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
        mView = inflater.inflate(R.layout.fragment_designer_below_left, container, false);
        StaticData.designerDealsFm = getChildFragmentManager();
        analyzeJson();
        initView();
        initRecycleItem();
        return mView;
    }

    private void analyzeJson() {
        mJSONDealLists = JSON.parseArray(DealJsonContent.content, JSON_deal_list.class);
    }


    private void initView() {
        mRecyclerView = mView.findViewById(R.id.rv_designer_deal_record);
    }

    private void initRecycleItem() {
        mAdapter = new MultiTypeAdapter();
        FragmentManager fm = getChildFragmentManager();
        mAdapter.register(DesignerTransationInfoItem.class, new DesignerTransationInfoItemViewBinder(fm));
        mRecyclerView.setAdapter(mAdapter);

        mItems = new Items();
        for (int i = 0; i < mJSONDealLists.size(); i++) {
            mItems.add(new DesignerTransationInfoItem(mJSONDealLists.get(i)));
        }

        mAdapter.setItems(mItems);
        mAdapter.notifyDataSetChanged();
    }


}
