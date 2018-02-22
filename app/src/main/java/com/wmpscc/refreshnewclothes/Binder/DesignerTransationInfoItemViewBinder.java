package com.wmpscc.refreshnewclothes.Binder;

import android.graphics.Color;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.wmpscc.refreshnewclothes.Adapter.MagicPagerAdapter;
import com.wmpscc.refreshnewclothes.Adapter.ShowDealsViewPagerAdapter;
import com.wmpscc.refreshnewclothes.Bean.StaticData;
import com.wmpscc.refreshnewclothes.Fragment.DesignerDealDisplayFragment;
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
    private ShowDealsViewPagerAdapter mAdapter;
    private String url = "http://img5.mtime.cn/mg/2018/02/22/150753.66998933.jpg";
    private String reformType = "长袖改为短袖";

    @NonNull
    @Override
    protected ViewHolder onCreateViewHolder(@NonNull LayoutInflater inflater, @NonNull ViewGroup parent) {
        root = inflater.inflate(R.layout.item_designer_transation_info_item, parent, false);

        return new ViewHolder(root);
    }
    private void initView(){
        mViewPager = root.findViewById(R.id.designer_deal_viewpager);
        List<Fragment> fms = new ArrayList<>();
        fms.add(DesignerDealDisplayFragment.newInstance(0, reformType, url));
        fms.add(DesignerDealDisplayFragment.newInstance(1, reformType, url));
        mAdapter = new ShowDealsViewPagerAdapter(StaticData.designerDealsFm, fms);
//        mAdapter.addFragment(DesignerDealDisplayFragment.newInstance(0, reformType, url));
//        mAdapter.addFragment(DesignerDealDisplayFragment.newInstance(1, reformType, url));
        mViewPager.setAdapter(mAdapter);

    }

    @Override
    protected void onBindViewHolder(@NonNull ViewHolder holder, @NonNull DesignerTransationInfoItem designerTransationInfoItem) {
        initView();
        initMagicIndicator();
    }
    private void initMagicIndicator() {
        MagicIndicator magicIndicator = root.findViewById(R.id.magic_designer_deal);
        CircleNavigator circleNavigator = new CircleNavigator(root.getContext());
        circleNavigator.setCircleCount(2);      //圈圈数量
        circleNavigator.setCircleColor(Color.rgb(252,112,79));
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
