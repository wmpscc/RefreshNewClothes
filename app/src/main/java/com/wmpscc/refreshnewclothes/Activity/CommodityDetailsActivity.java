package com.wmpscc.refreshnewclothes.Activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.wmpscc.refreshnewclothes.AdImageView;
import com.wmpscc.refreshnewclothes.R;
import com.wmpscc.refreshnewclothes.Utils.PermisionUtils;
import com.yuyh.library.imgsel.bean.Image;

public class CommodityDetailsActivity extends AppCompatActivity {
    private String imgUrl;
    private ImageView topImageView;
    private ImageView detailsImageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_commodity_details);
        PermisionUtils.verifyStoragePermissions(this);

        dueIntent();
        initView();
        refreshView();
    }
    private void initView(){
        topImageView = findViewById(R.id.iv_commodity_photo);
        detailsImageView = findViewById(R.id.iv_commodity_describe_photo);
    }
    private void refreshView(){
        Glide.with(this).load(imgUrl).into(topImageView);
        Glide.with(this).load(imgUrl).into(detailsImageView);
    }


    private void dueIntent(){
        imgUrl = getIntent().getStringExtra("imgUrl");
    }
}
