package com.wmpscc.refreshnewclothes.Bean;

import android.content.Context;

/**
 * Created by wmpscc on 2018/2/23.
 */

public class DesignerDealViewData {
    public String url;
    public String type;
    public int order;  // 0=>改造前; 1=>改造后
    public Context context;

    public DesignerDealViewData(Context context, String url, String type, int order){
        this.url = url;
        this.type = type;
        this.order = order;
        this.context = context;

    }
}
