package com.wmpscc.refreshnewclothes.Activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import com.wmpscc.refreshnewclothes.R;

public class SettingActivity extends AppCompatActivity {
    private ImageView finishImageView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_setting);

        finishImageView = findViewById(R.id.iv_setting_finish);
        finishImageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
    }
}
