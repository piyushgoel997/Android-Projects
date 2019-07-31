package com.example.piyush.lect13broadcastreciever;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.support.v4.media.TransportMediator;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.telephony.TelephonyManager;
import android.util.Log;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    BroadcastReceiver otherReceiver;
    IntentFilter intentFilter;
    TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        otherReceiver = new MyBroadcastReceiver(){
            @Override
            public void onReceive(Context context, Intent intent) {
                Toast.makeText(MainActivity.this, "Battery State changed", Toast.LENGTH_SHORT).show();
            }
        };

        intentFilter = new IntentFilter(Intent.ACTION_BATTERY_CHANGED);

        // Registering receiver is the same as writing the receiver part in the manifest.

    }

    @Override
    protected void onPause() {
        unregisterReceiver(otherReceiver);
        super.onPause();
    }

    @Override
    protected void onResume() {
        super.onResume();
        registerReceiver(otherReceiver,intentFilter);
    }
}
