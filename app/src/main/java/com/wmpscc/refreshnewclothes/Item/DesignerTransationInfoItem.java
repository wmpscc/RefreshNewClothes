package com.wmpscc.refreshnewclothes.Item;

import com.wmpscc.refreshnewclothes.Bean.DealJSONList.JSON_deal_list;

/**
 * Created by wmpscc on 2018/2/22.
 */
public class DesignerTransationInfoItem {
    private JSON_deal_list mJSONDeal;

    public DesignerTransationInfoItem(JSON_deal_list jsonDeal) {
        this.mJSONDeal = jsonDeal;
    }

    public JSON_deal_list getJSONDeal() {
        return mJSONDeal;
    }
}