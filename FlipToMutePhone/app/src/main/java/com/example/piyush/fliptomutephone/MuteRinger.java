package com.example.piyush.fliptomutephone;

import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.media.AudioManager;
import android.os.IBinder;
import android.util.Log;

public class MuteRinger extends Service implements SensorEventListener {

    public static final String TAG = "MuteRingerService";

    SensorManager sensorManager;
    AudioManager audioManager;

    public MuteRinger() {
    }

    @Override
    public IBinder onBind(Intent intent) {
        throw new UnsupportedOperationException("Not yet implemented");
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {

        Log.d(TAG, "onStartCommand: Service is started");

        sensorManager = (SensorManager) getSystemService(Context.SENSOR_SERVICE);
        Sensor accSensor = sensorManager.getDefaultSensor(Sensor.TYPE_ACCELEROMETER);
        sensorManager.registerListener(this, accSensor, SensorManager.SENSOR_DELAY_NORMAL);

        audioManager = (AudioManager) this.getSystemService(Context.AUDIO_SERVICE);

        return super.onStartCommand(intent, flags, startId);
    }

    @Override
    public void onSensorChanged(SensorEvent event) {
        // TODO How to avoid entering the if block again and again
        float z = event.values[2];
        if (z < -9) {
            // mute ringer
            Log.d(TAG, "onSensorChanged: phone should be muted, z = " + z);
            audioManager.setStreamVolume(AudioManager.STREAM_RING, 0, AudioManager.FLAG_REMOVE_SOUND_AND_VIBRATE);
            Log.d(TAG, "onSensorChanged: ");
        }
    }

    @Override
    public void onAccuracyChanged(Sensor sensor, int accuracy) {

    }
}
