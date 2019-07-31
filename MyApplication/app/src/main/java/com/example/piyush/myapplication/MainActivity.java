package com.example.piyush.myapplication;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends ActionBarActivity {


    public static final String TAG = "MainActivity";

    // create variables(objects) for each component(classes) in the xml file
    private EditText etVarOne, etVarTwo;
    private Button btnAdd, btnSub, btnMul, btnDiv;
    private TextView tvResult;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main); // xml way : /@layout/activity_main

        // giving the references of the components
        etVarOne = (EditText)findViewById(R.id.et_var_one);
        etVarTwo = (EditText)findViewById(R.id.et_var_two);

        btnAdd = (Button)findViewById(R.id.btn_add);
        btnSub = (Button)findViewById(R.id.btn_sub);
        btnMul = (Button)findViewById(R.id.btn_mul);
        btnDiv = (Button)findViewById(R.id.btn_div);

        tvResult = (TextView)findViewById(R.id.tv_result);

        /*btnAdd.setOnClickListener(new View.OnClickListener() {  // creating an on click listner for the button
            @Override
            public void onClick(View view) {        // must to implement this function since OCL is an interface
             //   int a = Integer.parseInt(etVarOne.getText().toString());   // getText o/p is editable so we have to convert it to string and Integer.parse is used to convert string to int
             //   int b = Integer.parseInt(etVarTwo.getText().toString());


                // to solve the float problem
                try {
                    // to solve the empty box case
                    // if empty put it equal to 0
                    int a = etVarOne.getText().toString().isEmpty() ? 0 : Integer.parseInt(etVarOne.getText().toString());
                    int b = etVarTwo.getText().toString().isEmpty() ? 0 : Integer.parseInt(etVarTwo.getText().toString());

                    int c = a + b;
                    tvResult.setText(String.valueOf(c));
                }catch (NumberFormatException e){
                    Log.e(TAG,"onClick:numbers are not int");
                    Toast.makeText(MainActivity.this, "Numbers are not int", Toast.LENGTH_SHORT).show();
                }
            }
        });*/

        View.OnClickListener clickListner = new View.OnClickListener() {   // clickListner is the reference of the OCL interface
            @Override
            public void onClick(View view) {
                try {
                    int a = etVarOne.getText().toString().isEmpty() ? 0 : Integer.parseInt(etVarOne.getText().toString());
                    int b = etVarTwo.getText().toString().isEmpty() ? 0 : Integer.parseInt(etVarTwo.getText().toString());
                    int c = 0;
                    switch (view.getId()){
                        case (R.id.btn_add):
                            c = a + b;
                            break;
                        case (R.id.btn_sub) :
                            c = a - b;
                            break;
                        case (R.id.btn_mul):
                            c = a * b;
                            break;
                        case (R.id.btn_div) :
                            c = a / b;
                            break;
                    }

                    tvResult.setText(String.valueOf(c));

                }catch (NumberFormatException e){
                    Log.e(TAG,"onClick:numbers are not int");
                    Toast.makeText(MainActivity.this, "Numbers are not int", Toast.LENGTH_SHORT).show();
                }catch (ArithmeticException e){
                    Log.e(TAG,"onClick:division by zero");
                    Toast.makeText(MainActivity.this, "Division by zero is not allowed", Toast.LENGTH_SHORT).show();
                }
            }
        };

        btnAdd.setOnClickListener(clickListner);  // giving btnAdd the reference of of the clickListner
        btnSub.setOnClickListener(clickListner);
        btnMul.setOnClickListener(clickListner);
        btnDiv.setOnClickListener(clickListner);

        Log.d(TAG, "onCreate: has been called");


    }



    @Override
    protected void onPause(){
        super.onPause();
        Log.d(TAG, "onPause: has been called");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.d(TAG, "onStop: has been called");
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.d(TAG, "onStart: has been called");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d(TAG, "onResume: has been called");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.d(TAG, "onRestart: has been called");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d(TAG, "onDestroy: has been called");
    }
}
