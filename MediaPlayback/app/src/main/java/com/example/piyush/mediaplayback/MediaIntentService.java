package com.example.piyush.mediaplayback;

import android.app.IntentService;
import android.content.Intent;
import android.content.Context;
import android.media.MediaPlayer;
import android.util.Log;

public class MediaIntentService extends IntentService implements MediaPlayer.OnPreparedListener{
    public static final String ACTION_PLAY = "play";
    private static final String TAG = "MediaIntentService";
    MediaPlayer mMediaPlayer;

    /**
     * Creates an IntentService.  Invoked by your subclass's constructor.
     *
     * @param name Used to name the worker thread, important only for debugging.
     */
    public MediaIntentService(String name) {
        super(name);
    }

    @Override
    protected void onHandleIntent(Intent intent) {

        if (intent.getAction().equals(ACTION_PLAY)) {
            Log.d(TAG, "onHandleIntent: 1");
            mMediaPlayer = MediaPlayer.create(this, R.raw.time);
            mMediaPlayer.setOnPreparedListener(this);
            mMediaPlayer.prepareAsync(); // prepare async to not block main thread
        }

    }

    @Override
    public void onPrepared(MediaPlayer mp) {
        Log.d(TAG, "onPrepared: 2");
        mp.start();
    }
}
