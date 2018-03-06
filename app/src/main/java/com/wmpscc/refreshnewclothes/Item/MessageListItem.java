package com.wmpscc.refreshnewclothes.Item;

import com.wmpscc.refreshnewclothes.Bean.MessageCell;


/**
 * Created by wmpscc on 2018/2/26.
 */
public class MessageListItem {
    private MessageCell mMessageCell;

    public MessageListItem(MessageCell messageCell) {
        this.mMessageCell = messageCell;
    }

    public MessageCell getMessageCell() {
        return mMessageCell;
    }
}