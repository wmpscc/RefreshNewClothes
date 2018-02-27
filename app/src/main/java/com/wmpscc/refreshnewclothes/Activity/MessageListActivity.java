package com.wmpscc.refreshnewclothes.Activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;

import com.wmpscc.refreshnewclothes.Item.MessageListItem;
import com.wmpscc.refreshnewclothes.Binder.MessageListItemViewBinder;
import com.wmpscc.refreshnewclothes.R;

import me.drakeet.multitype.Items;
import me.drakeet.multitype.MultiTypeAdapter;

public class MessageListActivity extends AppCompatActivity {
    private RecyclerView mRecyclerView;
    private MultiTypeAdapter mAdapter;
    private Items mItems;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_message_list);
        initRecyclerView();
    }
    private void initRecyclerView(){
        mRecyclerView = findViewById(R.id.rv_message_list);
        mAdapter = new MultiTypeAdapter();
        mAdapter.register(MessageListItem.class, new MessageListItemViewBinder());
        mRecyclerView.setAdapter(mAdapter);

        mItems = new Items();
        mItems.add(new MessageListItem());
        mItems.add(new MessageListItem());
        mItems.add(new MessageListItem());
        mItems.add(new MessageListItem());
        mItems.add(new MessageListItem());
        mItems.add(new MessageListItem());
        mItems.add(new MessageListItem());

        mAdapter.setItems(mItems);
        mAdapter.notifyDataSetChanged();

    }
}
