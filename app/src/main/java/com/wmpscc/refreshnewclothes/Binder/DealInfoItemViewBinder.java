package com.wmpscc.refreshnewclothes.Binder;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.wmpscc.refreshnewclothes.Item.DealInfoItem;
import com.wmpscc.refreshnewclothes.Activity.KuaiDiInfoActivity;
import com.wmpscc.refreshnewclothes.R;

import me.drakeet.multitype.ItemViewBinder;

/**
 * Created by wmpscc on 2018/2/26.
 */
public class DealInfoItemViewBinder extends ItemViewBinder<DealInfoItem, DealInfoItemViewBinder.ViewHolder> {
    private Button kuaDiInfoButton;
    private View root;

    @NonNull
    @Override
    protected ViewHolder onCreateViewHolder(@NonNull LayoutInflater inflater, @NonNull ViewGroup parent) {
        root = inflater.inflate(R.layout.item_deal_info_item, parent, false);
        initView();
        return new ViewHolder(root);
    }

    @Override
    protected void onBindViewHolder(@NonNull ViewHolder holder, @NonNull DealInfoItem dealInfoItem) {

    }
    private void initView(){
        kuaDiInfoButton = root.findViewById(R.id.bt_kuaidi_info);
        kuaDiInfoButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                root.getContext().startActivity(new Intent(root.getContext(), KuaiDiInfoActivity.class));

            }
        });

    }


    static class ViewHolder extends RecyclerView.ViewHolder {

        ViewHolder(View itemView) {
            super(itemView);
        }
    }
}
