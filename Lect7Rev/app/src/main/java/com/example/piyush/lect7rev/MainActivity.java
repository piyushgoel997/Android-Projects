package com.example.piyush.lect7rev;

import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    public static final String TAG = "Main Activity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        Log.d(TAG, "onCreate: called");

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


//        Button b = (Button) findViewById(R.id.button);
//
//        final MyLoop looper = new MyLoop();
//
//        MyLoop.LoopDoneListner loopDoneListner = new MyLoop.LoopDoneListner() {
//            @Override
//            public void onLoopDone() {
//                Toast.makeText(MainActivity.this, "loop is done", Toast.LENGTH_SHORT).show();
//            }
//        };
//
//        looper.setLoopDoneListner(loopDoneListner);
//
//        looper.doLoop();
//
//        b.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                looper.doLoop();
//            }
//        });


//        b.setOnLongClickListener(new View.OnLongClickListener() {
//            @Override
//            public boolean onLongClick(View v) {
//                return false;
//            }
//        });

        BlankFragment blankFragment = new BlankFragment();
        blankFragment.setMyListner(new BlankFragment.MyListner() {
            @Override
            public void myCallback() {
                Toast.makeText(MainActivity.this, "frag is made", Toast.LENGTH_SHORT).show();
            }
        });

        FragmentManager fragmentManager = getSupportFragmentManager();

        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.add(R.id.frame_layout,blankFragment,null);
        fragmentTransaction.commit();
    }
}
