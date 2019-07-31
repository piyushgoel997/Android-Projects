package com.example.piyush.lect9asynctasknetservices;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    public static final String TAG = "MainActivity";

    Button startServBtn, stopServBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        // Expoted => means other apps can access this service.
        // Enabled => the system can automatically start this service.
        // these properties can be changed in the manifest.

        // Intent services run on another thread(asychronously).

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        startServBtn = (Button) findViewById(R.id.start_service_button);
        stopServBtn = (Button) findViewById(R.id.stop_service_button);

        Log.d(TAG, "onCreate: ");

        startServBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d(TAG, "onClick: startServ");
                MyIntentService.startActionFoo(MainActivity.this, "param1", "param2");
            }
        });

        stopServBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d(TAG, "onClick: stopServ");
                MyIntentService.startActionBaz(MainActivity.this, "param1", "param2");
            }
        });

    }
}
