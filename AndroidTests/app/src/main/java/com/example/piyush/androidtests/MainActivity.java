package com.example.piyush.androidtests;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    Button btnCalc;
    TextView tvFare;
    EditText etkm, eTiime;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnCalc = (Button) findViewById(R.id.calculate_button);
        tvFare = (TextView) findViewById(R.id.fare_tv);
        etkm = (EditText) findViewById(R.id.km_et);
        eTiime = (EditText) findViewById(R.id.time_et);

        btnCalc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int time = Integer.valueOf(eTiime.getText().toString());
                float km = Float.valueOf(etkm.getText().toString());

                tvFare.setText("Fare : " + getFare(km,time));
            }
        });
    }


    public static float getFare(float km, int time) {
        if (km < 0 || time < 0) {
            return 0;
        }
        return (km < 2 ? 25 : ((km - 2) * 9) + 25) + (time < 15 ? 0 : (time - 15));
    }

}
