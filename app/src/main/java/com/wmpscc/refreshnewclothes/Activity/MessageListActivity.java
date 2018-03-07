package com.wmpscc.refreshnewclothes.Activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;

import com.wmpscc.refreshnewclothes.Bean.GlobalData;
import com.wmpscc.refreshnewclothes.Bean.MessageCell;
import com.wmpscc.refreshnewclothes.Item.MessageListItem;
import com.wmpscc.refreshnewclothes.Binder.MessageListItemViewBinder;
import com.wmpscc.refreshnewclothes.R;
import com.wmpscc.refreshnewclothes.Utils.PermisionUtils;

import me.drakeet.multitype.Items;
import me.drakeet.multitype.MultiTypeAdapter;

public class MessageListActivity extends AppCompatActivity {
    private RecyclerView mRecyclerView;
    private MultiTypeAdapter mAdapter;
    private Items mItems;
    private ImageView finishImageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_message_list);
        PermisionUtils.verifyStoragePermissions(this);

        initRecyclerView();
        finishImageView = findViewById(R.id.iv_message_list_finish);
        finishImageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
    }

    private void initRecyclerView() {
        mRecyclerView = findViewById(R.id.rv_message_list);
        mAdapter = new MultiTypeAdapter();
        mAdapter.register(MessageListItem.class, new MessageListItemViewBinder());
        mRecyclerView.setAdapter(mAdapter);

        mItems = new Items();
        for (int i = 0; i < GlobalData.sMessageCellList.size(); i++) {
            mItems.add(new MessageListItem(GlobalData.sMessageCellList.get(i)));
        }

        mAdapter.setItems(mItems);
        mAdapter.notifyDataSetChanged();

    }
}
