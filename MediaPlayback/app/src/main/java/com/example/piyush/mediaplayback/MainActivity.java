package com.example.piyush.mediaplayback;

import android.content.Intent;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.renderscript.ScriptGroup;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import org.json.JSONException;
import org.json.JSONObject;
import org.json.JSONStringer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "MainActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        try {
            InputStream is = getResources().getAssets().open("data.json");
            BufferedReader br = new BufferedReader(new InputStreamReader(is));
            String line;
            StringBuilder sb = new StringBuilder();
            do {
                line = br.readLine();
                sb.append(line);
            } while (line != null);
            String jsonString = sb.toString();
            JSONObject jObj = new JSONObject(jsonString);
            Log.d(TAG, "onCreate: " + jObj.getString("someKey"));

        } catch (IOException e) {
            e.printStackTrace();
        } catch (JSONException e) {
            e.printStackTrace();
        }

        // Play resource raw file
//        MediaPlayer mediaPlayer = MediaPlayer.create(this, R.raw.time);
//        mediaPlayer.start();

//        Intent mediaPlaybackIntent = new Intent(this, MediaIntentService.class);
//        mediaPlaybackIntent.setAction(MediaIntentService.ACTION_PLAY);
//        startService(mediaPlaybackIntent);


    }
}
