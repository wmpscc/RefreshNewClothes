package com.wmpscc.refreshnewclothes.Utils;

import android.util.Log;

import com.lzy.okgo.OkGo;
import com.lzy.okgo.adapter.Call;
import com.lzy.okgo.callback.StringCallback;
import com.lzy.okgo.convert.StringConvert;
import com.lzy.okgo.model.Response;

import org.json.JSONObject;

import java.util.HashMap;

import okhttp3.ResponseBody;

/**
 * Created by wmpscc on 2018/3/2.
 */

public class HTTPOP {

    public String httpGet(String url) {
        final String[] body = {""};
        OkGo.<String>get(url)
                .tag(this)
                .execute(new StringCallback() {
                    @Override
                    public void onSuccess(Response<String> response) {
                        body[0] = response.body();
                    }
                });
        return body[0];
    }

    public String postJson(String url, String params, String jsonStr) {
//        try {
//            Call<String> call = OkGo.<String>post(url)
//                    .tag(this)
//                    .upJson(jsonStr)
//                    .params("object", params)
//                    .converter(new StringConvert())
//                    .adapt();
//            Response<String> response = call.execute();
//            return response.body().toString();
//
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//        return null;



        final String[] bodyStr = {"123"};
        OkGo.<String>post(url)
                .tag(this)
                .upJson(jsonStr)
                .params("object", params)
                .execute(new StringCallback() {
                    @Override
                    public void onSuccess(Response<String> response) {}
                    @Override
                    public String convertResponse(okhttp3.Response response) throws Throwable {
                        ResponseBody body = response.body();
                        Log.e("convert", "" + body.string());
                        bodyStr[0] = body.string();
                        return body.string();

                    }
                });

        Log.e("convertOUT", "" + bodyStr[0]);
        return bodyStr[0];
    }
}
