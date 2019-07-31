package com.example.piyush.lect7rev;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


/**
 * A simple {@link Fragment} subclass.
 */
public class BlankFragment extends Fragment {

    private MyListner myListner;

    public void setMyListner (MyListner myListner) {
        this.myListner = myListner;
    }


    public BlankFragment() {
        // Required empty public constructor
    }

    public static BlankFragment newInstance() {
        
        Bundle args = new Bundle();
        
        BlankFragment fragment = new BlankFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        View view = inflater.inflate(R.layout.fragment_blank, container, false);

        if (myListner != null){
            myListner.myCallback();
        }

        return view;
    }

    public interface MyListner {
        void myCallback();
    }

}
