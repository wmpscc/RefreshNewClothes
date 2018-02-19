package com.wmpscc.refreshnewclothes;

import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import com.wmpscc.refreshnewclothes.Bean.StaticData;
import com.wmpscc.refreshnewclothes.CustomTabView.CustomTabView;
import com.wmpscc.refreshnewclothes.MainFragment.DesignerFragment;
import com.wmpscc.refreshnewclothes.MainFragment.ExploreFragment;
import com.wmpscc.refreshnewclothes.MainFragment.HomeFragment;
import com.wmpscc.refreshnewclothes.MainFragment.MineFragment;

public class MainActivity extends AppCompatActivity implements CustomTabView.OnTabCheckListener {
    private CustomTabView mCustomTabView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        StaticData.fm = getSupportFragmentManager();
        initView();
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
        Log.e("zhouwei","position:"+position);
        onTabItemSelected(position);
    }

    private void onTabItemSelected(int position){
        Fragment fragment = null;
        switch (position){
            case 0:
                fragment = new HomeFragment();
                break;
            case 1:
                fragment = new ExploreFragment();
                break;

            case 2:
                fragment = new DesignerFragment();
                break;
            case 3:
                fragment = new MineFragment();
                break;
        }
        if(fragment!=null) {
            getSupportFragmentManager().beginTransaction().replace(R.id.home_container,fragment).commit();
        }
    }
}
