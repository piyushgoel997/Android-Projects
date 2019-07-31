package com.example.piyush.batterystatus;

import android.annotation.TargetApi;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.BatteryManager;
import android.os.Build;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "MainActivity";
    BroadcastReceiver myReceiver;
    IntentFilter intentFilter;

    TextView tvStatus, tvSource, tvSrcText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tvStatus = (TextView) findViewById(R.id.status_tv);
        tvSource = (TextView) findViewById(R.id.src_tv);
        tvSrcText = (TextView) findViewById(R.id.srcText);
        tvSrcText.setVisibility(View.INVISIBLE);
        tvSource.setVisibility(View.INVISIBLE);

        myReceiver = new BroadcastReceiver() {
            @Override
            public void onReceive(Context context, Intent intent) {
                setStatus(intent.getIntExtra(BatteryManager.EXTRA_STATUS, -1));
                setSource(intent.getIntExtra(BatteryManager.EXTRA_PLUGGED, -1));
            }
        };

        intentFilter = new IntentFilter();
        intentFilter.addAction(Intent.ACTION_BATTERY_CHANGED);

    }

    @Override
    protected void onPause() {
        unregisterReceiver(myReceiver);
        super.onPause();
    }

    @Override
    protected void onResume() {
        super.onResume();
        registerReceiver(myReceiver,intentFilter);
    }

    @TargetApi(Build.VERSION_CODES.M)
    public void setStatus(int status){
        switch (status){
            case BatteryManager.BATTERY_STATUS_CHARGING :
                tvStatus.setText("CHARGING");
                tvStatus.setTextColor(getColor(R.color.green));
                tvSource.setVisibility(View.VISIBLE);
                tvSrcText.setVisibility(View.VISIBLE);
                break;
            case BatteryManager.BATTERY_STATUS_DISCHARGING :
                tvStatus.setText("DISCHARGING");
                tvStatus.setTextColor(getColor(R.color.red));
                tvSource.setVisibility(View.INVISIBLE);
                tvSrcText.setVisibility(View.INVISIBLE);
                break;
        }
    }

    public void setSource(int source) {
        switch (source){
            case BatteryManager.BATTERY_PLUGGED_AC :
                tvSource.setText("AC");
                break;
            case BatteryManager.BATTERY_PLUGGED_USB :
                tvSource.setText("USB");
                break;
        }
    }
}
