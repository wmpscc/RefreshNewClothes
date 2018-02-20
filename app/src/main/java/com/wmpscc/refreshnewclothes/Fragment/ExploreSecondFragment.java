package com.wmpscc.refreshnewclothes.Fragment;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.wmpscc.refreshnewclothes.Binder.MessageFrameItemViewBinder;
import com.wmpscc.refreshnewclothes.Item.MessageFrameItem;
import com.wmpscc.refreshnewclothes.R;
import com.wmpscc.refreshnewclothes.Utils.MessageType;

import me.drakeet.multitype.Items;
import me.drakeet.multitype.MultiTypeAdapter;

public class ExploreSecondFragment extends Fragment {
    private RecyclerView mRecyclerView;
    private MultiTypeAdapter mAdapter;
    private Items mItems;
    private View mView;
    public ExploreSecondFragment() {
        // Required empty public constructor
    }


    public static ExploreSecondFragment newInstance(String param1, String param2) {
        ExploreSecondFragment fragment = new ExploreSecondFragment();
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
        mView = inflater.inflate(R.layout.fragment_explore_second, container, false);
        initView();
        initRecycleView();
        return mView;
    }

    private void initView() {
        mRecyclerView = mView.findViewById(R.id.rv_explore_second);

    }

    private void initRecycleView() {
        mAdapter = new MultiTypeAdapter();
        mAdapter.register(MessageFrameItem.class, new MessageFrameItemViewBinder());
        mRecyclerView.setAdapter(mAdapter);

        mItems = new Items();
        mItems.add(new MessageFrameItem(MessageType.PlainText));
        mItems.add(new MessageFrameItem(MessageType.PlainImage));
        mItems.add(new MessageFrameItem(MessageType.TextAndImage));

        mAdapter.setItems(mItems);
        mAdapter.notifyDataSetChanged();
    }

}
