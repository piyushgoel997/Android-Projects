package com.example.piyush.uitest;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;

import java.util.jar.Attributes;

/**
 * Created by Piyush on 24-07-2016.
 */
public class CustomView extends View {

    Paint paint;
    int color;
    float radius;

    // Constructor to be called through java
    public CustomView(Context context) {
        super(context);
        init();
    }

    // Constructor to be called through XML
    public CustomView(Context context, AttributeSet attrs) {
        super(context, attrs);
        TypedArray ta = context.obtainStyledAttributes(attrs, R.styleable.CustomView);
        this.color = ta.getColor(R.styleable.CustomView_circleColor, Color.BLUE);
        this.radius = ta.getDimension(R.styleable.CustomView_circleRadius, 200);
        ta.recycle();
        init();
    }

    // Constructor to be called when using a custom style
    public CustomView(Context context, AttributeSet attributeSet, int defStyle) {
        super(context, attributeSet, defStyle);
        init();
    }

    // this function is used to initialize everyhting -> not compulsory but better style of coding
    private void init() {
        paint = new Paint();
        paint.setColor(Color.parseColor("#009688"));


    }

    @Override
    protected void onDraw(Canvas canvas) {
        canvas.drawCircle(getWidth() / 2, getHeight() / 2, radius, paint);
        super.onDraw(canvas);
    }

    @Override
    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
        super.onSizeChanged(w, h, oldw, oldh);
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
    }

    public void setColor(int color) {
        paint.setColor(color);
        invalidate(); // this fn basically calls onDraw() again
    }

    public void setRadius(float radius) {
        this.radius = radius;
        invalidate();
    }
}
