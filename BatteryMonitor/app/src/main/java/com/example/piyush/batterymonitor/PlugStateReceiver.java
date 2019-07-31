package com.example.piyush.batterymonitor;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.BatteryManager;
import android.util.Log;

public class PlugStateReceiver extends BroadcastReceiver {

    public static final String BATTERY_STATUS = "batteryStatus";
    public static final String CHARGING_SOURCE = "chargingSource";
    private static final String TAG = "PlugStateReceiver";

    public PlugStateReceiver() {
    }

    @Override
    public void onReceive(Context context, Intent intent) {
        Log.d(TAG, "onReceive: " + intent.getAction());

        Intent i = new Intent(context,BatteryMonitorService.class);
//        i.putExtra(BATTERY_STATUS, getStatus(intent.getIntExtra(BatteryManager.EXTRA_STATUS, -1)));
//        i.putExtra(CHARGING_SOURCE, getSource(intent.getIntExtra(BatteryManager.EXTRA_PLUGGED, -1)));
        context.startService(i);
    }

//    public String getStatus(int status){
//        switch (status){
//            case BatteryManager.BATTERY_STATUS_CHARGING :
//               return "CHARGING";
//            case BatteryManager.BATTERY_STATUS_DISCHARGING :
//                return "DISCHARGING";
//        }
//        return "";
//    }
//
//    public String getSource(int source) {
//        switch (source){
//            case BatteryManager.BATTERY_PLUGGED_AC :
//                return "AC";
//            case BatteryManager.BATTERY_PLUGGED_USB :
//                return "USB";
//        }
//        return "";
//    }
}
