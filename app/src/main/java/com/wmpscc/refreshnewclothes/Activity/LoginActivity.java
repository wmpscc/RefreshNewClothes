package com.wmpscc.refreshnewclothes.Activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.wmpscc.refreshnewclothes.R;
import com.wmpscc.refreshnewclothes.Utils.PermisionUtils;

public class LoginActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        PermisionUtils.verifyStoragePermissions(this);

    }
}
