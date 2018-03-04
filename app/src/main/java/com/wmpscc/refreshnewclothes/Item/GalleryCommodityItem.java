package com.wmpscc.refreshnewclothes.Item;

import com.wmpscc.refreshnewclothes.Bean.FirstFragmentBean.CommodityArray;

/**
 * Created by wmpscc on 2018/2/19.
 */
public class GalleryCommodityItem {
    private CommodityArray mCommodityArray;
    public GalleryCommodityItem(CommodityArray cd){
        this.mCommodityArray = cd;
    }

    public CommodityArray getCommodityArray() {
        return mCommodityArray;
    }
}