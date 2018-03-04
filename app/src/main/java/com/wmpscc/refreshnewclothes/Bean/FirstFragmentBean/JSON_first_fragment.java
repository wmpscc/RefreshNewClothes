package com.wmpscc.refreshnewclothes.Bean.FirstFragmentBean;

import java.util.List;

/**
 * Created by wmpscc on 2018/3/4.
 */

public class JSON_first_fragment {
    private List<TopBannerArray> TopBanner;
    private List<CommodityArray> Commodity;
    private List<TradeShowArray> TradeShow;
    private List<RecommendMessageArray> RecommendMessage;

    public List<TopBannerArray> getTopBanner() {
        return TopBanner;
    }

    public void setTopBanner(List<TopBannerArray> topBanner) {
        TopBanner = topBanner;
    }

    public List<CommodityArray> getCommodity() {
        return Commodity;
    }

    public void setCommodity(List<CommodityArray> commodity) {
        Commodity = commodity;
    }

    public List<TradeShowArray> getTradeShow() {
        return TradeShow;
    }

    public void setTradeShow(List<TradeShowArray> tradeShow) {
        TradeShow = tradeShow;
    }

    public List<RecommendMessageArray> getRecommendMessage() {
        return RecommendMessage;
    }

    public void setRecommendMessage(List<RecommendMessageArray> recommendMessage) {
        RecommendMessage = recommendMessage;
    }


}
