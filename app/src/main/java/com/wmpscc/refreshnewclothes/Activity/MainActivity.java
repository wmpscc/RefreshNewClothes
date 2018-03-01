package com.wmpscc.refreshnewclothes.Activity;

import android.content.Intent;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import com.alibaba.fastjson.JSON;
import com.wmpscc.refreshnewclothes.Bean.Json_base_info;
import com.wmpscc.refreshnewclothes.Bean.StaticData;
import com.wmpscc.refreshnewclothes.CustomTabView.CustomTabView;
import com.wmpscc.refreshnewclothes.MainFragment.DesignerFragment;
import com.wmpscc.refreshnewclothes.MainFragment.ExploreFragment;
import com.wmpscc.refreshnewclothes.MainFragment.HomeFragment;
import com.wmpscc.refreshnewclothes.MainFragment.MineFragment;
import com.wmpscc.refreshnewclothes.R;
import com.wmpscc.refreshnewclothes.Utils.FileOperate;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements CustomTabView.OnTabCheckListener {
    private CustomTabView mCustomTabView;
    private List<Fragment> mFragments = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        if (new Json_base_info().getCilentID() == null){
            startActivity(new Intent(this, DealListActivity.class));
        }

        StaticData.fm = getSupportFragmentManager();
        mFragments.add(new HomeFragment());
        mFragments.add(new ExploreFragment());
        mFragments.add(new DesignerFragment());
        mFragments.add(new MineFragment());
        initView();

    }

    private void initFile() throws IOException {
        String baseInfoPath = "/base_info.txt";
        String baseInfoJson = "";
        FileOperate fileOperate = new FileOperate();
        if (fileOperate.hasFile(baseInfoPath)) {
            baseInfoJson = fileOperate.readSDFile(baseInfoPath);
            Log.e("content", baseInfoJson);
            Json_base_info baseInfo = JSON.parseObject(baseInfoJson, Json_base_info.class);
            Log.e("jsonread", baseInfo.getCilentID() + baseInfo.getUserName() + baseInfo.getPhotoUrl());
        } else {
            Json_base_info jsonBaseInfo = new Json_base_info();
            jsonBaseInfo.setCilentID("1234567890x");
            jsonBaseInfo.setPhotoUrl("http://p4sz2omtj.bkt.clouddn.com/FpLU3QJ5zSf9ktZv3yLvJQMoI-Ei");
            jsonBaseInfo.setUserName("HEO");
            fileOperate.writeSDFile(baseInfoPath, "" + JSON.toJSONString(jsonBaseInfo));

        }

    }


    private void initView() {
        mCustomTabView = findViewById(R.id.custom_tab_container);
        CustomTabView.Tab tabHome = new CustomTabView.Tab().setText("首页")
                .setColor(getResources().getColor(android.R.color.darker_gray))
                .setCheckedColor(getResources().getColor(android.R.color.black))
                .setNormalIcon(R.drawable.ic_home)
                .setPressedIcon(R.drawable.ic_home);
        mCustomTabView.addTab(tabHome);
        CustomTabView.Tab tabDis = new CustomTabView.Tab().setText("发现")
                .setColor(getResources().getColor(android.R.color.darker_gray))
                .setCheckedColor(getResources().getColor(android.R.color.black))
                .setNormalIcon(R.drawable.ic_explore)
                .setPressedIcon(R.drawable.ic_explore);
        mCustomTabView.addTab(tabDis);
        CustomTabView.Tab tabAttention = new CustomTabView.Tab().setText("设计师")
                .setColor(getResources().getColor(android.R.color.darker_gray))
                .setCheckedColor(getResources().getColor(android.R.color.black))
                .setNormalIcon(R.drawable.ic_designer)
                .setPressedIcon(R.drawable.ic_designer);
        mCustomTabView.addTab(tabAttention);
        CustomTabView.Tab tabProfile = new CustomTabView.Tab().setText("我的")
                .setColor(getResources().getColor(android.R.color.darker_gray))
                .setCheckedColor(getResources().getColor(android.R.color.black))
                .setNormalIcon(R.drawable.ic_me)
                .setPressedIcon(R.drawable.ic_me);
        mCustomTabView.addTab(tabProfile);

        mCustomTabView.setOnTabCheckListener(this);

        mCustomTabView.setCurrentItem(0);

    }

    @Override
    public void onTabSelected(View v, int position) {
        Log.e("zhouwei", "position:" + position);
        onTabItemSelected(position);
    }

    private void onTabItemSelected(int position) {
        Fragment fragment = null;
        switch (position) {
            case 0:
                fragment = mFragments.get(0);
                break;
            case 1:
                fragment = mFragments.get(1);
                break;
            case 2:
                fragment = mFragments.get(2);
                break;
            case 3:
                fragment = mFragments.get(3);
                break;
        }
        if (fragment != null) {
            getSupportFragmentManager().beginTransaction().replace(R.id.home_container, fragment).show(fragment).commit();
        }
    }
}
