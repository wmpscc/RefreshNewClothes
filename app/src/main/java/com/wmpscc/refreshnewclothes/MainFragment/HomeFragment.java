package com.wmpscc.refreshnewclothes.MainFragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

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
import com.wmpscc.refreshnewclothes.Utils.SpacesItemDecoration;

import me.drakeet.multitype.Items;
import me.drakeet.multitype.MultiTypeAdapter;

public class HomeFragment extends Fragment {
    private RecyclerView mRecyclerView;
    private MultiTypeAdapter mAdapter;
    private Items mItems;
    private View mView;



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
        initView();
        initRecycleItem();
        return mView;
    }
    private void initView(){
        mRecyclerView = mView.findViewById(R.id.rv_homePager);
        mRecyclerView.addItemDecoration(new SpacesItemDecoration(20));
    }

    private void initRecycleItem(){
        mAdapter = new MultiTypeAdapter();
        mAdapter.register(BannerItem.class, new BannerItemViewBinder());
        mAdapter.register(ShowDealsItem.class, new ShowDealsItemViewBinder());
        mAdapter.register(RecomNewsItem.class, new RecomNewsItemViewBinder());
        mAdapter.register(GalleryItem.class, new GalleryItemViewBinder());
        mAdapter.register(Label.class, new LabelViewBinder());

        mRecyclerView.setAdapter(mAdapter);

        mItems = new Items();
        mItems.add(new BannerItem());
        mItems.add(new Label("设计师作品"));
        mItems.add(new GalleryItem());
        mItems.add(new Label("成交作品展示"));
        mItems.add(new ShowDealsItem());
        mItems.add(new RecomNewsItem());

        mAdapter.setItems(mItems);
        mAdapter.notifyDataSetChanged();

    }

}
