package com.wmpscc.refreshnewclothes;

import android.app.Application;
import android.service.autofill.SaveCallback;

import com.avos.avoscloud.AVException;
import com.avos.avoscloud.AVInstallation;
import com.avos.avoscloud.AVOSCloud;
import com.avos.avoscloud.PushService;
import com.avos.avoscloud.im.v2.AVIMClient;
import com.wmpscc.refreshnewclothes.Activity.MainActivity;

import cn.leancloud.chatkit.LCChatKit;

/**
 * Created by wmpscc on 2018/3/6.
 */

public class ChatKitApplication extends Application {

    // appId、appKey 可以在「LeanCloud  控制台 > 设置 > 应用 Key」获取
    private final String APP_ID = "dYRQ8YfHRiILshUnfFJu2eQM-gzGzoHsz";
    private final String APP_KEY = "ye24iIK6ys8IvaISMC4Bs5WK";

    @Override
    public void onCreate() {
        super.onCreate();
        LCChatKit.getInstance().setProfileProvider(CustomUserProvider.getInstance());
        LCChatKit.getInstance().init(getApplicationContext(), APP_ID, APP_KEY);
    }
}
