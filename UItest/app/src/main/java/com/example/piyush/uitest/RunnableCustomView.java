package com.example.piyush.uitest;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;

/**
 * Created by Piyush on 24-07-2016.
 */
public class RunnableCustomView extends View {

    float radius = 0;
    Paint paint;

    private Runnable animateLine = new Runnable() {
        @Override
        public void run() {
            boolean reachedEnd = false;
            radius += 10;
            if (radius <= 400) {
                invalidate();
            } else {
                reachedEnd = true;
            }
            if (!reachedEnd) {
                postDelayed(this, 15);
            }
        }
    };

    public RunnableCustomView(Context context) {
        super(context);
        init();
    }

    public RunnableCustomView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public void init() {
        paint = new Paint();
        paint.setColor(Color.BLACK);
//        paint.setStrokeWidth(10);
        post(animateLine);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        canvas.drawCircle(getWidth()/2, getHeight() / 2,radius,paint);
    }
}
