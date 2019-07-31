package com.example.piyush.uitest;

import android.animation.Animator;
import android.animation.Keyframe;
import android.animation.ObjectAnimator;
import android.animation.PropertyValuesHolder;
import android.animation.ValueAnimator;
import android.annotation.TargetApi;
import android.graphics.Color;
import android.graphics.Path;
import android.os.Build;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.BounceInterpolator;
import android.widget.TextView;
import android.widget.ViewAnimator;

public class MainActivity extends AppCompatActivity {

    CustomView customView;
    TextView textView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        textView = (TextView) findViewById(R.id.textView);
        customView = (CustomView) findViewById(R.id.customView);
        customView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                customView.setColor(Color.BLACK);
//                customView.setRadius(300);
                startAnimation();
            }
        });


    }

    @TargetApi(Build.VERSION_CODES.LOLLIPOP)
    private void startAnimation() {
//        Animator animator = ObjectAnimator.ofFloat(textView, "translationX", 0f, 600f);
//        animator.setDuration(100);
//        animator.start();

//        Path path = new Path();
//        path.moveTo(0, 0);
//        path.lineTo(0, 1000);
//        path.lineTo(1000, 1000);
//        path.lineTo(1000, 0);
//        path.lineTo(0, 0);
//
//        ValueAnimator animator1 = ObjectAnimator.ofFloat(textView, "x", "y", path);
//        animator1.setDuration(1500);
//        animator1.setInterpolator(new AccelerateDecelerateInterpolator());
//        animator1.start();

        Keyframe kf0 = Keyframe.ofFloat(0f, 0f);
        Keyframe kf1 = Keyframe.ofFloat(0.5f, 200f);
        Keyframe kf2 = Keyframe.ofFloat(1f, 400f);

        PropertyValuesHolder pvh = PropertyValuesHolder.ofKeyframe("radius", kf0, kf1, kf2); // whatever property is passed here must have a setter method

        ValueAnimator animator = ObjectAnimator.ofPropertyValuesHolder(customView,pvh);
        animator.setDuration(1000);
        animator.setInterpolator(new BounceInterpolator());
        animator.start();
    }

    public void setRadius(float value) {
        customView.setRadius(value);
    }

}
