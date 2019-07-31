package com.example.piyush.lect14filesvaing;

import android.content.Context;
import android.os.Environment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class MainActivity extends AppCompatActivity {

    public static final String TAG = "MAinActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

//        String fileDirPath = null;
//        try {
//            fileDirPath = getFilesDir().getPath();
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//        String cacheDirPath = null;
//        try {
//            cacheDirPath = getCacheDir().getPath();
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//        Log.d(TAG, "onCreate: files dir" + fileDirPath);
//        Log.d(TAG, "onCreate: cache die" + cacheDirPath);
//
//        String filename = "myfile";
//        String string = "Hello World";
//        FileOutputStream outputStream;
//
//        File myFile = new File(this.getFilesDir(), filename);
//        if (myFile.canRead()) {
//            Log.d(TAG, "onCreate: 1. can read file = " + filename);
//        }
//
//        try {
//            outputStream = openFileOutput(filename, Context.MODE_PRIVATE);
//            outputStream.write(string.getBytes());
//            outputStream.close();
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//        if (myFile.canRead()) {
//            Log.d(TAG, "onCreate: 2. can read file = " + filename);
//        }

//        Log.d(TAG, "onCreate: dirData Path" + Environment.getDataDirectory().getPath());
//        Log.d(TAG, "onCreate: dirData absPath" + Environment.getDataDirectory().getAbsolutePath());
//        try {
//            Log.d(TAG, "onCreate: dirData canPath" + Environment.getDataDirectory().getCanonicalPath());
//        } catch (IOException e) {
//            e.printStackTrace();
//        }

//        Log.d(TAG, "onCreate: extStorage path" + Environment.getExternalStorageDirectory().getPath());
//        Log.d(TAG, "onCreate: extStorage absPath" + Environment.getExternalStorageDirectory().getAbsolutePath());
//        try {
//            Log.d(TAG, "onCreate: extStorage canPath" + Environment.getExternalStorageDirectory().getCanonicalPath());
//        } catch (IOException e) {
//            e.printStackTrace();
//        }

//        Log.d(TAG, "onCreate: dlCache path" + Environment.getDownloadCacheDirectory().getPath());
//        Log.d(TAG, "onCreate: dlCache absPath" + Environment.getDownloadCacheDirectory().getAbsolutePath());
//        try {
//            Log.d(TAG, "onCreate: dlCache canPath" + Environment.getDownloadCacheDirectory().getCanonicalPath());
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//        Log.d(TAG, "onCreate: canRead " + isExternalStorageReadable());
//        Log.d(TAG, "onCreate: canWrite " + isExternalStorageWritable());
//
//        File newFile = new File(Environment.getExternalStorageDirectory(), "new_file.txt");
//        if( !newFile.isFile() ) {
//            try {
//                newFile.createNewFile();
//            } catch (IOException e) {
//                e.printStackTrace();
//            }
//        }
//        try {
//            FileOutputStream fStream = new FileOutputStream(newFile, true);
//            fStream.write("Hello".getBytes());  ////////// Java constructor overLoading. //////////
//        } catch (IOException e) {
//            e.printStackTrace();
//        }

        File newFile = new File(Environment.getExternalStorageDirectory(), "new_file.txt");

        StringBuilder stringBuilder = new StringBuilder();

        try {
            BufferedReader myReader = new BufferedReader(new InputStreamReader(new InputStream(newFile)));
            while(myReader.readLine() != null) {
                stringBuilder.append(myReader.readLine());
                stringBuilder.append("\n");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        Log.d(TAG, "onCreate: " + stringBuilder.toString());
    }

    /* Checks if external storage is available for read and write */
    public boolean isExternalStorageWritable() {
        String state = Environment.getExternalStorageState();
        if (Environment.MEDIA_MOUNTED.equals(state)) {
            Log.d(TAG, "isExternalStorageWritable: " + state);
            return true;
        }
        return false;
    }

    /* Checks if external storage is available to at least read */
    public boolean isExternalStorageReadable() {
        String state = Environment.getExternalStorageState();
        if (Environment.MEDIA_MOUNTED.equals(state) ||
                Environment.MEDIA_MOUNTED_READ_ONLY.equals(state)) {
            Log.d(TAG, "isExternalStorageReadable: " + state);
            return true;
        }
        return false;
    }

}
