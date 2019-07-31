package com.example.piyush.lect4intents;

import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends ActionBarActivity {

    public static final String TAG = "Main Activity";


    public static final String KEY_NAME = "myName";
    public static final int REQUEST_SECOND_ACTIVITY = 1234;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        etInput = (EditText)findViewById(R.id.et_input);
    }

    EditText etInput;

    public void goToSecondActivity(View view) {

        // Explicit intent
//        Intent i = new Intent(this,SecondActivity.class);
//        startActivity(i);

        // IMPLICIT INTENT
//        Intent i = new Intent();
//        i.setAction(Intent.ACTION_VIEW);
//        i.setData(Uri.parse("fb://piyushgoel997"));
//        startActivity(i);

        // EXTERNL INTENT for external app
//        Intent intent = new Intent("android.intent.category.LAUNCHER");
//        intent.setClassName("com.facebook.katana", "com.facebook.katana.LoginActivity");
//        startActivity(intent);



        Intent intent = new Intent(this, SecondActivity.class);
        intent.putExtra(KEY_NAME, etInput.getText().toString());    // Used to send Key : Value pairs
//        startActivity(intent);
        startActivityForResult(intent,REQUEST_SECOND_ACTIVITY);

        Log.d(TAG, "goToSecondActivity: is called");

    }


    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        Log.d(TAG, "onActivityResult: main activity");

        if(requestCode == REQUEST_SECOND_ACTIVITY && resultCode == RESULT_OK){

            TextView textView = (TextView)findViewById(R.id.tv_main_activity);
            textView.setText((data.getStringExtra(SecondActivity.KEY_RETURN_STRING)));

        }

    }
}
