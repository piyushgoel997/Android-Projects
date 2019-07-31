package com.example.piyush.lect8asynctask;

import android.content.Context;
import android.os.AsyncTask;
import android.os.SystemClock;
import android.util.Log;

/**
 * Created by Piyush on 6/28/2016.
 */
public class MyTask extends AsyncTask<String, Void, Long> {

    public static final String TAG = "My Task";

    private Context ctx;

    public MyTask(Context ctx) {
        this.ctx = ctx;
    }

    @Override
    protected Long doInBackground(String... params) {
        // Strings... params means zero or more strings can be passed as parameter.
        // And all of those Strings will be stored in an arraylist params.

        long startTime = SystemClock.uptimeMillis();
        long timesRun = 0;
        while ((SystemClock.uptimeMillis() - startTime) < 10000) {
            timesRun++;
        }

        return timesRun;
    }

    @Override
    protected void onPostExecute(Long aLong) {
        super.onPostExecute(aLong);

        Log.d(TAG, "onPostExecute: ran " + aLong + " times, ctx = " + ctx);
    }
}
