package com.wmpscc.refreshnewclothes.Bean;

/**
 * Created by wmpscc on 2018/3/6.
 */

public class MessageCell {
    private String userPhotoUrl;
    private String cilentID;
    private String userName;
    public MessageCell(String userPhotoUrl, String userName, String cilentID){
        this.userPhotoUrl = userPhotoUrl;
        this.userName = userName;
        this.cilentID = cilentID;
    }

    public String getUserPhotoUrl() {
        return userPhotoUrl;
    }

    public String getCilentID() {
        return cilentID;
    }

    public String getUserName() {
        return userName;
    }
}
