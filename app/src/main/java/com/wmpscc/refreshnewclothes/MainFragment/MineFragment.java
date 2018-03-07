package com.wmpscc.refreshnewclothes.MainFragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.wmpscc.refreshnewclothes.Binder.MineMenuDetailItemViewBinder;
import com.wmpscc.refreshnewclothes.Item.MineMenuDetailItem;
import com.wmpscc.refreshnewclothes.Item.MineTopInfoItem;
import com.wmpscc.refreshnewclothes.Binder.MineTopInfoItemViewBinder;
import com.wmpscc.refreshnewclothes.R;

import me.drakeet.multitype.Items;
import me.drakeet.multitype.MultiTypeAdapter;


public class MineFragment extends Fragment {
    private RecyclerView mRecyclerView;
    private MultiTypeAdapter mAdapter;
    private Items mItems;
    private View mView;

    public MineFragment() {
        // Required empty public constructor
    }

    public static MineFragment newInstance(String param1, String param2) {
        MineFragment fragment = new MineFragment();
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
        mView = inflater.inflate(R.layout.fragment_mine,container,false);
        initView();
        initRecycleItem();
        return mView;
    }
    private void initView(){
        mRecyclerView = mView.findViewById(R.id.rv_mine);
    }

    private void initRecycleItem(){
        mAdapter = new MultiTypeAdapter();
        mAdapter.register(MineTopInfoItem.class, new MineTopInfoItemViewBinder());
        mAdapter.register(MineMenuDetailItem.class, new MineMenuDetailItemViewBinder());
        mRecyclerView.setAdapter(mAdapter);

        mItems = new Items();
        mItems.add(new MineTopInfoItem());
        mItems.add(new MineMenuDetailItem(R.drawable.ic_add_clothes, "发布需求"));
        mItems.add(new MineMenuDetailItem(R.drawable.ic_my_focus, "我的关注"));
        mItems.add(new MineMenuDetailItem(R.drawable.ic_collect, "我的收藏"));
        mItems.add(new MineMenuDetailItem(R.drawable.ic_feedback, "用户反馈"));
        mItems.add(new MineMenuDetailItem(R.drawable.ic_aboutour, "关于我们"));

        mAdapter.setItems(mItems);
        mAdapter.notifyDataSetChanged();

    }

}
