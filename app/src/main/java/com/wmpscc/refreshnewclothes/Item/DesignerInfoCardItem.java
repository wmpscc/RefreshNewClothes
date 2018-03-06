package com.wmpscc.refreshnewclothes.Item;

import com.wmpscc.refreshnewclothes.Bean.ThirdFragmentBean.JSON_third_fragment;

/**
 * Created by wmpscc on 2018/2/20.
 */
public class DesignerInfoCardItem {
    private JSON_third_fragment mJSONThirdFragment;
    public DesignerInfoCardItem(JSON_third_fragment jt){
        this.mJSONThirdFragment = jt;
    }

    public JSON_third_fragment getJSONThirdFragment() {
        return mJSONThirdFragment;
    }
}