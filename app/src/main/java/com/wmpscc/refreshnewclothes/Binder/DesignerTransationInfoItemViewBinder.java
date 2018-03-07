package com.wmpscc.refreshnewclothes.Binder;

import android.graphics.Color;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.wmpscc.refreshnewclothes.Adapter.DealsViewPagerAdapter;
import com.wmpscc.refreshnewclothes.Adapter.MagicPagerAdapter;
import com.wmpscc.refreshnewclothes.Adapter.ShowDealsViewPagerAdapter;
import com.wmpscc.refreshnewclothes.Adapter.ViewPagerAdapter;
import com.wmpscc.refreshnewclothes.Bean.DealJSONList.JSON_deal_list;
import com.wmpscc.refreshnewclothes.Bean.DesignerDealViewData;
import com.wmpscc.refreshnewclothes.Bean.StaticData;
import com.wmpscc.refreshnewclothes.DesignerDealCustomInfoView;
import com.wmpscc.refreshnewclothes.Fragment.DesignerDealDisplayFragment;
import com.wmpscc.refreshnewclothes.Fragment.SearchReformFragment;
import com.wmpscc.refreshnewclothes.Item.DesignerTransationInfoItem;
import com.wmpscc.refreshnewclothes.R;
import com.zhy.autolayout.utils.AutoUtils;

import net.lucode.hackware.magicindicator.MagicIndicator;
import net.lucode.hackware.magicindicator.ViewPagerHelper;
import net.lucode.hackware.magicindicator.buildins.circlenavigator.CircleNavigator;

import java.util.ArrayList;
import java.util.List;

import me.drakeet.multitype.ItemViewBinder;

/**
 * Created by wmpscc on 2018/2/22.
 */
public class DesignerTransationInfoItemViewBinder extends ItemViewBinder<DesignerTransationInfoItem, DesignerTransationInfoItemViewBinder.ViewHolder> {

    private View root;
    private ViewPager mViewPager;
    private ViewPagerAdapter mAdapter;
    private String reformType = "长袖改为短袖";
    private FragmentManager mFragmentManager;
    private JSON_deal_list mJSONDeal;

    @NonNull
    @Override
    protected ViewHolder onCreateViewHolder(@NonNull LayoutInflater inflater, @NonNull ViewGroup parent) {
        root = inflater.inflate(R.layout.item_designer_transation_info_item, parent, false);
        return new ViewHolder(root);
    }

    private void newInitView() {
        mViewPager = root.findViewById(R.id.designer_deal_viewpager);
        mAdapter = new ViewPagerAdapter();

        DesignerDealCustomInfoView view = new DesignerDealCustomInfoView(new DesignerDealViewData(root.getContext(), reformType, 0, mJSONDeal.getBeforeUrl()));
        mAdapter.addView(view);
        view = new DesignerDealCustomInfoView(new DesignerDealViewData(root.getContext(), reformType, 1, mJSONDeal.getAfterUrl()));
        mAdapter.addView(view);

        mViewPager.setAdapter(mAdapter);
    }

    @Override
    protected void onBindViewHolder(@NonNull ViewHolder holder, @NonNull DesignerTransationInfoItem designerTransationInfoItem) {
        mJSONDeal = designerTransationInfoItem.getJSONDeal();
        newInitView();
        initMagicIndicator();

    }

    public DesignerTransationInfoItemViewBinder(FragmentManager fm) {
        mFragmentManager = fm;

    }

    private void initMagicIndicator() {
        MagicIndicator magicIndicator = root.findViewById(R.id.magic_designer_deal);
        CircleNavigator circleNavigator = new CircleNavigator(root.getContext());
        circleNavigator.setCircleCount(2);      //圈圈数量
        circleNavigator.setCircleColor(Color.rgb(252, 112, 79));
        circleNavigator.setCircleClickListener(new CircleNavigator.OnCircleClickListener() {
            @Override
            public void onClick(int index) {
                mViewPager.setCurrentItem(index);
            }
        });
        magicIndicator.setNavigator(circleNavigator);
        ViewPagerHelper.bind(magicIndicator, mViewPager);
    }

    static class ViewHolder extends RecyclerView.ViewHolder {

        ViewHolder(View itemView) {
            super(itemView);
            AutoUtils.autoSize(itemView);
        }
    }
}
