package com.wmpscc.refreshnewclothes.Binder;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;

import com.wmpscc.refreshnewclothes.Activity.SearchActivity;
import com.wmpscc.refreshnewclothes.Bean.FirstFragmentBean.TopBannerArray;
import com.wmpscc.refreshnewclothes.Utils.GlideImageLoader;
import com.wmpscc.refreshnewclothes.Item.BannerItem;
import com.wmpscc.refreshnewclothes.R;
import com.youth.banner.Banner;
import com.youth.banner.BannerConfig;
import com.youth.banner.Transformer;
import com.zhy.autolayout.utils.AutoUtils;

import java.util.ArrayList;
import java.util.List;

import me.drakeet.multitype.ItemViewBinder;

/**
 * Created by wmpscc on 2018/2/19.
 */
public class BannerItemViewBinder extends ItemViewBinder<BannerItem, BannerItemViewBinder.ViewHolder> {
    private ImageButton searchButton;
    private Banner mBanner;
    private View root;
    private List<String> imgUrl = new ArrayList<>();
    private List<String> title = new ArrayList<>();
    private List<TopBannerArray> mTopBannerArrays = new ArrayList<>();

    @NonNull
    @Override
    protected ViewHolder onCreateViewHolder(@NonNull LayoutInflater inflater, @NonNull ViewGroup parent) {
        root = inflater.inflate(R.layout.item_banner_item, parent, false);
        return new ViewHolder(root);
    }

    @Override
    protected void onBindViewHolder(@NonNull ViewHolder holder, @NonNull BannerItem bannerItem) {
        mTopBannerArrays = bannerItem.getTopBannerArray();
        initBanner();
        initView();
    }
    private void initView(){
        searchButton = root.findViewById(R.id.ib_search_home_pager);
        searchButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                root.getContext().startActivity(new Intent(root.getContext(), SearchActivity.class));
            }
        });
    }

    private void initBanner(){
        for (int i = 0; i < mTopBannerArrays.size(); i++) {
            imgUrl.add(mTopBannerArrays.get(i).getImgUrl());
            title.add(mTopBannerArrays.get(i).getTitle());
        }

        mBanner = root.findViewById(R.id.home_pager_banner);
        //设置banner样式
        mBanner.setBannerStyle(BannerConfig.CIRCLE_INDICATOR_TITLE_INSIDE);
        //设置图片加载器
        mBanner.setImageLoader(new GlideImageLoader());
        //设置图片集合
        mBanner.setImages(imgUrl);
        //设置标题集合
        mBanner.setBannerTitles(title);
        //设置banner动画效果
        mBanner.setBannerAnimation(Transformer.FlipHorizontal);
        //设置自动轮播，默认为true
        mBanner.isAutoPlay(true);
        //设置轮播时间
        mBanner.setDelayTime(2500);
        //设置指示器位置（当banner模式中有指示器时）
        mBanner.setIndicatorGravity(BannerConfig.RIGHT);
        //banner设置方法全部调用完毕时最后调用
        mBanner.start();
    }

    static class ViewHolder extends RecyclerView.ViewHolder {

        ViewHolder(View itemView) {
            super(itemView);
            AutoUtils.autoSize(itemView);
        }
    }
}
