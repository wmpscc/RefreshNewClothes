package com.wmpscc.refreshnewclothes.Activity;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.parser.DefaultJSONParser;
import com.avos.avoscloud.im.v2.AVIMClient;
import com.avos.avoscloud.im.v2.AVIMException;
import com.avos.avoscloud.im.v2.callback.AVIMClientCallback;
import com.lzy.okgo.OkGo;
import com.lzy.okgo.callback.StringCallback;
import com.lzy.okgo.model.Response;
import com.wmpscc.refreshnewclothes.Bean.GlobalData;
import com.wmpscc.refreshnewclothes.Bean.JSON_post_logon;
import com.wmpscc.refreshnewclothes.Bean.JSON_test;
import com.wmpscc.refreshnewclothes.Bean.Json_base_info;
import com.wmpscc.refreshnewclothes.Bean.StaticData;
import com.wmpscc.refreshnewclothes.R;
import com.wmpscc.refreshnewclothes.Utils.HTTPOP;
import com.wmpscc.refreshnewclothes.Utils.PermisionUtils;

import cn.leancloud.chatkit.LCChatKit;
import cn.leancloud.chatkit.activity.LCIMConversationActivity;
import cn.leancloud.chatkit.utils.LCIMConstants;


public class LogonActivity extends AppCompatActivity {
    private EditText numberEdit;
    private EditText passwordEdit;
    private Button logonButton;
    private Button startLoginButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_logon);
        PermisionUtils.verifyStoragePermissions(this);
        initView();

    }

    private void initView() {
        startLoginButton = findViewById(R.id.bt_toRegisteredActivity_login_activity);
        numberEdit = findViewById(R.id.et_number_logon_activity);
        passwordEdit = findViewById(R.id.et_password_logon_activity);
        logonButton = findViewById(R.id.bt_logon_button);
        logonButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                logonServer();
            }
        });

    }

    private void logonServer() {
        if ("".equals(numberEdit.getText().toString()) || "".equals(passwordEdit.getText().toString())){
            Toast.makeText(this, "请正确输入用户名和密码!", Toast.LENGTH_SHORT).show();
            return;
        }
        final String number = numberEdit.getText().toString();
        String password = passwordEdit.getText().toString();
        JSON_post_logon jsonPostLogon = new JSON_post_logon();
        jsonPostLogon.setNumber(number);
        jsonPostLogon.setPassword(password);
        GlobalData.sJSON_post_logon = jsonPostLogon;
        OkGo.<String>post(StaticData.testUrl)
                .tag(this)
                .upJson(JSON.toJSONString(jsonPostLogon))
                .params("object", "logon")
                .execute(new StringCallback() {
                    @Override
                    public void onSuccess(Response<String> response) {
                        Toast.makeText(LogonActivity.this, "登录成功!", Toast.LENGTH_SHORT).show();
                        initChat(number);
                        startActivity(new Intent(LogonActivity.this, MainActivity.class));
                    }
                });
    }



    private void initChat(String userID) {
        LCChatKit.getInstance().open(userID, new AVIMClientCallback() {
            @Override
            public void done(AVIMClient avimClient, AVIMException e) {
                if (null == e) {
                    // 成功

                } else {
                }
            }
        });
    }

}
