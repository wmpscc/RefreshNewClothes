package com.wmpscc.refreshnewclothes.Adapter;

import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.support.v4.view.PagerAdapter;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by wmpscc on 2018/2/22.
 */

public class DealsViewPagerAdapter extends PagerAdapter {
    private List<View> mFragments = new ArrayList<>();

    public void addFragment(Fragment fragment) {
        View view = new View(fragment.getContext());
        mFragments.add(view);
    }

    @NonNull
    @Override
    public Object instantiateItem(@NonNull ViewGroup container, int position) {
        container.addView(mFragments.get(position));
        return mFragments.get(position);
    }

    @Override
    public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
        container.removeView(mFragments.get(position));
    }

    @Override
    public int getCount() {
        return mFragments.size();
    }

    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object object) {
        return view == object;
    }
}
