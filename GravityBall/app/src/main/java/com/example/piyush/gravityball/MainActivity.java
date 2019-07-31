package com.example.piyush.gravityball;

import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.ImageView;
import android.widget.RelativeLayout;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements SensorEventListener{

    public static final String TAG = "MainActivity";

    ImageView ball;
    SensorManager sensorManager;
    RelativeLayout relativeLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ball = (ImageView) findViewById(R.id.ball_view);
        relativeLayout = (RelativeLayout) findViewById(R.id.relativeLayout);
        sensorManager = (SensorManager) getSystemService(Context.SENSOR_SERVICE);
        Sensor linearAccelerationSensor = sensorManager.getDefaultSensor(Sensor.TYPE_ACCELEROMETER);
        sensorManager.registerListener(this, linearAccelerationSensor, SensorManager.SENSOR_DELAY_UI);

    }

    @Override
    public void onSensorChanged(SensorEvent event) {

        int x = gravityToCoordinates(event.values)[0];
        int y = gravityToCoordinates(event.values)[1];
        Log.d(TAG, "onSensorChanged: x = " + x + ",y = " + y);
        moveBall(x, y, relativeLayout);

    }

    private void moveBall(int x, int y, RelativeLayout relativeLayout) {
        relativeLayout.setPadding(x, y, 0, 0);
    }

    public int[] gravityToCoordinates(float[] eventValues) {
        int x = (int) (((eventValues[0] - 10) / 20) * -800);
        int y = (int) (((eventValues[1] + 10) / 20) * 1200);
        return new int[] {x, y};
    }

    @Override
    public void onAccuracyChanged(Sensor sensor, int accuracy) {

    }
}
