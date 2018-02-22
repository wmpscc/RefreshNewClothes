package com.wmpscc.refreshnewclothes;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;

import com.wmpscc.refreshnewclothes.Bean.StaticData;
import com.wmpscc.refreshnewclothes.Binder.DesignerInfoBelowItemViewBinder;
import com.wmpscc.refreshnewclothes.Binder.DesignerInfoDescribeItemViewBinder;
import com.wmpscc.refreshnewclothes.Binder.DesignerInfoTopItemViewBinder;
import com.wmpscc.refreshnewclothes.Item.DesignerInfoBelowItem;
import com.wmpscc.refreshnewclothes.Item.DesignerInfoDescribeItem;
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
        StaticData.desigerFm = getSupportFragmentManager();

        initView();
        initRecycleItem();

    }
    private void initView(){
        mRecyclerView = findViewById(R.id.rv_designer_info);
    }

    private void initRecycleItem(){
        mAdapter = new MultiTypeAdapter();
        mAdapter.register(DesignerInfoTopItem.class, new DesignerInfoTopItemViewBinder());
        mAdapter.register(DesignerInfoDescribeItem.class, new DesignerInfoDescribeItemViewBinder());
        mAdapter.register(DesignerInfoBelowItem.class, new DesignerInfoBelowItemViewBinder());
        mRecyclerView.setAdapter(mAdapter);

        mItems = new Items();
        mItems.add(new DesignerInfoTopItem());
        mItems.add(new DesignerInfoDescribeItem());
        mItems.add(new DesignerInfoBelowItem());

        mAdapter.setItems(mItems);
        mAdapter.notifyDataSetChanged();

    }
}
