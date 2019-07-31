package com.example.piyush.batterymonitor;

import android.app.Service;
import android.content.Intent;
import android.os.BatteryManager;
import android.os.IBinder;
import android.util.Log;
import android.widget.Toast;

public class BatteryMonitorService extends Service {
    private static final String TAG = "BMS";

    public BatteryMonitorService() {
    }

    @Override
    public void onCreate() {
        super.onCreate();
        Toast.makeText(BatteryMonitorService.this, "Service Created", Toast.LENGTH_SHORT).show();
    }

    @Override
    public IBinder onBind(Intent intent) {
        Log.d(TAG, "onBind: called");
        // TODO: Return the communication channel to the service.
        throw new UnsupportedOperationException("Not yet implemented");
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        Log.d(TAG, "onStartCommand: called");
//
//        int status = intent.getIntExtra(PlugStateReceiver.BATTERY_STATUS , -1);
//        int source = intent.getIntExtra(PlugStateReceiver.CHARGING_SOURCE, -1);

        Toast.makeText(BatteryMonitorService.this, "status :" + BatteryManager.EXTRA_STATUS + ", src :" + BatteryManager.EXTRA_PLUGGED, Toast.LENGTH_SHORT).show();

        return super.onStartCommand(intent, flags, startId);
        // if the service should be kept running always then use
        // return START_STICKY;
    }
}
