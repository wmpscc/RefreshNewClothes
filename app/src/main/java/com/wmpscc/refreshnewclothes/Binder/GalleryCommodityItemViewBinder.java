package com.wmpscc.refreshnewclothes.Binder;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.makeramen.roundedimageview.RoundedImageView;
import com.wmpscc.refreshnewclothes.Activity.CommodityDetailsActivity;
import com.wmpscc.refreshnewclothes.AutoCardView;
import com.wmpscc.refreshnewclothes.Bean.FirstFragmentBean.CommodityArray;
import com.wmpscc.refreshnewclothes.Item.GalleryCommodityItem;
import com.wmpscc.refreshnewclothes.R;
import com.zhy.autolayout.utils.AutoUtils;

import org.w3c.dom.Text;

import me.drakeet.multitype.ItemViewBinder;

/**
 * Created by wmpscc on 2018/2/19.
 */
public class GalleryCommodityItemViewBinder extends ItemViewBinder<GalleryCommodityItem, GalleryCommodityItemViewBinder.ViewHolder> {
    private CommodityArray mCommodityArray;
    private ImageView commoImageView;
    private TextView nameTextView;
    private RoundedImageView userPhotoImageView;
    private View root;
    private AutoCardView mAutoCardView;

    @NonNull
    @Override
    protected ViewHolder onCreateViewHolder(@NonNull LayoutInflater inflater, @NonNull ViewGroup parent) {
        root = inflater.inflate(R.layout.item_gallery_commodity_item, parent, false);
        initView();
        return new ViewHolder(root);
    }
    private void initView(){
        commoImageView = root.findViewById(R.id.iv_commodity_picture);
        nameTextView = root.findViewById(R.id.tv_commodity_name);
        userPhotoImageView = root.findViewById(R.id.iv_commodity_designer_photo);
        mAutoCardView = root.findViewById(R.id.card_commodity);


    }

    @Override
    protected void onBindViewHolder(@NonNull ViewHolder holder, @NonNull GalleryCommodityItem galleryCommodityItem) {
        mCommodityArray = galleryCommodityItem.getCommodityArray();

        creatView();
        openDetails();
    }

    private void openDetails(){
        final Intent intent = new Intent(root.getContext(), CommodityDetailsActivity.class);
        intent.putExtra("imgUrl", mCommodityArray.getImgUrl());
        mAutoCardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                root.getContext().startActivity(intent);
            }
        });
    }

    private void creatView(){
        nameTextView.setText(mCommodityArray.getItemName());
        Glide.with(root.getContext()).load(mCommodityArray.getMiniImgUrl()).into(commoImageView);
        Glide.with(root.getContext()).load(mCommodityArray.getUserPhotoUrl()).into(userPhotoImageView);
    }

    static class ViewHolder extends RecyclerView.ViewHolder {

        ViewHolder(View itemView) {
            super(itemView);
            AutoUtils.autoSize(itemView);
        }
    }
}
