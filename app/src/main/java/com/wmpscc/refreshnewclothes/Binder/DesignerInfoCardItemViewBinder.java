package com.wmpscc.refreshnewclothes.Binder;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Matrix;
import android.graphics.Point;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.Transformation;
import com.bumptech.glide.load.engine.Resource;
import com.bumptech.glide.request.RequestOptions;
import com.wmpscc.refreshnewclothes.DesignerInfoActivity;
import com.wmpscc.refreshnewclothes.Item.DesignerInfoCardItem;
import com.wmpscc.refreshnewclothes.MainActivity;
import com.wmpscc.refreshnewclothes.R;
import com.zhy.autolayout.utils.AutoUtils;

import java.security.MessageDigest;

import me.drakeet.multitype.ItemViewBinder;

/**
 * Created by wmpscc on 2018/2/20.
 */
public class DesignerInfoCardItemViewBinder extends ItemViewBinder<DesignerInfoCardItem, DesignerInfoCardItemViewBinder.ViewHolder> {
    private View root;
    private ImageView mImageView;


    @NonNull
    @Override
    protected ViewHolder onCreateViewHolder(@NonNull LayoutInflater inflater, @NonNull ViewGroup parent) {
        root = inflater.inflate(R.layout.item_designer_info_card_item, parent, false);
        initView();

        return new ViewHolder(root);
    }

    private void initView() {
        mImageView = root.findViewById(R.id.iv_designer_card_photo);
        mImageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (view.getId() == R.id.iv_designer_card_photo)
                    root.getContext().startActivity(new Intent(root.getContext(), DesignerInfoActivity.class));

            }
        });
    }


    @Override
    protected void onBindViewHolder(@NonNull ViewHolder holder, @NonNull DesignerInfoCardItem designerInfoCardItem) {
        holder.setIsRecyclable(false);
        RequestOptions options = new RequestOptions();
        options.placeholder(R.drawable.ic_empty);


        String longPic = "http://img5.mtime.cn/pi/2017/05/19/183505.69122615_1000X1000.jpg";
        String widthPic = "http://img5.mtime.cn/pi/2018/01/02/094106.40699278_1000X1000.jpg";
        String longlongPic = "http://img5.mtime.cn/pi/2018/01/30/101713.16222454_1000X1000.jpg";
        Glide.with(root).load(widthPic).apply(options).into(mImageView);

    }

    static class ViewHolder extends RecyclerView.ViewHolder {

        ViewHolder(View itemView) {
            super(itemView);
            AutoUtils.autoSize(itemView);

        }
    }
}
