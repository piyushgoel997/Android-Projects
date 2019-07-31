package com.example.piyush.alarmmanager;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.os.SystemClock;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Intent i = new Intent(this, MyService.class);

        PendingIntent pi = PendingIntent.getService(this, 111, i, 0);
//        try {
//            pi.send();  // send this intent to the os so that it can call it later when required
//        } catch (PendingIntent.CanceledException e) {
//            e.printStackTrace();
//        }


        // it will be used to send the pending intent again and again after some time
        AlarmManager alarmManager = (AlarmManager) getSystemService(ALARM_SERVICE);
        alarmManager.setRepeating(
                AlarmManager.ELAPSED_REALTIME_WAKEUP,
                //wakeup => this wake up the phone and will not allow it to go to sleep while this task is being performed
                //(This is used for the tasks which require internet connection, read/write in sd card,require network connection)
                SystemClock.elapsedRealtime(),
                1 * 60 * 1000,
                pi
        ); // this will keep on running until stopped

        alarmManager.cancel(pi);  // to stop the alarm for the pending intent
        // the pi object need not be the same but data of the pi should be same
        // i.e. i can write another pi with the same code but diff name and cancelling it will cancel this.
    }
}
