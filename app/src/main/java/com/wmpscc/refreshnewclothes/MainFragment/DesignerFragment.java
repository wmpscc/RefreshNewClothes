package com.wmpscc.refreshnewclothes.MainFragment;

import android.content.Context;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.wmpscc.refreshnewclothes.Adapter.MagicPagerAdapter;
import com.wmpscc.refreshnewclothes.Fragment.DesignerCloseFragment;
import com.wmpscc.refreshnewclothes.Fragment.DesignerFocusFragment;
import com.wmpscc.refreshnewclothes.Fragment.DesignerRecommendFragment;
import com.wmpscc.refreshnewclothes.R;

import net.lucode.hackware.magicindicator.MagicIndicator;
import net.lucode.hackware.magicindicator.ViewPagerHelper;
import net.lucode.hackware.magicindicator.buildins.commonnavigator.CommonNavigator;
import net.lucode.hackware.magicindicator.buildins.commonnavigator.abs.CommonNavigatorAdapter;
import net.lucode.hackware.magicindicator.buildins.commonnavigator.abs.IPagerIndicator;
import net.lucode.hackware.magicindicator.buildins.commonnavigator.abs.IPagerTitleView;
import net.lucode.hackware.magicindicator.buildins.commonnavigator.indicators.TriangularPagerIndicator;
import net.lucode.hackware.magicindicator.buildins.commonnavigator.titles.SimplePagerTitleView;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class DesignerFragment extends Fragment {
    private View mView;
    private List<String> titles = new ArrayList<>();
    private ViewPager mViewPager;

    public DesignerFragment() {
        // Required empty public constructor
        titles.add("我的关注");
        titles.add("推荐");
        titles.add("离我最近");
    }


    public static DesignerFragment newInstance(String param1, String param2) {
        DesignerFragment fragment = new DesignerFragment();
        Bundle args = new Bundle();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    private void initViewPager() {
        MagicPagerAdapter adapter = new MagicPagerAdapter(getChildFragmentManager());
        mViewPager = mView.findViewById(R.id.designer_view_pager);
        adapter.addFragment(new DesignerFocusFragment());
        adapter.addFragment(new DesignerRecommendFragment());
        adapter.addFragment(new DesignerCloseFragment());

        mViewPager.setAdapter(adapter);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        mView = inflater.inflate(R.layout.fragment_designer, container, false);
        initViewPager();
        initMagicIndicator();
        return mView;
    }

    private void initMagicIndicator() {
        MagicIndicator magicIndicator = mView.findViewById(R.id.designer_magic_indicator);
        magicIndicator.setBackgroundColor(Color.WHITE);
        CommonNavigator commonNavigator = new CommonNavigator(mView.getContext());
        commonNavigator.setScrollPivotX(0.15f);
        commonNavigator.setAdapter(new CommonNavigatorAdapter() {
            @Override
            public int getCount() {
                return titles == null ? 0 : titles.size();
            }

            @Override
            public IPagerTitleView getTitleView(Context context, final int index) {
                SimplePagerTitleView simplePagerTitleView = new SimplePagerTitleView(context);
                simplePagerTitleView.setText(titles.get(index));
                simplePagerTitleView.setNormalColor(Color.parseColor("#333333"));
                simplePagerTitleView.setSelectedColor(Color.parseColor("#FC704F"));
                simplePagerTitleView.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        mViewPager.setCurrentItem(index);
                    }
                });
                return simplePagerTitleView;
            }

            @Override
            public IPagerIndicator getIndicator(Context context) {
                TriangularPagerIndicator indicator = new TriangularPagerIndicator(context);
                indicator.setLineColor(Color.parseColor("#FC704F"));
                return indicator;
            }
        });
        magicIndicator.setNavigator(commonNavigator);
        ViewPagerHelper.bind(magicIndicator, mViewPager);
    }

}
