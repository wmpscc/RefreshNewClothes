package com.wmpscc.refreshnewclothes.Binder;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.makeramen.roundedimageview.RoundedImageView;
import com.wmpscc.refreshnewclothes.Activity.DesignerInfoActivity;
import com.wmpscc.refreshnewclothes.Bean.ThirdFragmentBean.JSON_third_fragment;
import com.wmpscc.refreshnewclothes.Item.DesignerInfoCardItem;
import com.wmpscc.refreshnewclothes.R;
import com.zhy.autolayout.utils.AutoUtils;

import org.w3c.dom.Text;

import me.drakeet.multitype.ItemViewBinder;

/**
 * Created by wmpscc on 2018/2/20.
 */
public class DesignerInfoCardItemViewBinder extends ItemViewBinder<DesignerInfoCardItem, DesignerInfoCardItemViewBinder.ViewHolder> {
    private View root;
    private ImageView designerBackgroundImageView;
    private JSON_third_fragment mJSONThirdFragment;
    private TextView userNameTextView;
    private TextView userTypeTextView;
    private RoundedImageView userPhotoImageView;


    @NonNull
    @Override
    protected ViewHolder onCreateViewHolder(@NonNull LayoutInflater inflater, @NonNull ViewGroup parent) {
        root = inflater.inflate(R.layout.item_designer_info_card_item, parent, false);
        initView();

        return new ViewHolder(root);
    }

    private void initView() {
        userNameTextView = root.findViewById(R.id.tv_designer_card_user_name);
        userPhotoImageView = root.findViewById(R.id.iv_designer_card_user_photo);
        userTypeTextView = root.findViewById(R.id.tv_designer_user_label);
        designerBackgroundImageView = root.findViewById(R.id.iv_designer_card_photo);

    }


    @Override
    protected void onBindViewHolder(@NonNull ViewHolder holder, @NonNull DesignerInfoCardItem designerInfoCardItem) {
        mJSONThirdFragment = designerInfoCardItem.getJSONThirdFragment();
        holder.setIsRecyclable(false);
        RequestOptions options = new RequestOptions();
        options.placeholder(R.drawable.ic_empty_img);
//        String longPic = "http://img5.mtime.cn/pi/2017/05/19/183505.69122615_1000X1000.jpg";
//        String widthPic = "http://img5.mtime.cn/pi/2018/01/02/094106.40699278_1000X1000.jpg";
//        String longlongPic = "http://img5.mtime.cn/pi/2018/01/30/101713.16222454_1000X1000.jpg";
        userTypeTextView.setText(mJSONThirdFragment.getUserType());
        userNameTextView.setText(mJSONThirdFragment.getUserName());
        Glide.with(root).load(mJSONThirdFragment.getUserPhotoUrl()).into(userPhotoImageView);
        Glide.with(root).load(mJSONThirdFragment.getBackgroundUrl()).apply(options).into(designerBackgroundImageView);
        action();
    }
    private void action(){
        final Intent intent = new Intent(root.getContext(), DesignerInfoActivity.class);
        intent.putExtra("PhoneNumber", mJSONThirdFragment.getPhoneNumber());
        intent.putExtra("userName", mJSONThirdFragment.getUserName());
        intent.putExtra("userType", mJSONThirdFragment.getUserType());
        intent.putExtra("backgroundUrl", mJSONThirdFragment.getBackgroundUrl());
        intent.putExtra("userPhotoUrl", mJSONThirdFragment.getUserPhotoUrl());

        designerBackgroundImageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (view.getId() == R.id.iv_designer_card_photo)
                    root.getContext().startActivity(intent);
//                    root.getContext().startActivity(new Intent(root.getContext(), DesignerInfoActivity.class));

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
