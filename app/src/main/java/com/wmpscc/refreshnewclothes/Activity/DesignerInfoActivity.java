package com.wmpscc.refreshnewclothes.Activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.MotionEvent;

import com.wmpscc.refreshnewclothes.AvoidRVTouchClash;
import com.wmpscc.refreshnewclothes.Bean.StaticData;
import com.wmpscc.refreshnewclothes.Binder.DesignerInfoBelowItemViewBinder;
import com.wmpscc.refreshnewclothes.Binder.DesignerInfoDescribeItemViewBinder;
import com.wmpscc.refreshnewclothes.Binder.DesignerInfoTopItemViewBinder;
import com.wmpscc.refreshnewclothes.Item.DesignerInfoBelowItem;
import com.wmpscc.refreshnewclothes.Item.DesignerInfoDescribeItem;
import com.wmpscc.refreshnewclothes.Item.DesignerInfoTopItem;
import com.wmpscc.refreshnewclothes.R;

import me.drakeet.multitype.Items;
import me.drakeet.multitype.MultiTypeAdapter;

import static java.security.AccessController.getContext;

public class DesignerInfoActivity extends AppCompatActivity {
    private AvoidRVTouchClash mRecyclerView;
    private MultiTypeAdapter mAdapter;
    private Items mItems;
    private LinearLayoutManager mLinearLayoutManager;
    private LinearLayoutManager itemManager;
    private RecyclerView rvItem;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_designer_info);
        StaticData.desigerFm = getSupportFragmentManager();

        initView();
        initRecycleItem();

    }

    private void initView() {
        mRecyclerView = findViewById(R.id.rv_designer_info);
        mRecyclerView.setLayoutManager(mLinearLayoutManager = new LinearLayoutManager(this));
        mRecyclerView.addOnScrollListener(new RecyclerView.OnScrollListener() {
            @Override
            public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
                super.onScrolled(recyclerView, dx, dy);
                int fPos = mLinearLayoutManager.findFirstVisibleItemPosition();
                int lPos = mLinearLayoutManager.findLastVisibleItemPosition();
                mRecyclerView.setVisibleItemPos(fPos, lPos);
                Log.e("rvPos", "fPos:" + fPos + "lPos" + lPos);
            }
        });

//        rvItem = findViewById(R.id.rv_designer_deal_record);
//        rvItem.setLayoutManager(itemManager = new LinearLayoutManager(this));
//        rvItem.addOnScrollListener(new RecyclerView.OnScrollListener() {
//            @Override
//            public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
//                super.onScrolled(recyclerView, dx, dy);
//            }
//        });
    }

    private void initRecycleItem() {
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
