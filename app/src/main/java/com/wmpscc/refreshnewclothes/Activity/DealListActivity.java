package com.wmpscc.refreshnewclothes.Activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;

import com.wmpscc.refreshnewclothes.Binder.DealInfoItemViewBinder;
import com.wmpscc.refreshnewclothes.Item.DealInfoItem;
import com.wmpscc.refreshnewclothes.R;

import me.drakeet.multitype.Items;
import me.drakeet.multitype.MultiTypeAdapter;

public class DealListActivity extends AppCompatActivity {
    private RecyclerView mRecyclerView;
    private MultiTypeAdapter mAdapter;
    private Items mItems;
    private ImageView finishImageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_deal_list);
        mRecyclerView = findViewById(R.id.rv_deal_list);
        initRecyclerView();
        finishImageView = findViewById(R.id.iv_deal_list_finish);
        finishImageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
    }
    private void initRecyclerView(){
        mAdapter = new MultiTypeAdapter();
        mAdapter.register(DealInfoItem.class, new DealInfoItemViewBinder());

        mRecyclerView.setAdapter(mAdapter);

        mItems = new Items();
        mItems.add(new DealInfoItem());
        mItems.add(new DealInfoItem());
        mItems.add(new DealInfoItem());

        mAdapter.setItems(mItems);
        mAdapter.notifyDataSetChanged();

    }


}
