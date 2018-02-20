package com.wmpscc.refreshnewclothes.Binder;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.wmpscc.refreshnewclothes.Item.MineMenuDetailItem;
import com.wmpscc.refreshnewclothes.R;
import com.zhy.autolayout.utils.AutoUtils;

import me.drakeet.multitype.ItemViewBinder;

/**
 * Created by wmpscc on 2018/2/20.
 */
public class MineMenuDetailItemViewBinder extends ItemViewBinder<MineMenuDetailItem, MineMenuDetailItemViewBinder.ViewHolder> {
    private TextView mTextView;
    private ImageView mImageView;
    private View root;

    @NonNull
    @Override
    protected ViewHolder onCreateViewHolder(@NonNull LayoutInflater inflater, @NonNull ViewGroup parent) {
        root = inflater.inflate(R.layout.item_mine_menu_detail_item, parent, false);
        return new ViewHolder(root);
    }

    @Override
    protected void onBindViewHolder(@NonNull ViewHolder holder, @NonNull MineMenuDetailItem mineMenuDetailItem) {
        mTextView = root.findViewById(R.id.tv_menu_right_title);
        mImageView = root.findViewById(R.id.iv_menu_left_picture);
        mTextView.setText(mineMenuDetailItem.title);
        mImageView.setImageResource(mineMenuDetailItem.iconId);

    }

    static class ViewHolder extends RecyclerView.ViewHolder {

        ViewHolder(View itemView) {
            super(itemView);
            AutoUtils.autoSize(itemView);

        }
    }
}
