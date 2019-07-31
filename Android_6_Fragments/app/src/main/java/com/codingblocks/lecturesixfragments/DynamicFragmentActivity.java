package com.codingblocks.lecturesixfragments;

import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class DynamicFragmentActivity extends AppCompatActivity {

    public static final String TAG = "Dynamic Frag Activity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dynamic_fragment);

        final FirstFragment fragOne = new FirstFragment();
        final SecondFragment fragTwo = new SecondFragment();
        final ThirdFragment thirdFragment = new ThirdFragment();
        thirdFragment.setOnCreateViewListnerCalled(new ThirdFragment.OnCreateViewCalledListner() {
            @Override
            public void onCreateViewCalled() {
                Log.d(TAG, "onCreateViewCalled: called");
            }
        });

        final FragmentManager fragMgr = getSupportFragmentManager();

        FragmentTransaction fragTxn = fragMgr.beginTransaction();
        fragTxn.add(R.id.fragment_container, fragOne, null);
        fragTxn.commit();

        Button bOne = (Button) findViewById(R.id.button_one);
        Button bTwo = (Button) findViewById(R.id.button_two);

        bOne.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                FragmentTransaction fTxn = fragMgr.beginTransaction();
//                fTxn.replace(R.id.fragment_container, fragOne, null);
//                fTxn.commit();
                thirdFragment.newInstance("","");
            }
        });

        bTwo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d(TAG, "onClick: 2nd button clicked");

                FragmentTransaction fTxn = fragMgr.beginTransaction();
                fTxn.replace(R.id.fragment_container, thirdFragment, null);
                fTxn.commit();
                thirdFragment.myfn();
            }
        });
    }

    public void showToast() {
        Toast.makeText(DynamicFragmentActivity.this, "Hello World!", Toast.LENGTH_SHORT).show();
        Log.d(TAG, "showToast: called");
    }
}
