package com.wmpscc.refreshnewclothes;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import me.drakeet.multitype.ItemViewBinder;

/**
 * Created by wmpscc on 2018/2/21.
 */
public class DesignerInfoDescribeItemViewBinder extends ItemViewBinder<DesignerInfoDescribeItem, DesignerInfoDescribeItemViewBinder.ViewHolder> {

    @NonNull
    @Override
    protected ViewHolder onCreateViewHolder(@NonNull LayoutInflater inflater, @NonNull ViewGroup parent) {
        View root = inflater.inflate(R.layout.item_designer_info_describe_item, parent, false);
        return new ViewHolder(root);
    }

    @Override
    protected void onBindViewHolder(@NonNull ViewHolder holder, @NonNull DesignerInfoDescribeItem designerInfoDescribeItem) {

    }

    static class ViewHolder extends RecyclerView.ViewHolder {

        ViewHolder(View itemView) {
            super(itemView);
        }
    }
}
