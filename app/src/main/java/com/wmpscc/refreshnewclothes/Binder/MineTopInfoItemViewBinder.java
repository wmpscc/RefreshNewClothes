package com.wmpscc.refreshnewclothes.Binder;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.makeramen.roundedimageview.RoundedImageView;
import com.wmpscc.refreshnewclothes.Activity.DealListActivity;
import com.wmpscc.refreshnewclothes.Activity.DesignerWindowsActivity;
import com.wmpscc.refreshnewclothes.Bean.GlobalData;
import com.wmpscc.refreshnewclothes.Item.MineTopInfoItem;
import com.wmpscc.refreshnewclothes.Activity.MessageListActivity;
import com.wmpscc.refreshnewclothes.R;
import com.wmpscc.refreshnewclothes.Activity.SettingActivity;
import com.wmpscc.refreshnewclothes.Activity.UserBaseInfoActivity;
import com.zhy.autolayout.utils.AutoUtils;

import me.drakeet.multitype.ItemViewBinder;

/**
 * Created by wmpscc on 2018/2/20.
 */
public class MineTopInfoItemViewBinder extends ItemViewBinder<MineTopInfoItem, MineTopInfoItemViewBinder.ViewHolder> {
    private TextView orderInfoTextView;
    private View root;
    private TextView messageInfoTextView;
    private ImageButton settingButton;
    private ImageButton edBaseButton;
    private static View.OnClickListener mListener;
    private RoundedImageView userPhotoImageView;
    private TextView userNameTextView;
    private TextView designerWindowsTextView;

    @NonNull
    @Override
    protected ViewHolder onCreateViewHolder(@NonNull LayoutInflater inflater, @NonNull ViewGroup parent) {
        root = inflater.inflate(R.layout.item_mine_top_info_item, parent, false);
        initView();
        return new ViewHolder(root);
    }

    @Override
    protected void onBindViewHolder(@NonNull ViewHolder holder, @NonNull MineTopInfoItem mineTopInfoItem) {
        userNameTextView.setText(GlobalData.sJson_base_info.getUserName());
        Glide.with(root.getContext()).load(GlobalData.sJson_base_info.getPhotoUrl()).into(userPhotoImageView);
    }

    private void initView() {
        userNameTextView = root.findViewById(R.id.tv_mine_name);
        userPhotoImageView = root.findViewById(R.id.iv_mine_user_photo);

        orderInfoTextView = root.findViewById(R.id.tv_order);
        messageInfoTextView = root.findViewById(R.id.tv_message);
        settingButton = root.findViewById(R.id.ib_start_setting);
        edBaseButton = root.findViewById(R.id.ib_edit_base_message);
        designerWindowsTextView = root.findViewById(R.id.tv_designerWindows);

        mListener = new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                switch (view.getId()) {
                    case R.id.tv_order:
                        root.getContext().startActivity(new Intent(root.getContext(), DealListActivity.class));
                        break;
                    case R.id.tv_message:
                        root.getContext().startActivity(new Intent(root.getContext(), MessageListActivity.class));
                        break;
                    case R.id.ib_start_setting:
                        root.getContext().startActivity(new Intent(root.getContext(), SettingActivity.class));
                        break;
                    case R.id.ib_edit_base_message:
                        root.getContext().startActivity(new Intent(root.getContext(), UserBaseInfoActivity.class));
                        break;
                    case R.id.tv_designerWindows:
                        root.getContext().startActivity(new Intent(root.getContext(), DesignerWindowsActivity.class));
                        break;
                }
            }
        };
        orderInfoTextView.setOnClickListener(mListener);
        messageInfoTextView.setOnClickListener(mListener);
        settingButton.setOnClickListener(mListener);
        edBaseButton.setOnClickListener(mListener);
        designerWindowsTextView.setOnClickListener(mListener);

    }

    static class ViewHolder extends RecyclerView.ViewHolder {

        ViewHolder(View itemView) {
            super(itemView);
            AutoUtils.autoSize(itemView);

        }
    }


}
