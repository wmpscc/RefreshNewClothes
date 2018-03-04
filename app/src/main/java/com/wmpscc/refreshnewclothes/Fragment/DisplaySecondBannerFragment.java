package com.wmpscc.refreshnewclothes.Fragment;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.wmpscc.refreshnewclothes.R;


public class DisplaySecondBannerFragment extends Fragment {
    private ImageView mImageView;
    private String imgUrl;
    private View mView;

    public DisplaySecondBannerFragment() {
        // Required empty public constructor
    }


    public static DisplaySecondBannerFragment newInstance(String imgUrl) {
        DisplaySecondBannerFragment fragment = new DisplaySecondBannerFragment();
        Bundle args = new Bundle();
        args.putString("imgUrl", imgUrl);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.imgUrl = getArguments().getString("imgUrl");

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        mView = inflater.inflate(R.layout.fragment_display_second_banner, container, false);
        mImageView = mView.findViewById(R.id.iv_display_second);
        initImageView();
        return mView;
    }
    private void initImageView(){
        Glide.with(mView.getContext()).load(imgUrl).into(mImageView);
    }


}
