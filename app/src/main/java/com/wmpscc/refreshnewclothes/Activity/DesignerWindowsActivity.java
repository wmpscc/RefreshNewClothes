package com.wmpscc.refreshnewclothes.Activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import com.wmpscc.refreshnewclothes.R;
import com.wmpscc.refreshnewclothes.Utils.PermisionUtils;

public class DesignerWindowsActivity extends AppCompatActivity {
    private ImageView finishImageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_designer_windows);
        PermisionUtils.verifyStoragePermissions(this);

        initView();
    }

    private void initView(){
        finishImageView = findViewById(R.id.iv_designer_windows_finish);
    }

    public void onClick(View view) {
        switch (view.getId()){
            case R.id.iv_designer_windows_finish:
                finish();
                break;


        }


    }
}
