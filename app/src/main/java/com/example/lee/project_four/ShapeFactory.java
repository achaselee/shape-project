package com.example.lee.project_four;

import android.content.Context;

/**
 * Created by Adison on 5/3/2016.
 */
public class ShapeFactory
{
    int styleNum;

    public ShapeFactory(int style)
    {
        styleNum = style;
    }

    public Shape getShape(Context context, String shape)
    {
        if(shape == null) return null;

        if(shape.equals("circle"))
        {
            return new Circle(context, styleNum);
        }
        else if(shape.equals("rectangle"))
        {
            return new Rectangle(context, styleNum);
        }
        return null;
    }
}
