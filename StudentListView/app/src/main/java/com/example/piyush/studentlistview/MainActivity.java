package com.example.piyush.studentlistview;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ListView;

public class MainActivity extends AppCompatActivity {

    public static final String TAG = "Main Activity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.d(TAG, "onCreate: called");
    }

    public void goToLV(View view){
        startActivity(new Intent(this, ListViewActivity.class));
        Log.d(TAG, "goToLV: called");
    }

    public void goToRV(View view){
        startActivity(new Intent(this,RecycleViewActivity.class));
        Log.d(TAG, "goToRV: called");
    }

}
