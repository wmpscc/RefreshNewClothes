package com.wmpscc.refreshnewclothes.Fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.parser.Feature;
import com.wmpscc.refreshnewclothes.Bean.SecondFragmentBean.JSON_second_fragment;
import com.wmpscc.refreshnewclothes.Bean.SecondFragmentBean.SecondJsonContent;
import com.wmpscc.refreshnewclothes.Item.MessageFrameItem;
import com.wmpscc.refreshnewclothes.Binder.MessageFrameItemViewBinder;
import com.wmpscc.refreshnewclothes.R;
import com.wmpscc.refreshnewclothes.Utils.MessageType;

import java.util.ArrayList;
import java.util.List;

import me.drakeet.multitype.Items;
import me.drakeet.multitype.MultiTypeAdapter;

public class ExploreFirstFragment extends Fragment {
    private RecyclerView mRecyclerView;
    private MultiTypeAdapter mAdapter;
    private Items mItems;
    private View mView;
    private List<JSON_second_fragment> mJSONSecondFragments = new ArrayList<>();


    public ExploreFirstFragment() {
        // Required empty public constructor
    }

    public static ExploreFirstFragment newInstance(String param1, String param2) {
        ExploreFirstFragment fragment = new ExploreFirstFragment();
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
        mView = inflater.inflate(R.layout.fragment_explore_first, container, false);
        analyzeJson();
        initView();
        initRecycleView();
        return mView;
    }

    private void analyzeJson() {
        mJSONSecondFragments = JSON.parseArray(SecondJsonContent.content, JSON_second_fragment.class);

    }

    private void initView() {
        mRecyclerView = mView.findViewById(R.id.rv_explore_first);

    }

    private void initRecycleView() {
        mAdapter = new MultiTypeAdapter();
        mAdapter.register(MessageFrameItem.class, new MessageFrameItemViewBinder());
        mRecyclerView.setAdapter(mAdapter);

        mItems = new Items();
        for (int i = 0; i < mJSONSecondFragments.size(); i++) {
            switch (mJSONSecondFragments.get(i).getType()) {
                case "text":
                    mItems.add(new MessageFrameItem(MessageType.PlainText, mJSONSecondFragments.get(i)));
                    break;
                case "picture":
                    mItems.add(new MessageFrameItem(MessageType.PlainImage, mJSONSecondFragments.get(i)));
                    break;
                case "textPicture":
                    mItems.add(new MessageFrameItem(MessageType.TextAndImage, mJSONSecondFragments.get(i)));
                    break;

            }
        }


        mAdapter.setItems(mItems);
        mAdapter.notifyDataSetChanged();
    }


}
