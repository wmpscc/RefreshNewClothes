package com.wmpscc.refreshnewclothes.Fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.wmpscc.refreshnewclothes.R;


public class DesignerDealDisplayFragment extends Fragment {
    private int order;   // 0=>改造前; 1=>改造后
    private String type;
    private String url;
    private static String bundleKey_order = "reformLabel";
    private static String bundleKey_type = "reformLable2";
    private static String bundleKey_Url = "reformLable3";
    private View mView;
    private TextView leftTextView;
    private TextView centTextView;
    private ImageView dealPhoto;

    public DesignerDealDisplayFragment() {
        // Required empty public constructor
    }


    public static DesignerDealDisplayFragment newInstance(int order, String type, String url) {
        DesignerDealDisplayFragment fragment = new DesignerDealDisplayFragment();
        Bundle args = new Bundle();
        args.putInt(bundleKey_order, order);
        args.putString(bundleKey_type, type);
        args.putString(bundleKey_Url, url);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.e("addItem", ""+1);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        mView = inflater.inflate(R.layout.fragment_designer_deal_display, container, false);
        initBundle();
        initView();
        initTextView();
        initImageView();
        return mView;
    }
    private void initBundle(){
        Bundle bundle = getArguments();
        order = bundle.getInt(bundleKey_order);
        url = bundle.getString(bundleKey_Url);
        type = bundle.getString(bundleKey_type);

    }
    private void initView() {
        leftTextView = mView.findViewById(R.id.tv_reform_display_left_label);
        centTextView = mView.findViewById(R.id.tv_reform_display_cent_label);
        dealPhoto = mView.findViewById(R.id.iv_designer_deal_photo);
    }

    private void initTextView(){
        if (order == 0)
            leftTextView.setText("前");
        else leftTextView.setText("后");
        centTextView.setText(type);
    }
    private void initImageView(){
        Glide.with(mView).load(url).into(dealPhoto);
    }

}
