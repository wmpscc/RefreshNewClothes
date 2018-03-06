package com.wmpscc.refreshnewclothes.Item;

/**
 * Created by wmpscc on 2018/2/21.
 */
public class DesignerInfoTopItem {
    private String userName;
    private String userType;
    private String backgroundUrl;
    private String userPhotoUrl;
    private String PhoneNumber;
    public DesignerInfoTopItem(String userName, String userType, String backgroundUrl, String userPhotoUrl, String PhoneNumber){
        this.userName = userName;
        this.userType = userType;
        this.backgroundUrl = backgroundUrl;
        this.userPhotoUrl = userPhotoUrl;
        this.PhoneNumber = PhoneNumber;
    }

    public String getUserName() {
        return userName;
    }

    public String getUserType() {
        return userType;
    }

    public String getBackgroundUrl() {
        return backgroundUrl;
    }

    public String getUserPhotoUrl() {
        return userPhotoUrl;
    }

    public String getPhoneNumber() {
        return PhoneNumber;
    }
}