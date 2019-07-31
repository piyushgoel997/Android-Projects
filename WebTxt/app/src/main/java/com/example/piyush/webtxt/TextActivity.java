package com.example.piyush.webtxt;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.widget.TextView;

import java.net.URI;

public class TextActivity extends ActionBarActivity {

    private static TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_text);

        ((TextView)findViewById(R.id.textView)).setText(getIntent().getDataString());
    }
}
