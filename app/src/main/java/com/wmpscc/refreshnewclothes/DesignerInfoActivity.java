package com.wmpscc.refreshnewclothes;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;

import com.wmpscc.refreshnewclothes.Binder.DesignerInfoTopItemViewBinder;
import com.wmpscc.refreshnewclothes.Item.DesignerInfoTopItem;

import me.drakeet.multitype.Items;
import me.drakeet.multitype.MultiTypeAdapter;

public class DesignerInfoActivity extends AppCompatActivity {
    private RecyclerView mRecyclerView;
    private MultiTypeAdapter mAdapter;
    private Items mItems;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_designer_info);

        initView();
        initRecycleItem();

    }
    private void initView(){
        mRecyclerView = findViewById(R.id.rv_designer_info);
    }

    private void initRecycleItem(){
        mAdapter = new MultiTypeAdapter();
        mAdapter.register(DesignerInfoTopItem.class, new DesignerInfoTopItemViewBinder());

        mRecyclerView.setAdapter(mAdapter);

        mItems = new Items();
        mItems.add(new DesignerInfoTopItem());

        mAdapter.setItems(mItems);
        mAdapter.notifyDataSetChanged();

    }
}
