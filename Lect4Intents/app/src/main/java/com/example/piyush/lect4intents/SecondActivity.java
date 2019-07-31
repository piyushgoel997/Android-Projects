package com.example.piyush.lect4intents;

import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.EditText;
import android.widget.TextView;

public class SecondActivity extends ActionBarActivity {

    public static final String TAG = "second Activity";

    public static final String KEY_RETURN_STRING = "abc";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);


        //// More Reuseable | Debugging, Exception Handling is easy
        Intent recievedIntent = getIntent();  // getIntent() fn gets the intent which starts this app component.
        String myN = recievedIntent.getStringExtra("myName");  // Give the Str(myN) the reference to the value corresponding to the key myName

        ((TextView)findViewById(R.id.tv_second_activity)).setText("Hello " + myN);

                                 //---------OR--------// More Dynamic

//        ((TextView)findViewById(R.id.tv_second_activity)).setText("hello " + getIntent().getStringExtra("myName"));
        ////

    }

    @Override
    public void onBackPressed() {
        Intent resultIntent = new Intent();
        resultIntent.putExtra(KEY_RETURN_STRING, ((EditText)findViewById(R.id.et_return_string)).getText().toString());
        setResult(RESULT_OK, resultIntent);

        super.onBackPressed();

        Log.d(TAG, "onBackPressed: of Second activity");

    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.d(TAG, "onPause: has been called");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.d(TAG, "onStop: has been called");
    }
}
