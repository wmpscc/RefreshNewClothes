package com.wmpscc.refreshnewclothes.Binder;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.makeramen.roundedimageview.RoundedImageView;
import com.wmpscc.refreshnewclothes.Bean.SecondFragmentBean.JSON_second_fragment;
import com.wmpscc.refreshnewclothes.Item.MessageFrameItem;
import com.wmpscc.refreshnewclothes.R;
import com.wmpscc.refreshnewclothes.Utils.MessageType;
import com.zhy.autolayout.utils.AutoUtils;

import me.drakeet.multitype.ItemViewBinder;

/**
 * Created by wmpscc on 2018/2/20.
 */
public class MessageFrameItemViewBinder extends ItemViewBinder<MessageFrameItem, MessageFrameItemViewBinder.ViewHolder> {
    private int layoutId;
    private View root;
    private RoundedImageView userPhotoImageView;
    private TextView userNameTextView;
    private JSON_second_fragment mJSONSecondFragment;

    @NonNull
    @Override
    protected ViewHolder onCreateViewHolder(@NonNull LayoutInflater inflater, @NonNull ViewGroup parent) {
        root = inflater.inflate(R.layout.item_message_frame_item, parent, false);
        userNameTextView = root.findViewById(R.id.tv_user_name_message);
        userPhotoImageView = root.findViewById(R.id.iv_message_user_photo);
        return new ViewHolder(root);
    }

    @Override
    protected void onBindViewHolder(@NonNull ViewHolder holder, @NonNull MessageFrameItem messageFrameItem) {
        mJSONSecondFragment = messageFrameItem.getJSONSecondFragment();
        switch (messageFrameItem.getType()) {
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

    private void creatCell(int id) {
        FrameLayout container;
        View cell;
        cell = View.inflate(root.getContext(), id, null);
        container = root.findViewById(R.id.message_container);
        container.addView(cell);
        Glide.with(root.getContext()).load(mJSONSecondFragment.getUserPhotoUrl()).into(userPhotoImageView);
        userNameTextView.setText(mJSONSecondFragment.getUserName());
        if (mJSONSecondFragment.getType() == "text") {
            TextView plainTextView = cell.findViewById(R.id.tv_plain_text_content);
            plainTextView.setText(mJSONSecondFragment.getContent());
        } else if (mJSONSecondFragment.getType() == "picture") {
            ImageView albumImageView = cell.findViewById(R.id.iv_message_album);
            Glide.with(cell.getContext()).load(mJSONSecondFragment.getPicUrl()).into(albumImageView);
        } else if (mJSONSecondFragment.getType() == "textPicture") {
            TextView tpTextView = cell.findViewById(R.id.tv_message_content);
            ImageView tpImageView = cell.findViewById(R.id.iv_message_image);
            tpTextView.setText(mJSONSecondFragment.getText());
            Glide.with(cell.getContext()).load(mJSONSecondFragment.getPicUrl()).into(tpImageView);
        }

    }


    static class ViewHolder extends RecyclerView.ViewHolder {

        ViewHolder(View itemView) {
            super(itemView);
            AutoUtils.autoSize(itemView);

        }
    }
}
