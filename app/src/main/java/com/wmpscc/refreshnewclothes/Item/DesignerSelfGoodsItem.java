package com.wmpscc.refreshnewclothes.Item;

import com.wmpscc.refreshnewclothes.Bean.FirstFragmentBean.CommodityArray;

/**
 * Created by wmpscc on 2018/2/26.
 */
public class DesignerSelfGoodsItem {
    private CommodityArray mCommodityArray;

    public DesignerSelfGoodsItem(CommodityArray commodityArray) {
        this.mCommodityArray = commodityArray;
    }

    public CommodityArray getCommodityArray() {
        return mCommodityArray;
    }
}