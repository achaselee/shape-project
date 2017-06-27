package com.example.lee.project_four;

import android.content.Context;
import android.graphics.Canvas;


import java.util.Random;

/**
 * Created by Adison on 5/3/2016.
 */
public class Circle extends Shape
{
    int x, y, r;
    Random randy = new Random();

    public Circle(Context context, int style)
    {
        super(context, style);
    }

    @Override
    String getShapeType()
    {
        return "circle";
    }

    @Override
    public void onDraw(Canvas canvas)
    {
        x = randy.nextInt(canvas.getWidth());
        y = randy.nextInt(canvas.getHeight());
        r = randy.nextInt((canvas.getWidth())/4);

        if(daStyle == 0)
        {
            stylePaint.setARGB(255, randy.nextInt(256), randy.nextInt(256), randy.nextInt(256));
            stylePaint.setAlpha((int) (getShapeAlpha() * 100));
            canvas.drawCircle(x, y, r, stylePaint);
        }

        if(daStyle == 1)
        {
            setFillColor(daStyle);
            canvas.drawCircle(x, y, r, stylePaint);
            setStrokeColor(daStyle);
            canvas.drawCircle(x, y, r, stylePaint);
        }
        else if(daStyle == 2)
        {
            setFillColor(daStyle);
            canvas.drawCircle(x, y, r, stylePaint);
            setStrokeColor(daStyle);
            canvas.drawCircle(x, y, r, stylePaint);
        }
        else if(daStyle == 3)
        {
            setFillColor(daStyle);
            canvas.drawCircle(x, y, r, stylePaint);
            setStrokeColor(daStyle);
            canvas.drawCircle(x, y, r, stylePaint);
        }
        else if(daStyle == 4)
        {
            setFillColor(daStyle);
            canvas.drawCircle(x, y, r, stylePaint);
            setStrokeColor(daStyle);
            canvas.drawCircle(x, y, r, stylePaint);
        }
    }
}
