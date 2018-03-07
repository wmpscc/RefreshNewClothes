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
import com.wmpscc.refreshnewclothes.Utils.PermisionUtils;

import java.util.logging.StreamHandler;

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
    private String userName;
    private String userType;
    private String backgroundUrl;
    private String userPhotoUrl;
    private String PhoneNumber;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_designer_info);
        PermisionUtils.verifyStoragePermissions(this);

        StaticData.desigerFm = getSupportFragmentManager();

        initParame();
        initView();
        initRecycleItem();

    }
    private void initParame(){
        userName = getIntent().getStringExtra("userName");
        backgroundUrl = getIntent().getStringExtra("backgroundUrl");
        userPhotoUrl = getIntent().getStringExtra("userPhotoUrl");
        PhoneNumber = getIntent().getStringExtra("PhoneNumber");
        userType = getIntent().getStringExtra("userType");

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
                mRecyclerView.setVisibleItemPos(fPos, lPos, dy);
                Log.e("rvPos", "fPos:" + fPos +"  "+ "lPos" + lPos + "  " + dy);
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
        mItems.add(new DesignerInfoTopItem(userName, userType, backgroundUrl, userPhotoUrl, PhoneNumber));
        mItems.add(new DesignerInfoDescribeItem());
        mItems.add(new DesignerInfoBelowItem());

        mAdapter.setItems(mItems);
        mAdapter.notifyDataSetChanged();

    }
}
