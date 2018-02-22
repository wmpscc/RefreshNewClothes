package com.wmpscc.refreshnewclothes.Fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.wmpscc.refreshnewclothes.Bean.StaticData;
import com.wmpscc.refreshnewclothes.Item.DesignerTransationInfoItem;
import com.wmpscc.refreshnewclothes.Binder.DesignerTransationInfoItemViewBinder;
import com.wmpscc.refreshnewclothes.R;

import me.drakeet.multitype.Items;
import me.drakeet.multitype.MultiTypeAdapter;

public class DesignerBelowLeftFragment extends Fragment {
    private RecyclerView mRecyclerView;
    private MultiTypeAdapter mAdapter;
    private Items mItems;
    private View mView;

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
        initView();
        initRecycleItem();
        return mView;
    }

    private void initView(){
        mRecyclerView = mView.findViewById(R.id.rv_designer_deal_record);
    }

    private void initRecycleItem(){
        mAdapter = new MultiTypeAdapter();
        mAdapter.register(DesignerTransationInfoItem.class, new DesignerTransationInfoItemViewBinder());
        mRecyclerView.setAdapter(mAdapter);

        mItems = new Items();
        mItems.add(new DesignerTransationInfoItem());
        mItems.add(new DesignerTransationInfoItem());
        mItems.add(new DesignerTransationInfoItem());
        mItems.add(new DesignerTransationInfoItem());
        mItems.add(new DesignerTransationInfoItem());

        mAdapter.setItems(mItems);
        mAdapter.notifyDataSetChanged();
    }

}
