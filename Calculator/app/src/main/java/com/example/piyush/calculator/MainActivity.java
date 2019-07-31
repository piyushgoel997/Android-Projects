package com.example.piyush.calculator;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Switch;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends ActionBarActivity {

    private final static String TAG = "MainActivity";
    private Button btnOne, btnTwo, btnThree, btnFour, btnFive, btnSix, btnSeven, btnEight, btnNine, btnZero;
    private Button btnPlus, btnMinus, btnMultiply, btnDivide;
    private Button btnEqual, btnClear;
    private EditText numDisplay;
    private EditText operatorDisplay;


    private int prev = 0, curr = 0, flag = 0;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        btnOne = (Button) findViewById(R.id.one);
        btnTwo = (Button) findViewById(R.id.two);
        btnThree = (Button) findViewById(R.id.three);
        btnFour = (Button) findViewById(R.id.four);
        btnFive = (Button) findViewById(R.id.five);
        btnSix = (Button) findViewById(R.id.six);
        btnSeven = (Button) findViewById(R.id.seven);
        btnEight = (Button) findViewById(R.id.eight);
        btnNine = (Button) findViewById(R.id.nine);
        btnZero = (Button) findViewById(R.id.zero);
        btnPlus = (Button) findViewById(R.id.plus);
        btnMinus = (Button) findViewById(R.id.minus);
        btnMultiply = (Button) findViewById(R.id.multiply);
        btnDivide = (Button) findViewById(R.id.divide);
        btnEqual = (Button) findViewById(R.id.equal);
        btnClear = (Button) findViewById(R.id.clear);

        numDisplay = (EditText) findViewById(R.id.numDisplay);
        operatorDisplay = (EditText) findViewById(R.id.operatorDisplay);


        View.OnClickListener clickListener = new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                try {
                    switch (view.getId()) {
                        case (R.id.one):
                            numDisplay.setText(numDisplay.getText() + "1");
                            break;
                        case (R.id.two):
                            numDisplay.setText(numDisplay.getText() + "2");
                            break;
                        case (R.id.three):
                            numDisplay.setText(numDisplay.getText() + "3");
                            break;
                        case (R.id.four):
                            numDisplay.setText(numDisplay.getText() + "4");
                            break;
                        case (R.id.five):
                            numDisplay.setText(numDisplay.getText() + "5");
                            break;
                        case (R.id.six):
                            numDisplay.setText(numDisplay.getText() + "6");
                            break;
                        case (R.id.seven):
                            numDisplay.setText(numDisplay.getText() + "7");
                            break;
                        case (R.id.eight):
                            numDisplay.setText(numDisplay.getText() + "8");
                            break;
                        case (R.id.nine):
                            numDisplay.setText(numDisplay.getText() + "9");
                            break;
                        case (R.id.zero):
                            numDisplay.setText(numDisplay.getText() + "0");
                            break;
                        case (R.id.plus):
                            curr = Integer.parseInt(numDisplay.getText().toString());
                            operatorDisplay.setText(operatorDisplay.getText() + "" + curr + "+");
                            numDisplay.setText("");
                            operate();
                            flag = 1;
                            break;
                        case (R.id.minus):
                            curr = Integer.parseInt(numDisplay.getText().toString());
                            operatorDisplay.setText(operatorDisplay.getText() + "" + curr + "-");
                            numDisplay.setText("");
                            operate();
                            flag = 2;
                            break;
                        case (R.id.multiply):
                            curr = Integer.parseInt(numDisplay.getText().toString());
                            operatorDisplay.setText(operatorDisplay.getText() + "" + curr + "*");
                            numDisplay.setText("");
                            operate();
                            flag = 3;
                            break;
                        case (R.id.divide):
                            curr = Integer.parseInt(numDisplay.getText().toString());
                            operatorDisplay.setText(operatorDisplay.getText() + "" + curr + "/");
                            numDisplay.setText("");
                            operate();
                            flag = 4;
                            break;
                        case (R.id.equal):
                            curr = Integer.parseInt(numDisplay.getText().toString());
                            operate();
                            numDisplay.setText("" + curr);
                            operatorDisplay.setText("");
                            flag = 0;
                            prev = 0;
                            break;
                        case (R.id.clear):
                            prev = 0;
                            curr = 0;
                            flag = 0;
                            numDisplay.setText("");
                            operatorDisplay.setText("");
                            break;
                    }

                Log.d(TAG, "onClick: has been called");
            } catch (NumberFormatException e) {
                Log.e(TAG, "operate: No number entered");
                Toast.makeText(MainActivity.this, "Enter a number First", Toast.LENGTH_SHORT).show();
            }


        }
    };



    btnOne.setOnClickListener(clickListener);
    btnTwo.setOnClickListener(clickListener);
    btnThree.setOnClickListener(clickListener);
    btnFour.setOnClickListener(clickListener);
    btnFive.setOnClickListener(clickListener);
    btnSix.setOnClickListener(clickListener);
    btnSeven.setOnClickListener(clickListener);
    btnEight.setOnClickListener(clickListener);
    btnNine.setOnClickListener(clickListener);
    btnZero.setOnClickListener(clickListener);
    btnPlus.setOnClickListener(clickListener);
    btnMinus.setOnClickListener(clickListener);
    btnMultiply.setOnClickListener(clickListener);
    btnDivide.setOnClickListener(clickListener);
    btnEqual.setOnClickListener(clickListener);
    btnClear.setOnClickListener(clickListener);


    Log.d(TAG,"onCreate: has been called");
};

    private void operate() {
        try {
            switch (flag) {
                case 1:
                    curr += prev;
                    break;
                case 2:
                    curr = prev - curr;
                    break;
                case 3:
                    curr *= prev;
                    break;
                case 4:
                    curr = prev / curr;
                    break;
            }
        } catch (ArithmeticException e) {
            Log.e(TAG, "onClick: Division By zero");
            Toast.makeText(MainActivity.this, "Division By zero is not allowed", Toast.LENGTH_SHORT).show();
        } catch (NumberFormatException e) {
            Log.e(TAG, "operate: No number entered");
            Toast.makeText(MainActivity.this, "Enter a number First", Toast.LENGTH_SHORT).show();
        }
        prev = curr;
        Log.d(TAG, "operate: has been called");
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
