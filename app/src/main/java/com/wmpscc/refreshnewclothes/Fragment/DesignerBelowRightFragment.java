package com.wmpscc.refreshnewclothes.Fragment;

import android.icu.util.ULocale;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.wmpscc.refreshnewclothes.Bean.StaticData;
import com.wmpscc.refreshnewclothes.Item.DesignerSelfGoodsItem;
import com.wmpscc.refreshnewclothes.Binder.DesignerSelfGoodsItemViewBinder;
import com.wmpscc.refreshnewclothes.R;


import me.drakeet.multitype.Items;
import me.drakeet.multitype.MultiTypeAdapter;

public class DesignerBelowRightFragment extends Fragment {
    private View mView;
    private RecyclerView mRecyclerView;
    private Items mItems;
    private MultiTypeAdapter mAdapter;


    public DesignerBelowRightFragment() {
        // Required empty public constructor
    }

    public static DesignerBelowRightFragment newInstance(String param1, String param2) {
        DesignerBelowRightFragment fragment = new DesignerBelowRightFragment();
        Bundle args = new Bundle();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        StaticData.designerDealsFm = getChildFragmentManager();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        mView = inflater.inflate(R.layout.fragment_designer_below_right, container, false);
        initRecyclerView();
        return mView;
    }

    private void initRecyclerView() {
        mRecyclerView = mView.findViewById(R.id.rv_designer_self_goods);
        mAdapter = new MultiTypeAdapter();
        mItems = new Items();
        final GridLayoutManager layoutManager = new GridLayoutManager(mView.getContext(), 2);
        layoutManager.setSpanSizeLookup(new GridLayoutManager.SpanSizeLookup() {
            @Override
            public int getSpanSize(int position) {
                return (mItems.get(position) instanceof ULocale.Category) ? 2 : 1;
            }
        });

        mRecyclerView.setLayoutManager(layoutManager);
        mAdapter.register(DesignerSelfGoodsItem.class, new DesignerSelfGoodsItemViewBinder());
        mRecyclerView.setAdapter(mAdapter);
        mItems.add(new DesignerSelfGoodsItem());
        mItems.add(new DesignerSelfGoodsItem());
        mItems.add(new DesignerSelfGoodsItem());
        mItems.add(new DesignerSelfGoodsItem());
        mItems.add(new DesignerSelfGoodsItem());
        mItems.add(new DesignerSelfGoodsItem());
        mItems.add(new DesignerSelfGoodsItem());
        mItems.add(new DesignerSelfGoodsItem());
        mItems.add(new DesignerSelfGoodsItem());
        mItems.add(new DesignerSelfGoodsItem());
        mItems.add(new DesignerSelfGoodsItem());
        mItems.add(new DesignerSelfGoodsItem());
        mItems.add(new DesignerSelfGoodsItem());
        mItems.add(new DesignerSelfGoodsItem());
        mItems.add(new DesignerSelfGoodsItem());
        mItems.add(new DesignerSelfGoodsItem());
        mItems.add(new DesignerSelfGoodsItem());
        mItems.add(new DesignerSelfGoodsItem());
        mItems.add(new DesignerSelfGoodsItem());
        mItems.add(new DesignerSelfGoodsItem());
        mItems.add(new DesignerSelfGoodsItem());
        mItems.add(new DesignerSelfGoodsItem());
        mItems.add(new DesignerSelfGoodsItem());
        mItems.add(new DesignerSelfGoodsItem());

        mAdapter.setItems(mItems);
        mAdapter.notifyDataSetChanged();

    }


}
