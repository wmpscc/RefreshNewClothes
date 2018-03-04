package com.wmpscc.refreshnewclothes.Item;

import com.wmpscc.refreshnewclothes.Bean.FirstFragmentBean.CommodityArray;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by wmpscc on 2018/2/19.
 */
public class GalleryItem {
    private List<CommodityArray> mCommodityArrays = new ArrayList<>();
    public GalleryItem(List<CommodityArray> cd){
        this.mCommodityArrays = cd;
    }

    public List<CommodityArray> getCommodityArrays() {
        return mCommodityArrays;
    }
}