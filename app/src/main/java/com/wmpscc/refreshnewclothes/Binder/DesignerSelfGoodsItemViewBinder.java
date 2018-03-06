package com.wmpscc.refreshnewclothes.Binder;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.wmpscc.refreshnewclothes.Activity.CommodityDetailsActivity;
import com.wmpscc.refreshnewclothes.Bean.FirstFragmentBean.CommodityArray;
import com.wmpscc.refreshnewclothes.Item.DesignerSelfGoodsItem;
import com.wmpscc.refreshnewclothes.R;

import me.drakeet.multitype.ItemViewBinder;

/**
 * Created by wmpscc on 2018/2/26.
 */
public class DesignerSelfGoodsItemViewBinder extends ItemViewBinder<DesignerSelfGoodsItem, DesignerSelfGoodsItemViewBinder.ViewHolder> {
    private ImageView mImageView;
    private View root;
    private CommodityArray mCommodityArray;

    @NonNull
    @Override
    protected ViewHolder onCreateViewHolder(@NonNull LayoutInflater inflater, @NonNull ViewGroup parent) {
        root = inflater.inflate(R.layout.item_designer_self_goods_item, parent, false);
        initView();
        return new ViewHolder(root);
    }

    @Override
    protected void onBindViewHolder(@NonNull ViewHolder holder, @NonNull DesignerSelfGoodsItem designerSelfGoodsItem) {
        mCommodityArray = designerSelfGoodsItem.getCommodityArray();
        Glide.with(root.getContext()).load(mCommodityArray.getMiniImgUrl()).into(mImageView);

        final Intent intent = new Intent(root.getContext(), CommodityDetailsActivity.class);
        intent.putExtra("imgUrl", mCommodityArray.getImgUrl());
        mImageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                root.getContext().startActivity(new Intent(intent));
            }
        });
    }

    private void initView() {
        mImageView = root.findViewById(R.id.iv_designer_self_good);
    }


    static class ViewHolder extends RecyclerView.ViewHolder {

        ViewHolder(View itemView) {
            super(itemView);
        }
    }
}
