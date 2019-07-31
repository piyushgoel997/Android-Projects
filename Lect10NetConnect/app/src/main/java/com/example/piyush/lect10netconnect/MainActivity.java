package com.example.piyush.lect10netconnect;

import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    public static final String TAG = "MainActivity";

    Button btnDownload;
    TextView tv1, tvName, tvType, tvTopic, tvLoc;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnDownload = (Button) findViewById(R.id.btn_download);
        tvName = (TextView) findViewById(R.id.event_name);
        tvLoc = (TextView) findViewById(R.id.event_loc);
        tvTopic = (TextView) findViewById(R.id.event_topic);
        tvType = (TextView) findViewById(R.id.event_type);



        btnDownload.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d(TAG, "onClick: ");
                checkConnection();
            }
        });

    }

    public void checkConnection() {
        Log.d(TAG, "checkConnection: ");
        ConnectivityManager cMgr = (ConnectivityManager) getSystemService(CONNECTIVITY_SERVICE);
        NetworkInfo networkInfo = cMgr.getActiveNetworkInfo();
        if (networkInfo != null && networkInfo.isConnected()){
            NetFetchTask netFetchTask = new NetFetchTask(new NetFetchTask.PostExecuteListener(){
                @Override
                public void postExecuteDone(Event event) {
                    Log.d(TAG, "postExecuteDone: ");
                    tvName.setText(event.getEventName());
                    tvTopic.setText(event.getEventTopic());
                    tvLoc.setText(event.getEventLoc());
                    tvType.setText(event.getEventLoc());
                }
            });
            netFetchTask.execute("http://open-event.herokuapp.com/api/v2/events/4");
        }else{
            Toast.makeText(MainActivity.this, "Will not work without internet", Toast.LENGTH_SHORT).show();
        }
    }

}
