package com.example.piyush.mediaplayback;

import android.hardware.Camera;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.SurfaceHolder;
import android.view.SurfaceView;

import java.io.IOException;
import java.util.List;

public class Main3Activity extends AppCompatActivity {

    private static final String TAG = "Main3Activity";
    SurfaceView sv;
    SurfaceHolder sh;
    Camera cam;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);

        sv = (SurfaceView) findViewById(R.id.surfaceView);
        sh = sv.getHolder();

    }

    @Override
    protected void onPause() {
        super.onPause();

        cam.release();
    }

    @Override
    protected void onResume() {
        super.onResume();

        cam = Camera.open(); //open back facing camera
        Camera.Parameters params = cam.getParameters();

        List<Camera.Size> sizes = params.getSupportedPreviewSizes();

        for (Camera.Size size : sizes) {
            Log.d(TAG, "onCreate: " + size.width + "," + size.height);
        }

        params.setPreviewSize(1920, 1080);
        cam.setDisplayOrientation(90);

        sh.addCallback(new SurfaceHolder.Callback() {
            @Override
            public void surfaceCreated(SurfaceHolder holder) {
                try {
                    cam.setPreviewDisplay(sh);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

            @Override
            public void surfaceChanged(SurfaceHolder holder, int format, int width, int height) {

            }

            @Override
            public void surfaceDestroyed(SurfaceHolder holder) {

            }
        });


        cam.startPreview();
    }
}
