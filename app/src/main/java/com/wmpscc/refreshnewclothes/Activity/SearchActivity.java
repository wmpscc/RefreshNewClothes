package com.wmpscc.refreshnewclothes.Activity;

import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.widget.Button;
import android.widget.EditText;

import com.wmpscc.refreshnewclothes.Binder.DesignerInfoCardItemViewBinder;
import com.wmpscc.refreshnewclothes.Binder.DesignerSelfGoodsItemViewBinder;
import com.wmpscc.refreshnewclothes.Binder.DesignerTransationInfoItemViewBinder;
import com.wmpscc.refreshnewclothes.Binder.LabelViewBinder;
import com.wmpscc.refreshnewclothes.Item.DesignerInfoCardItem;
import com.wmpscc.refreshnewclothes.Item.DesignerSelfGoodsItem;
import com.wmpscc.refreshnewclothes.Item.DesignerTransationInfoItem;
import com.wmpscc.refreshnewclothes.Item.Label;
import com.wmpscc.refreshnewclothes.R;

import me.drakeet.multitype.Items;
import me.drakeet.multitype.MultiTypeAdapter;

public class SearchActivity extends AppCompatActivity {
    private RecyclerView mRecyclerView;
    private MultiTypeAdapter mAdapter;
    private Items mItems;
    private EditText mEditText;
    private Button mButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);
        initView();
        initRecyclerView();
    }

    private void initView(){
        mRecyclerView = findViewById(R.id.rv_search);
        mButton = findViewById(R.id.bt_search);
        mEditText = findViewById(R.id.ed_search_context);
    }

    private void initRecyclerView(){
        mAdapter = new MultiTypeAdapter();
        mAdapter.register(DesignerTransationInfoItem.class, new DesignerTransationInfoItemViewBinder(getSupportFragmentManager()));
        mAdapter.register(Label.class, new LabelViewBinder());
        mAdapter.register(DesignerInfoCardItem.class, new DesignerInfoCardItemViewBinder());
        mAdapter.register(DesignerSelfGoodsItem.class, new DesignerSelfGoodsItemViewBinder());
        mRecyclerView.setAdapter(mAdapter);

        mItems = new Items();
        mItems.add(new Label("设计师"));
        mItems.add(new DesignerInfoCardItem());
        mItems.add(new DesignerInfoCardItem());

        mItems.add(new Label("改造"));
        mItems.add(new DesignerTransationInfoItem());
        mItems.add(new DesignerTransationInfoItem());
        mItems.add(new DesignerTransationInfoItem());

        mItems.add(new Label("作品"));
        mItems.add(new DesignerSelfGoodsItem());
        mItems.add(new DesignerSelfGoodsItem());
        mItems.add(new DesignerSelfGoodsItem());
        mItems.add(new DesignerSelfGoodsItem());

        mAdapter.setItems(mItems);
        mAdapter.notifyDataSetChanged();

    }

}