package com.example.lee.project_four;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Rect;

import java.util.Random;

/**
 * Created by Adison on 5/3/2016.
 */
public class Rectangle extends Shape
{
    int xLeft, yTop, xRight, yBot;
    Random randy = new Random();

    public Rectangle(Context context, int style)
    {
        super(context, style);
    }

    @Override
    String getShapeType()
    {
        return "rectangle";
    }

    public void onDraw(Canvas canvas)
    {
        xLeft = randy.nextInt(canvas.getWidth());
        yTop = randy.nextInt(canvas.getHeight());
        xRight = randy.nextInt((canvas.getWidth())/4);
        yBot = randy.nextInt((canvas.getHeight())/4);

        Rect aTestRectangle = new Rect(xLeft , yTop, xLeft + xRight, yTop + yBot);

        if(daStyle == 0)
        {
            stylePaint.setARGB(255, randy.nextInt(256), randy.nextInt(256), randy.nextInt(256));
            stylePaint.setAlpha((int) (getShapeAlpha() * 100));
            canvas.drawRect(aTestRectangle, stylePaint);
        }

        if(daStyle == 1)
        {
            setFillColor(daStyle);
            canvas.drawRect(aTestRectangle, stylePaint);
            setStrokeColor(daStyle);
            canvas.drawRect(aTestRectangle, stylePaint);
        }
        else if(daStyle == 2)
        {
            setFillColor(daStyle);
            canvas.drawRect(aTestRectangle, stylePaint);
            setStrokeColor(daStyle);
            canvas.drawRect(aTestRectangle, stylePaint);
        }
        else if(daStyle == 3)
        {
            setFillColor(daStyle);
            canvas.drawRect(aTestRectangle, stylePaint);
            setStrokeColor(daStyle);
            canvas.drawRect(aTestRectangle, stylePaint);
        }
        else if(daStyle == 4)
        {
            setFillColor(daStyle);
            canvas.drawRect(aTestRectangle, stylePaint);
            setStrokeColor(daStyle);
            canvas.drawRect(aTestRectangle, stylePaint);
        }
    }
}
