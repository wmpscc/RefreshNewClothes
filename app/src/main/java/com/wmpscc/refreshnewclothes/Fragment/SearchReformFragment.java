package com.wmpscc.refreshnewclothes.Fragment;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.wmpscc.refreshnewclothes.R;


public class SearchReformFragment extends Fragment {

    public SearchReformFragment() {
        // Required empty public constructor
    }


    public static SearchReformFragment newInstance(String param1, String param2) {
        SearchReformFragment fragment = new SearchReformFragment();
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
        return inflater.inflate(R.layout.fragment_search_reform, container, false);
    }

}
