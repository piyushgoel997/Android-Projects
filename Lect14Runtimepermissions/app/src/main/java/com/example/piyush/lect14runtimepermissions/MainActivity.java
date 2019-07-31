package com.example.piyush.lect14runtimepermissions;

import android.Manifest;
import android.annotation.TargetApi;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Environment;
import android.support.annotation.NonNull;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class MainActivity extends AppCompatActivity {

    public static final String TAG = "MainActivity";

    static String[] reqPerms = new String[]{
            Manifest.permission.READ_EXTERNAL_STORAGE,
            Manifest.permission.WRITE_EXTERNAL_STORAGE

    };

    Button btnWriteFile;

    static int REQUEST_CODESTORAGE_PERM = 445;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnWriteFile = (Button) findViewById(R.id.btn_write_file);
        btnWriteFile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (hasWritePerm()) {
                    writeMyFile();
                } else {
                    askWritePerm();
                }
            }


        });

        int permissionStatus = ContextCompat.checkSelfPermission(MainActivity.this, Manifest.permission.READ_EXTERNAL_STORAGE);

//            switch (permissionStatus) {
//                case PackageManager.PERMISSION_GRANTED :
//                    Log.d(TAG, "onCreate: Permission Granted");
//                    break;
//                case PackageManager.PERMISSION_DENIED :
//                    Log.d(TAG, "onCreate: Permission Denied");
//                    break;
//            }

        if (permissionStatus == PackageManager.PERMISSION_DENIED) {
            ActivityCompat.requestPermissions(this,reqPerms, REQUEST_CODESTORAGE_PERM);
        }

    }

    private void askWritePerm() {
        ActivityCompat.requestPermissions(this, reqPerms, REQUEST_CODESTORAGE_PERM);
    }

    private boolean hasWritePerm() {
        return (ContextCompat.checkSelfPermission(MainActivity.this, Manifest.permission.WRITE_EXTERNAL_STORAGE) == PackageManager.PERMISSION_GRANTED);
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {

        if (requestCode == REQUEST_CODESTORAGE_PERM) {
            if (grantResults.length > 0) {
//                for (String perm : permissions) {
//                    Log.d(TAG, "onRequestPermissionsResult: " + perm);
//                }
//                for (int res : grantResults) {
//                    Log.d(TAG, "onRequestPermissionsResult: " + res);
//                }
                if (grantResults[1] == PackageManager.PERMISSION_GRANTED) {
                    writeMyFile();
                }
            }
        }

        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
    }

    public void writeMyFile() {
        File myFile = new File(Environment.getExternalStorageDirectory(), "myfile");

        FileOutputStream myOutputStream = null;
        try {
            myOutputStream = new FileOutputStream(myFile);
            myOutputStream.write(0);
            myOutputStream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

}
