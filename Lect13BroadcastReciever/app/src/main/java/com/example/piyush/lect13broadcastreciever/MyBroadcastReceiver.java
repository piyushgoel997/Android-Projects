package com.example.piyush.lect13broadcastreciever;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.telephony.TelephonyManager;
import android.util.Log;

/**
 * Created by Piyush on 14-07-2016.
 */
public class MyBroadcastReceiver extends BroadcastReceiver {

    public static final String TAG = "MyBroadcastReceiver";

    public MyBroadcastReceiver() {
    }

    @Override
    public void onReceive(Context context, Intent intent) {
        Log.d(TAG, "onReceive: " + intent.getAction()
        + "\n" + intent.getDataString()
        + "\n" + intent.getStringExtra(TelephonyManager.EXTRA_STATE));
    }
}
