package com.example.piyush.androidtests;

import android.media.MediaActionSound;
import android.support.test.annotation.UiThreadTest;
import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static junit.framework.Assert.assertEquals;

/**
 * Created by Piyush on 30-07-2016.
 */

@RunWith(AndroidJUnit4.class)  // translates all the junit4 fns to junit3
public class MainActivityTest {

//    @Rule
//    int a = 10;
//
//    @Rule
//    int b = 11;
//
//    @Before
//    public void beforeTest() {
//        a = a + b;
//    }
//
//    @Test
//    public void someTest() {
//        junit.framework.Assert.assertEquals(21, a);
//    }

    MainActivity mainAct;

    @Rule
    public final ActivityTestRule<MainActivity> act = new ActivityTestRule<MainActivity>(MainActivity.class);

    @Before
    public void setUpActivity() throws Exception {
        mainAct = act.getActivity();
    }

    @After
    public void finishActivity() throws Exception{
        mainAct.finish();
    }

    @UiThreadTest @Test
    public void simpleFareTest() throws Exception {
        ((EditText) mainAct.findViewById(R.id.time_et)).setText("16");
        ((EditText) mainAct.findViewById(R.id.km_et)).setText("3");

        mainAct.runOnUiThread(new Runnable() {
            @Override
            public void run() {
                ((Button) mainAct.findViewById(R.id.calculate_button)).callOnClick();
            }
        });

        assertEquals("Fare : 35.0", ((TextView) mainAct.findViewById(R.id.fare_tv)).getText());
    }
}

//travis
//heroku
//flyrefresh