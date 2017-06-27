package com.example.lee.project_four;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.view.View;

import java.util.Random;

/**
 * Created by Adison on 5/3/2016.
 */
public abstract class Shape extends View
{
    private float fadeAmt;
    int daStyle;
    Paint stylePaint;

    public Shape(Context context, int style)
    {
        super(context);
        setShapeAlpha(1.0f);
        stylePaint = new Paint();
        daStyle = style;
    }

    void setFillColor(int fill)
    {
        if(fill == 1)
        {
            stylePaint.setStyle(Paint.Style.FILL);
            stylePaint.setColor(Color.BLUE);
            stylePaint.setAlpha((int) (getShapeAlpha() * 100));
        }
        else if(fill == 2)
        {
            stylePaint.setStyle(Paint.Style.FILL);
            stylePaint.setColor(Color.RED);
            stylePaint.setAlpha((int) (getShapeAlpha() * 100));
        }
        else if(fill == 3)
        {
            stylePaint.setStyle(Paint.Style.FILL);
            stylePaint.setColor(Color.BLACK);
            stylePaint.setAlpha((int) (getShapeAlpha() * 100));
        }
        else if(fill == 4)
        {
            stylePaint.setStyle(Paint.Style.FILL);
            stylePaint.setColor(Color.MAGENTA);
            stylePaint.setAlpha((int) (getShapeAlpha() * 100));
        }
    }

    void setStrokeColor(int stroke)
    {
        if(stroke == 1)
        {
            stylePaint.setStyle(Paint.Style.STROKE);
            stylePaint.setColor(Color.RED);
            stylePaint.setStrokeWidth(40.0f);
            stylePaint.setAlpha((int) (getShapeAlpha() * 100));
        }
        else if(stroke == 2)
        {
            stylePaint.setStyle(Paint.Style.STROKE);
            stylePaint.setColor(Color.GREEN);
            stylePaint.setStrokeWidth(40.0f);
            stylePaint.setAlpha((int) (getShapeAlpha() * 100));
        }
        else if(stroke == 3)
        {
            stylePaint.setStyle(Paint.Style.STROKE);
            stylePaint.setColor(Color.YELLOW);
            stylePaint.setStrokeWidth(40.0f);
            stylePaint.setAlpha((int) (getShapeAlpha() * 100));
        }
        else if(stroke == 4)
        {
            stylePaint.setStyle(Paint.Style.STROKE);
            stylePaint.setColor(Color.GRAY);
            stylePaint.setStrokeWidth(40.0f);
            stylePaint.setAlpha((int) (getShapeAlpha() * 100));
        }
    }

    void setShapeAlpha(float alpha)
    {
        fadeAmt = alpha;
    }

    float getShapeAlpha()
    {
        return fadeAmt;
    }

    void removeShape()
    {
        setVisibility(View.GONE);
    }

    abstract String getShapeType();

    public abstract void onDraw(Canvas canvas);
}