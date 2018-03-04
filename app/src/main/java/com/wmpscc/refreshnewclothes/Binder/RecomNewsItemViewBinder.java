package com.wmpscc.refreshnewclothes.Binder;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.wmpscc.refreshnewclothes.Bean.FirstFragmentBean.RecommendMessageArray;
import com.wmpscc.refreshnewclothes.Item.RecomNewsItem;
import com.wmpscc.refreshnewclothes.R;
import com.yuyh.library.imgsel.bean.Image;
import com.zhy.autolayout.utils.AutoUtils;

import me.drakeet.multitype.ItemViewBinder;

/**
 * Created by wmpscc on 2018/2/19.
 */
public class RecomNewsItemViewBinder extends ItemViewBinder<RecomNewsItem, RecomNewsItemViewBinder.ViewHolder> {
    private RecommendMessageArray mRecommendMessageArray;
    private View root;
    private ImageView mImageView;
    private TextView mTextView;

    @NonNull
    @Override
    protected ViewHolder onCreateViewHolder(@NonNull LayoutInflater inflater, @NonNull ViewGroup parent) {
        root = inflater.inflate(R.layout.item_recom_news_item, parent, false);
        mImageView = root.findViewById(R.id.iv_recommended_news_picture);
        mTextView = root.findViewById(R.id.tv_recommended_news_content);
        return new ViewHolder(root);
    }

    @Override
    protected void onBindViewHolder(@NonNull ViewHolder holder, @NonNull RecomNewsItem recomNewsItem) {
        mRecommendMessageArray = recomNewsItem.getRecommendMessageArray();
        creatView();
    }
    private void creatView(){
        mTextView.setText(mRecommendMessageArray.getDescribe());
        Glide.with(root.getContext()).load(mRecommendMessageArray.getImgUrl()).into(mImageView);
    }


    static class ViewHolder extends RecyclerView.ViewHolder {

        ViewHolder(View itemView) {
            super(itemView);
            AutoUtils.autoSize(itemView);
        }
    }
}
