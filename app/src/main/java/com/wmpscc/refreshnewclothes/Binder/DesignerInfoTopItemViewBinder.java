package com.wmpscc.refreshnewclothes.Binder;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.avos.avoscloud.im.v2.AVIMClient;
import com.avos.avoscloud.im.v2.AVIMException;
import com.avos.avoscloud.im.v2.callback.AVIMClientCallback;
import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.makeramen.roundedimageview.RoundedImageView;
import com.wmpscc.refreshnewclothes.Activity.LogonActivity;
import com.wmpscc.refreshnewclothes.AdImageView;
import com.wmpscc.refreshnewclothes.Bean.GlobalData;
import com.wmpscc.refreshnewclothes.Bean.MessageCell;
import com.wmpscc.refreshnewclothes.Item.DesignerInfoTopItem;
import com.wmpscc.refreshnewclothes.R;
import com.zhy.autolayout.utils.AutoUtils;

import org.w3c.dom.Text;

import cn.leancloud.chatkit.LCChatKit;
import cn.leancloud.chatkit.activity.LCIMConversationActivity;
import cn.leancloud.chatkit.utils.LCIMConstants;
import me.drakeet.multitype.ItemViewBinder;

/**
 * Created by wmpscc on 2018/2/21.
 */
public class DesignerInfoTopItemViewBinder extends ItemViewBinder<DesignerInfoTopItem, DesignerInfoTopItemViewBinder.ViewHolder> {
    private String userName;
    private String userType;
    private String backgroundUrl;
    private String userPhotoUrl;
    private String PhoneNumber;
    private AdImageView designerBackgroundPic;
    private RoundedImageView userPhotoImageView;
    private TextView userNameTextView;
    private TextView designerTypeTextView;
    private Button callDesignerButton;
    private View root;

    protected ViewHolder onCreateViewHolder(@NonNull LayoutInflater inflater, @NonNull ViewGroup parent) {
        root = inflater.inflate(R.layout.item_designer_info_top_item, parent, false);
        initView();
        return new ViewHolder(root);
    }
    private void initView(){
        designerBackgroundPic = root.findViewById(R.id.iv_designer_info_background_photo);
        userPhotoImageView = root.findViewById(R.id.iv_designer_info_user_photo);
        userNameTextView = root.findViewById(R.id.tv_designer_name);
        designerTypeTextView = root.findViewById(R.id.tv_designer_type);
        callDesignerButton = root.findViewById(R.id.bt_call_designer_info);
        callDesignerButton.setOnClickListener(mOnClickListener);
    }

    @Override
    protected void onBindViewHolder(@NonNull ViewHolder holder, @NonNull DesignerInfoTopItem designerInfoTopItem) {
        userName = designerInfoTopItem.getUserName();
        userType = designerInfoTopItem.getUserType();
        backgroundUrl = designerInfoTopItem.getBackgroundUrl();
        userPhotoUrl = designerInfoTopItem.getUserPhotoUrl();
        PhoneNumber = designerInfoTopItem.getPhoneNumber();

        designerTypeTextView.setText(userType);
        userNameTextView.setText(userName);

        RequestOptions options = new RequestOptions();
        options.placeholder(R.drawable.ic_empty_img);
        Glide.with(root).load(backgroundUrl)
                .apply(options)
                .into(designerBackgroundPic);
        Glide.with(root.getContext()).load(userPhotoUrl).apply(options).into(userPhotoImageView);
    }

    private void openConversation(String userID) {
        LCChatKit.getInstance().open(userID, new AVIMClientCallback() {
            @Override
            public void done(AVIMClient avimClient, AVIMException e) {
                if (null == e) {
//                    finish();
                    Intent intent = new Intent(root.getContext(), LCIMConversationActivity.class);
                    intent.putExtra(LCIMConstants.PEER_ID, GlobalData.sJSON_post_logon.getNumber() + "");
                    root.getContext().startActivity(intent);
                } else {
                    Toast.makeText(root.getContext(), e.toString(), Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
    static class ViewHolder extends RecyclerView.ViewHolder {

        ViewHolder(View itemView) {
            super(itemView);
            AutoUtils.autoSize(itemView);
        }
    }

    private View.OnClickListener mOnClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            switch (view.getId()){
                case R.id.bt_call_designer_info:
                    GlobalData.sMessageCellList.add(new MessageCell(userPhotoUrl, userName, PhoneNumber));
                    openConversation(PhoneNumber);
                    break;
            }
        }
    };
}
