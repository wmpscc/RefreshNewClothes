package com.wmpscc.refreshnewclothes.Binder;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.wmpscc.refreshnewclothes.Activity.DealListActivity;
import com.wmpscc.refreshnewclothes.Item.MineTopInfoItem;
import com.wmpscc.refreshnewclothes.MessageListActivity;
import com.wmpscc.refreshnewclothes.MessageListItem;
import com.wmpscc.refreshnewclothes.R;
import com.zhy.autolayout.utils.AutoUtils;

import org.w3c.dom.ProcessingInstruction;

import me.drakeet.multitype.ItemViewBinder;

/**
 * Created by wmpscc on 2018/2/20.
 */
public class MineTopInfoItemViewBinder extends ItemViewBinder<MineTopInfoItem, MineTopInfoItemViewBinder.ViewHolder> {
    private TextView orderInfoTextView;
    private View root;
    private TextView messageInfoTextView;

    @NonNull
    @Override
    protected ViewHolder onCreateViewHolder(@NonNull LayoutInflater inflater, @NonNull ViewGroup parent) {
        root = inflater.inflate(R.layout.item_mine_top_info_item, parent, false);
        initView();
        return new ViewHolder(root);
    }

    @Override
    protected void onBindViewHolder(@NonNull ViewHolder holder, @NonNull MineTopInfoItem mineTopInfoItem) {

    }

    private void initView(){
        orderInfoTextView = root.findViewById(R.id.tv_order);
        messageInfoTextView = root.findViewById(R.id.tv_message);
        orderInfoTextView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                root.getContext().startActivity(new Intent(root.getContext(), DealListActivity.class));
            }
        });
        messageInfoTextView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                root.getContext().startActivity(new Intent(root.getContext(), MessageListActivity.class));
            }
        });

    }

    static class ViewHolder extends RecyclerView.ViewHolder {

        ViewHolder(View itemView) {
            super(itemView);
            AutoUtils.autoSize(itemView);

        }
    }
}
