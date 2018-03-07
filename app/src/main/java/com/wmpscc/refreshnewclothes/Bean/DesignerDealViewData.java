package com.wmpscc.refreshnewclothes.Bean;

import android.content.Context;

/**
 * Created by wmpscc on 2018/2/23.
 */

public class DesignerDealViewData {
    public String type;
    public int order;  // 0=>改造前; 1=>改造后
    public Context context;
    public String imgUrl;

    public DesignerDealViewData(Context context, String type, int order, String imgUrl){
        this.type = type;
        this.order = order;
        this.context = context;
        this.imgUrl = imgUrl;

    }
}
