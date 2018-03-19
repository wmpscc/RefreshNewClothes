package com.wmpscc.refreshnewclothes.Utils;

import android.os.Environment;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * Created by wmpscc on 2018/3/1.
 */

public class FileOperate {
    private String homePath;

    public FileOperate() {
        this.homePath = Environment.getExternalStorageDirectory().getPath();
        File file = new File(homePath + "/refreshnewclothes/");
        if (!file.exists()) {
            file.mkdirs();
        }
        homePath = file.getAbsolutePath();
    }

    public String getHomePath() {
        return homePath;
    }

    public boolean hasFile(String path) {
        File file = new File(homePath + path);
        if (!file.exists())
            return false;
        else return true;
    }

    public String readSDFile(String fileName) throws IOException {

        File file = new File(homePath + fileName);

        FileInputStream fis = new FileInputStream(file);

        int length = fis.available();

        byte[] buffer = new byte[length];
        fis.read(buffer);

        String res = new String(buffer, "UTF-8");

        fis.close();
        return res;
    }

    //写文件
    public void writeSDFile(String fileName, String write_str) throws IOException {

        File file = new File(homePath + fileName);
        if (!file.exists()) {
            file.createNewFile();
        }

        FileOutputStream fos = new FileOutputStream(file);

        byte[] bytes = write_str.getBytes();

        fos.write(bytes);

        fos.close();
    }
}
