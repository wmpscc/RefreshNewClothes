package com.wmpscc.refreshnewclothes.Bean;

import java.util.StringTokenizer;

/**
 * Created by wmpscc on 2018/3/4.
 */

public class JSON_test {
    private jsonData data;
    private String msg;
    private int code;

    public class jsonData {
        private String upload;

        public String getUpload() {
            return upload;
        }

        public void setUpload(String upload) {
            this.upload = upload;
        }
    }


    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }
}
