package com.wmpscc.refreshnewclothes.Item;

import com.wmpscc.refreshnewclothes.Bean.FirstFragmentBean.RecommendMessageArray;

/**
 * Created by wmpscc on 2018/2/19.
 */
public class RecomNewsItem {
    private RecommendMessageArray mRecommendMessageArray;
    public RecomNewsItem(RecommendMessageArray rm){
        this.mRecommendMessageArray = rm;
    }

    public RecommendMessageArray getRecommendMessageArray() {
        return mRecommendMessageArray;
    }
}