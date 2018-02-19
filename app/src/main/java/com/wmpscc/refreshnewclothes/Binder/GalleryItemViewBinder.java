package com.wmpscc.refreshnewclothes.Binder;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.wmpscc.refreshnewclothes.Item.GalleryCommodityItem;
import com.wmpscc.refreshnewclothes.Item.GalleryItem;
import com.wmpscc.refreshnewclothes.R;
import com.zhy.autolayout.utils.AutoUtils;

import me.drakeet.multitype.ItemViewBinder;
import me.drakeet.multitype.Items;
import me.drakeet.multitype.MultiTypeAdapter;

/**
 * Created by wmpscc on 2018/2/19.
 */
public class GalleryItemViewBinder extends ItemViewBinder<GalleryItem, GalleryItemViewBinder.ViewHolder> {
    private View root;
    private RecyclerView mRecyclerView;
    private MultiTypeAdapter mAdapter;
    private Items mItems;

    @NonNull
    @Override
    protected ViewHolder onCreateViewHolder(@NonNull LayoutInflater inflater, @NonNull ViewGroup parent) {
        root = inflater.inflate(R.layout.item_gallery_item, parent, false);
        return new ViewHolder(root);
    }

    @Override
    protected void onBindViewHolder(@NonNull ViewHolder holder, @NonNull GalleryItem galleryItem) {
        initView();
        initRecycleItem();
    }
    private void initView(){
        mRecyclerView = root.findViewById(R.id.rv_gallery);
    }

    private void initRecycleItem(){
        mAdapter = new MultiTypeAdapter();
        mAdapter.register(GalleryCommodityItem.class, new GalleryCommodityItemViewBinder());

        mRecyclerView.setAdapter(mAdapter);

        mItems = new Items();
        mItems.add(new GalleryCommodityItem());
        mItems.add(new GalleryCommodityItem());
        mItems.add(new GalleryCommodityItem());
        mItems.add(new GalleryCommodityItem());
        mItems.add(new GalleryCommodityItem());

        mAdapter.setItems(mItems);
        mAdapter.notifyDataSetChanged();

    }

    static class ViewHolder extends RecyclerView.ViewHolder {

        ViewHolder(View itemView) {
            super(itemView);
            AutoUtils.autoSize(itemView);
        }
    }
}
