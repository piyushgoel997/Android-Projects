package com.example.piyush.fliptomutephone;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;

public class MyReceiver extends BroadcastReceiver {

    private static final String TAG = "MyReceiver";


    public MyReceiver() {
        super();
    }

    @Override
    public void onReceive(Context context, Intent intent) {
        Log.d(TAG, "onReceive: ");
        if (intent.getAction().equals(Intent.ACTION_SCREEN_OFF)) {
            Intent muteRingerService = new Intent(context,MuteRinger.class);
            context.startService(muteRingerService);
        } else if (intent.getAction().equals(Intent.ACTION_SCREEN_ON)) {
            // stop service
        }
    }
}
