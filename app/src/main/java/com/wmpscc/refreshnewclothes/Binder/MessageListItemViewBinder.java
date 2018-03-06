package com.wmpscc.refreshnewclothes.Binder;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.avos.avoscloud.im.v2.AVIMClient;
import com.avos.avoscloud.im.v2.AVIMException;
import com.avos.avoscloud.im.v2.callback.AVIMClientCallback;
import com.bumptech.glide.Glide;
import com.makeramen.roundedimageview.RoundedImageView;
import com.wmpscc.refreshnewclothes.Activity.LogonActivity;
import com.wmpscc.refreshnewclothes.Bean.GlobalData;
import com.wmpscc.refreshnewclothes.Bean.MessageCell;
import com.wmpscc.refreshnewclothes.Item.MessageListItem;
import com.wmpscc.refreshnewclothes.R;
import com.zhy.autolayout.utils.AutoUtils;

import cn.leancloud.chatkit.LCChatKit;
import cn.leancloud.chatkit.activity.LCIMConversationActivity;
import cn.leancloud.chatkit.utils.LCIMConstants;
import me.drakeet.multitype.ItemViewBinder;

/**
 * Created by wmpscc on 2018/2/26.
 */
public class MessageListItemViewBinder extends ItemViewBinder<MessageListItem, MessageListItemViewBinder.ViewHolder> {
    private RoundedImageView userPhotoImageView;
    private TextView designerNameTextView;
    private TextView messageDescribeTextView;
    private View root;
    private MessageCell mMessageCell;
    private RelativeLayout mRelativeLayout;

    @NonNull
    @Override
    protected ViewHolder onCreateViewHolder(@NonNull LayoutInflater inflater, @NonNull ViewGroup parent) {
        root = inflater.inflate(R.layout.item_message_list_item, parent, false);
        initView();
        return new ViewHolder(root);
    }
    private void initView(){
        userPhotoImageView = root.findViewById(R.id.iv_message_list_user_photo);
        designerNameTextView = root.findViewById(R.id.tv_user_name_list);
        messageDescribeTextView = root.findViewById(R.id.tv_belief_content);
        mRelativeLayout = root.findViewById(R.id.message_layout);

    }
    private void openConversation() {
        LCChatKit.getInstance().open(mMessageCell.getCilentID(), new AVIMClientCallback() {
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

    @Override
    protected void onBindViewHolder(@NonNull ViewHolder holder, @NonNull MessageListItem messageListItem) {
        mMessageCell = messageListItem.getMessageCell();
        refreshView();
        mRelativeLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openConversation();
            }
        });
    }
    private void refreshView(){
        designerNameTextView.setText(mMessageCell.getUserName());
        messageDescribeTextView.setText("点击查看详情");
        Glide.with(root.getContext()).load(mMessageCell.getUserPhotoUrl()).into(userPhotoImageView);

    }

    static class ViewHolder extends RecyclerView.ViewHolder {

        ViewHolder(View itemView) {
            super(itemView);
            AutoUtils.autoSize(itemView);
        }
    }
}
