package com.wmpscc.refreshnewclothes.Item;


import com.wmpscc.refreshnewclothes.Bean.FirstFragmentBean.TopBannerArray;

import java.util.List;

/**
 * Created by wmpscc on 2018/2/19.
 */
public class BannerItem {
    private List<TopBannerArray> mTopBannerArray;
    public BannerItem(List<TopBannerArray> tp){
        this.mTopBannerArray = tp;
    }

    public List<TopBannerArray> getTopBannerArray() {
        return mTopBannerArray;
    }
}