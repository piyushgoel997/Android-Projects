package com.example.piyush.webtxt;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.webkit.WebView;
import android.widget.Button;
import android.widget.EditText;



public class WebActivity extends ActionBarActivity {

    public static final String TAG = "Web Activity";

    private static Button goBtn;
    private static EditText etUrl;
    private static WebView webView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_web);
        goBtn = (Button)findViewById(R.id.goBtn);
        etUrl = (EditText)findViewById(R.id.etUrl);
        webView = (WebView)findViewById(R.id.webView);

        ((EditText) findViewById(R.id.etUrl)).setText(getIntent().getData().toString());

        webView.loadUrl(getIntent().getData().toString());


        Log.d(TAG, "onCreate: has been called");
    }

    public void openWebPage(View view) {

        webView.loadUrl(etUrl.getText().toString());


        Log.d(TAG, "openWebPage: has been called");
    }
}
