package com.wmpscc.refreshnewclothes.Item;

import com.wmpscc.refreshnewclothes.Bean.FirstFragmentBean.TradeShowArray;

/**
 * Created by wmpscc on 2018/2/19.
 */
public class ShowDealsItem {
    private TradeShowArray mTradeShowArray;

    public ShowDealsItem(TradeShowArray ts) {
        this.mTradeShowArray = ts;
    }

    public TradeShowArray getTradeShowArray() {
        return mTradeShowArray;
    }
}