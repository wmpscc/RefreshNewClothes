package com.wmpscc.refreshnewclothes.Binder;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.wmpscc.refreshnewclothes.AdImageView;
import com.wmpscc.refreshnewclothes.Item.DesignerInfoTopItem;
import com.wmpscc.refreshnewclothes.R;
import com.zhy.autolayout.utils.AutoUtils;

import me.drakeet.multitype.ItemViewBinder;

/**
 * Created by wmpscc on 2018/2/21.
 */
public class DesignerInfoTopItemViewBinder extends ItemViewBinder<DesignerInfoTopItem, DesignerInfoTopItemViewBinder.ViewHolder> {

    private AdImageView designerBackgroundPic;
    private View root;
    @NonNull
    @Override
    protected ViewHolder onCreateViewHolder(@NonNull LayoutInflater inflater, @NonNull ViewGroup parent) {
        root = inflater.inflate(R.layout.item_designer_info_top_item, parent, false);
        return new ViewHolder(root);
    }

    @Override
    protected void onBindViewHolder(@NonNull ViewHolder holder, @NonNull DesignerInfoTopItem designerInfoTopItem) {
        designerBackgroundPic = root.findViewById(R.id.iv_designer_info_background_photo);
        RequestOptions options = new RequestOptions();
        options.placeholder(R.drawable.ic_empty);
        Glide.with(root).load("http://imglf1.nosdn.127.net/img/b3hlT3pOMzhoblluZEszZWlhRnBrWmxFUG5jT2ExWko.jpg?imageView&thumbnail=502x15000&enlarge=1&type=jpg&quality=96&stripmeta=0&type=jpg%7Cwatermark&type=2&text=wqkg6Zuy6JC96Zuy6LW3IC8geXVuLWJvLmxvZnRlci5jb20=&font=bXN5aA==&gravity=southwest&dissolve=30&fontsize=360&dx=16&dy=20&stripmeta=0")
                .apply(options)
                .into(designerBackgroundPic);

    }

    static class ViewHolder extends RecyclerView.ViewHolder {

        ViewHolder(View itemView) {
            super(itemView);
            AutoUtils.autoSize(itemView);
        }
    }
}
