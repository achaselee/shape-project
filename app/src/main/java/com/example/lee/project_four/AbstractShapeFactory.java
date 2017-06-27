package com.example.lee.project_four;

import android.content.Context;
import android.view.View;

/**
 * Created by Lee on 5/2/2016.
 */
public abstract class AbstractShapeFactory
{
    public static ShapeFactory getShapeFactory(int style)
    {
        return new ShapeFactory(style);
    }
}
