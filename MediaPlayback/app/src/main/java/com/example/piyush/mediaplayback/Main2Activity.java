package com.example.piyush.mediaplayback;

import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.MediaController;
import android.widget.VideoView;

public class Main2Activity extends AppCompatActivity {

    VideoView videoView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        videoView = (VideoView) findViewById(R.id.videoView);

        MediaController mediaController = new MediaController(this);

        mediaController.setAnchorView(videoView);
        videoView.setMediaController(mediaController);

        videoView.setVideoURI(Uri.parse("android.resource://" + getPackageName() + "/raw/video"));

        videoView.start();
    }
}
