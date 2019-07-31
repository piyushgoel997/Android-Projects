package com.example.piyush.sensors;

import android.content.Context;
import android.graphics.Color;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Build;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.RelativeLayout;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements SensorEventListener {

    private static final String TAG = "Main Activity";
    SensorManager sensorManager;
    private long prevTimestamp;
    RelativeLayout backGround;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        backGround = (RelativeLayout) findViewById(R.id.backGround);

        sensorManager = (SensorManager) getSystemService(Context.SENSOR_SERVICE);
//        ArrayList<Sensor> sensors = new ArrayList<>(sensorManager.getSensorList(Sensor.TYPE_ALL));
//
//        for(Sensor sensor : sensors) {
//            Log.d(TAG, "sensor : name = " + sensor.getName());
//            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT_WATCH) {
//                Log.d(TAG, "sensor : type = " + sensor.getStringType());
//            }
//            if (sensor.getType() == Sensor.TYPE_ACCELEROMETER) {
//                sensorManager.registerListener(this, sensor, 1000); // => Poll Model
//            }
//        }
        Sensor accelSensor = sensorManager.getDefaultSensor(Sensor.TYPE_ACCELEROMETER);
        sensorManager.registerListener(this, accelSensor, SensorManager.SENSOR_DELAY_UI);
    }

    @Override
    public void onSensorChanged(SensorEvent event) {
        if (prevTimestamp == 0) prevTimestamp = event.timestamp;
        if (event.timestamp > (prevTimestamp + (1000 * 1000 * 1000))) {
            prevTimestamp = event.timestamp;
            //        Log.d(TAG, "onSensorChanged: sensor = " + event.sensor.getName());
            Log.d(TAG, "x = " + event.values[0]);
            Log.d(TAG, "y = " + event.values[1]);
            Log.d(TAG, "z = " + event.values[2]);

//            if(x <= -2) {
//                backGround.setBackgroundColor(Color.rgb(255, 255 - (int) (x * 25), (255 - (int) (x * 25))));
//            }
//            if (x > 2 || x > -2) {
//                backGround.setBackgroundColor(Color.rgb(255,255,255));
//            }
//            if (x >= 2) {
//                backGround.setBackgroundColor(Color.rgb((255 - (int) (x * 25)), 255 - (int) (x * 25), 255));
//            }
        }
        float x = event.values[0];
        float y = event.values[1];
        float z = event.values[2];
        letsDisco(x, y, z, backGround);

    }

    @Override
    public void onAccuracyChanged(Sensor sensor, int accuracy) {
        Log.d(TAG, "onAccuracyChanged: sensor " + sensor.getName() + ", accuracy = " + accuracy);
    }

    public void letsDisco(float x, float y, float z, View v) {
        int red = gravity2color(x);
        int green = gravity2color(y);
        int blue = gravity2color(z);

        v.setBackgroundColor(Color.argb(255, red, blue, green));
    }

    private int gravity2color(float gravity) {
        // map scale of gravity (-10 to 10) to color scale (0 to 255)
        return (int) (((gravity + 10) / 20) * 255);
    }
}
