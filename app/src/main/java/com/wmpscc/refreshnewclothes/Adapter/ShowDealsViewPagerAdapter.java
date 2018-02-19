package com.wmpscc.refreshnewclothes.Adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by wmpscc on 2018/2/19.
 */

public class ShowDealsViewPagerAdapter extends FragmentPagerAdapter {
    private List<Fragment> mFragments = new ArrayList<>();
    public ShowDealsViewPagerAdapter(FragmentManager fm) {
        super(fm);
    }
    public void addFragment(Fragment fragment){
        mFragments.add(fragment);
    }

    @Override
    public Fragment getItem(int position) {
        return mFragments.get(position);
    }

    @Override
    public int getCount() {
        return mFragments.size();
    }
}
