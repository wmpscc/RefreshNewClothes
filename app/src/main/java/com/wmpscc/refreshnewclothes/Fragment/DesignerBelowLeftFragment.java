package com.wmpscc.refreshnewclothes.Fragment;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.wmpscc.refreshnewclothes.R;

public class DesignerBelowLeftFragment extends Fragment {

    public DesignerBelowLeftFragment() {
        // Required empty public constructor
    }


    public static DesignerBelowLeftFragment newInstance(String param1, String param2) {
        DesignerBelowLeftFragment fragment = new DesignerBelowLeftFragment();
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
        return inflater.inflate(R.layout.fragment_designer_below_left, container, false);
    }


}
