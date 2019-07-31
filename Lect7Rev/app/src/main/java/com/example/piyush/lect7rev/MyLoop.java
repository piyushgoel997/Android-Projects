package com.example.piyush.lect7rev;

import android.os.SystemClock;
import android.util.Log;

/**
 * Created by Piyush on 6/28/2016.
 */
public class MyLoop {

    private static final String TAG = "My Loop";

    private LoopDoneListner ldl;

    public void setLoopDoneListner (LoopDoneListner doneListner){
        ldl = doneListner;
    }

    public void doLoop () {
        long startTime = SystemClock.uptimeMillis();
        while ((SystemClock.uptimeMillis() - startTime) < 10000 ) {

        }
        Log.d(TAG, "doLoop: is done");
        ldl.onLoopDone();
    }

    public interface LoopDoneListner {
        void onLoopDone();   // This is a Callback.
    }

}
