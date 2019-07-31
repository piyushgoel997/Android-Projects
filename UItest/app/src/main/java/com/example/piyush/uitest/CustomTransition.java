package com.example.piyush.uitest;

import android.animation.Animator;
import android.annotation.TargetApi;
import android.content.Context;
import android.transition.Transition;
import android.transition.TransitionValues;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by Piyush on 24-07-2016.
 */
@TargetApi(21)
public class CustomTransition extends Transition {
    private static final String BACKGROUND = "com.example.piyush.uitest.colot_transition:color";

    @Override
    public void captureStartValues(TransitionValues transitionValues) {
        View view = transitionValues.view;

        transitionValues.values.put(BACKGROUND,view.getBackground())
    }

    @Override
    public void captureEndValues(TransitionValues transitionValues) {

    }

    @Override
    public Animator createAnimator(ViewGroup sceneRoot, TransitionValues startValues, TransitionValues endValues) {
        return super.createAnimator(sceneRoot, startValues, endValues);
    }
}
