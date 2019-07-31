package com.example.piyush.webtxt;

import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;



public class MainActivity extends ActionBarActivity {

    public static final String TAG = "Main Activity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Log.d(TAG, "onCreate: has been called");
    }


    public void goToWebViewer(View view) {
        Intent webIntent;
        webIntent = new Intent(this,WebActivity.class);
        startActivity(webIntent);

        Log.d(TAG, "goToWebViewer: has been called");
    }

    public void goToTxtViewer(View view) {
        Intent textIntent = new Intent(this,TextActivity.class);
        startActivity(textIntent);

        Log.d(TAG, "goToTxtViewer: has been called");
    }
}
