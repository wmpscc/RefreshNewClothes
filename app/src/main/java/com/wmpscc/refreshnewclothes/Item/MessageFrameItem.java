package com.wmpscc.refreshnewclothes.Item;

import com.wmpscc.refreshnewclothes.Bean.SecondFragmentBean.JSON_second_fragment;
import com.wmpscc.refreshnewclothes.Utils.MessageType;

/**
 * Created by wmpscc on 2018/2/20.
 */
public class MessageFrameItem {
    private MessageType type;
    private JSON_second_fragment mJSONSecondFragment;
    public MessageFrameItem(MessageType type, JSON_second_fragment jsonSecondFragment){
        this.type = type;
        this.mJSONSecondFragment = jsonSecondFragment;
    }

    public MessageType getType() {
        return type;
    }

    public void setType(MessageType type) {
        this.type = type;
    }

    public JSON_second_fragment getJSONSecondFragment() {
        return mJSONSecondFragment;
    }

    public void setJSONSecondFragment(JSON_second_fragment JSONSecondFragment) {
        mJSONSecondFragment = JSONSecondFragment;
    }
}