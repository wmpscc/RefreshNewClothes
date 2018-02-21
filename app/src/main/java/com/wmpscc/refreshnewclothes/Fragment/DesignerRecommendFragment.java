package com.wmpscc.refreshnewclothes.Fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.wmpscc.refreshnewclothes.AdImageView;
import com.wmpscc.refreshnewclothes.Binder.DesignerInfoCardItemViewBinder;
import com.wmpscc.refreshnewclothes.Item.DesignerInfoCardItem;
import com.wmpscc.refreshnewclothes.R;
import com.wmpscc.refreshnewclothes.Utils.SpacesItemDecoration;

import me.drakeet.multitype.Items;
import me.drakeet.multitype.MultiTypeAdapter;


public class DesignerRecommendFragment extends Fragment {
    private RecyclerView mRecyclerView;
    private LinearLayoutManager mLinearLayoutManager;
    private MultiTypeAdapter mAdapter;
    private Items mItems;
    private View mView;

    public DesignerRecommendFragment() {
        // Required empty public constructor
    }


    public static DesignerRecommendFragment newInstance(String param1, String param2) {
        DesignerRecommendFragment fragment = new DesignerRecommendFragment();
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
        mView = inflater.inflate(R.layout.fragment_designer_recommend, container, false);
        initView();
        initRecycleItem();
        return mView;
    }

    @Override
    public void onResume() {
        super.onResume();

    }

    private void initView() {
        mRecyclerView = mView.findViewById(R.id.rv_designer_recommend);
        mRecyclerView.addItemDecoration(new SpacesItemDecoration(20));
        mRecyclerView.setLayoutManager(mLinearLayoutManager = new LinearLayoutManager(getContext()));


        mRecyclerView.addOnScrollListener(new RecyclerView.OnScrollListener() {
            @Override
            public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
                super.onScrolled(recyclerView, dx, dy);
                int fPos = mLinearLayoutManager.findFirstVisibleItemPosition();
                int lPos = mLinearLayoutManager.findLastVisibleItemPosition();
                for (int i = fPos; i <= lPos; i++) {
                    View view = mLinearLayoutManager.findViewByPosition(i);
                    AdImageView adImageView = view.findViewById(R.id.iv_designer_card_photo);
                    if (adImageView.getVisibility() == View.VISIBLE) {
                        adImageView.setDy(mLinearLayoutManager.getHeight() - view.getTop());
                    }
                }

            }

            @Override
            public void onScrollStateChanged(RecyclerView recyclerView, int newState) {
                super.onScrollStateChanged(recyclerView, newState);


            }
        });
    }

    private void initRecycleItem() {
        mAdapter = new MultiTypeAdapter();
        mAdapter.register(DesignerInfoCardItem.class, new DesignerInfoCardItemViewBinder());

        mRecyclerView.setAdapter(mAdapter);

        mItems = new Items();
        mItems.add(new DesignerInfoCardItem());
        mItems.add(new DesignerInfoCardItem());
        mItems.add(new DesignerInfoCardItem());
        mItems.add(new DesignerInfoCardItem());
        mItems.add(new DesignerInfoCardItem());
        mItems.add(new DesignerInfoCardItem());
        mItems.add(new DesignerInfoCardItem());
        mItems.add(new DesignerInfoCardItem());
        mItems.add(new DesignerInfoCardItem());
        mItems.add(new DesignerInfoCardItem());
        mItems.add(new DesignerInfoCardItem());

        mAdapter.setItems(mItems);
        mAdapter.notifyDataSetChanged();

    }

}
