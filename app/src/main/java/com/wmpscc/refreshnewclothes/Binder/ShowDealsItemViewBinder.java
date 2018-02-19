package com.wmpscc.refreshnewclothes.Binder;

import android.support.annotation.NonNull;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.wmpscc.refreshnewclothes.Adapter.ShowDealsViewPagerAdapter;
import com.wmpscc.refreshnewclothes.Fragment.DisplayFirstBannerFragment;
import com.wmpscc.refreshnewclothes.Fragment.DisplaySecondBannerFragment;
import com.wmpscc.refreshnewclothes.Fragment.DisplayThirdBannerFragment;
import com.wmpscc.refreshnewclothes.Item.ShowDealsItem;
import com.wmpscc.refreshnewclothes.R;
import com.wmpscc.refreshnewclothes.Bean.StaticData;
import com.zhy.autolayout.utils.AutoUtils;

import me.drakeet.multitype.ItemViewBinder;

/**
 * Created by wmpscc on 2018/2/19.
 */
public class ShowDealsItemViewBinder extends ItemViewBinder<ShowDealsItem, ShowDealsItemViewBinder.ViewHolder> {
    private View root;
    private ViewPager mViewPager;
    @NonNull
    @Override
    protected ViewHolder onCreateViewHolder(@NonNull LayoutInflater inflater, @NonNull ViewGroup parent) {
        root = inflater.inflate(R.layout.item_show_deals_item, parent, false);
        return new ViewHolder(root);
    }

    @Override
    protected void onBindViewHolder(@NonNull ViewHolder holder, @NonNull ShowDealsItem showDealsItem) {
        initViewPager();
    }
    private void initViewPager(){
        StaticData staticData = new StaticData();
        mViewPager = root.findViewById(R.id.show_deals_viewpager);
        ShowDealsViewPagerAdapter adapter = new ShowDealsViewPagerAdapter(staticData.fm);
        adapter.addFragment(new DisplayFirstBannerFragment());
        adapter.addFragment(new DisplaySecondBannerFragment());
        adapter.addFragment(new DisplayThirdBannerFragment());
        mViewPager.setAdapter(adapter);
    }


    static class ViewHolder extends RecyclerView.ViewHolder {

        ViewHolder(View itemView) {
            super(itemView);
            AutoUtils.autoSize(itemView);
        }
    }
}
