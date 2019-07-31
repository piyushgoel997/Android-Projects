package com.example.piyush.fragments;

import android.support.v4.app.Fragment;
import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

/**
 * Created by Piyush on 6/23/2016.
 */
public class FragmentTwo extends Fragment {

    TextView fragName;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View rootView = inflater.inflate(R.layout.fragment_two, container, false);
        fragName = (TextView)rootView.findViewById(R.id.fragment_one);
        fragName.setTextColor(Color.RED);

        return rootView;
    }
}
