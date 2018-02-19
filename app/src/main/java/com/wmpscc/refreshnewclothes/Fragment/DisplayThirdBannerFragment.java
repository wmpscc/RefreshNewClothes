package com.wmpscc.refreshnewclothes.Fragment;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.wmpscc.refreshnewclothes.R;

public class DisplayThirdBannerFragment extends Fragment {

    public DisplayThirdBannerFragment() {
        // Required empty public constructor
    }

    public static DisplayThirdBannerFragment newInstance(String param1, String param2) {
        DisplayThirdBannerFragment fragment = new DisplayThirdBannerFragment();
        Bundle args = new Bundle();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_display_third_banner, container, false);
    }

}
