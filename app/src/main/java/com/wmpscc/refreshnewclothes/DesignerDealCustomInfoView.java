package com.wmpscc.refreshnewclothes;

import android.content.Context;
import android.os.Bundle;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.wmpscc.refreshnewclothes.Bean.DesignerDealViewData;

/**
 * Created by wmpscc on 2018/2/23.
 */

public class DesignerDealCustomInfoView extends RelativeLayout {
    private View mView;
    private DesignerDealViewData mViewData;
    private TextView leftTextView;
    private TextView centTextView;
    private ImageView dealPhoto;
    private int order;   // 0=>改造前; 1=>改造后
    private String type;
    private String imgUrl;


    public DesignerDealCustomInfoView(DesignerDealViewData data) {
        super(data.context);
        mViewData = data;
        order = mViewData.order;
        type = mViewData.type;
        imgUrl = mViewData.imgUrl;
        initView(data.context);
        initTextView();
        initImageView();
    }

    public DesignerDealCustomInfoView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public DesignerDealCustomInfoView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    private void initView(Context context){
        mView = LayoutInflater.from(context).inflate(R.layout.fragment_designer_deal_display, this, true);
        leftTextView = mView.findViewById(R.id.tv_reform_display_left_label);
        centTextView = mView.findViewById(R.id.tv_reform_display_cent_label);
        dealPhoto = mView.findViewById(R.id.iv_designer_deal_photo);
    }


    private void initTextView(){
        if (order == 0)
            leftTextView.setText("前");
        else leftTextView.setText("后");
        centTextView.setText(type);
    }
    private void initImageView(){
        Glide.with(mView).load(imgUrl).into(dealPhoto);
    }

}
