package com.wmpscc.refreshnewclothes.Binder;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;

import com.wmpscc.refreshnewclothes.Item.MessageFrameItem;
import com.wmpscc.refreshnewclothes.R;
import com.zhy.autolayout.utils.AutoUtils;

import me.drakeet.multitype.ItemViewBinder;

/**
 * Created by wmpscc on 2018/2/20.
 */
public class MessageFrameItemViewBinder extends ItemViewBinder<MessageFrameItem, MessageFrameItemViewBinder.ViewHolder> {
    private int layoutId;
    private View root;

    @NonNull
    @Override
    protected ViewHolder onCreateViewHolder(@NonNull LayoutInflater inflater, @NonNull ViewGroup parent) {
        root = inflater.inflate(R.layout.item_message_frame_item, parent, false);
        return new ViewHolder(root);
    }

    @Override
    protected void onBindViewHolder(@NonNull ViewHolder holder, @NonNull MessageFrameItem messageFrameItem) {
        switch (messageFrameItem.type) {
            case PlainText:
                layoutId = R.layout.cell_message_text;
                break;
            case PlainImage:
                layoutId = R.layout.cell_message_picture;
                break;
            case TextAndImage:
                layoutId = R.layout.cell_message_text_picture;
                break;
        }
        creatCell(layoutId);
    }
    private void creatCell(int id){
        FrameLayout container;
        View cell;
        cell = View.inflate(root.getContext(), id, null);
        container = root.findViewById(R.id.message_container);
        container.addView(cell);

    }


    static class ViewHolder extends RecyclerView.ViewHolder {

        ViewHolder(View itemView) {
            super(itemView);
            AutoUtils.autoSize(itemView);

        }
    }
}
