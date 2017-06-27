package com.example.lee.project_four;

import android.app.Activity;
import android.graphics.Color;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;
import java.util.Vector;

public class MainActivity extends Activity
{
    Button circle, rectangle, clear, styleB;
    RelativeLayout shapesView;
    TextView myTV;
    Shape shapeButtons;
    private Vector<Shape> storeShapes = new Vector();
    int circleShape = 0, rectShape = 0, styleCount = 0;
    Toast shapeToast;
    ShapeFactory factoryTest = new ShapeFactory(0);

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        myTV = (TextView) findViewById(R.id.myTextView);
        myTV.setGravity(Gravity.CENTER);
        shapesView = (RelativeLayout) findViewById(R.id.shapeDisplay);
        circle = (Button) findViewById(R.id.circleButton);
        rectangle = (Button) findViewById(R.id.rectButton);
        clear = (Button) findViewById(R.id.clearButton);
        styleB = (Button) findViewById(R.id.styleButton);

        circle.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {

                adjustShapeAlpha();
                shapeButtons = factoryTest.getShape(getApplicationContext(), "circle");
                storeShapes.add(shapeButtons);
                shapesView.addView(shapeButtons);
                updateShapeCount();

                if(shapeToast != null)
                    shapeToast.cancel();
                shapeToast = Toast.makeText(getApplicationContext(), "A Circle has been added!", Toast.LENGTH_SHORT);
                shapeToast.show();
                randomColors();
            }
        });

        rectangle.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                adjustShapeAlpha();
                shapeButtons = factoryTest.getShape(getApplicationContext(), "rectangle");
                storeShapes.add(shapeButtons);
                shapesView.addView(shapeButtons);
                updateShapeCount();

                if(shapeToast != null)
                    shapeToast.cancel();
                shapeToast = Toast.makeText(getApplicationContext(), "A Rectangle has been added!", Toast.LENGTH_SHORT);
                shapeToast.show();
                randomColors();
            }
        });

        styleB.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                styleCount++;
                if(styleCount > 4 || styleCount == 0)
                {
                    styleCount = 0;
                }
                factoryTest = AbstractShapeFactory.getShapeFactory(styleCount);
                updateShapeCount();

                if(shapeToast != null)
                    shapeToast.cancel();
                shapeToast = Toast.makeText(getApplicationContext(), "Style added!", Toast.LENGTH_SHORT);
                shapeToast.show();
                randomColors();
            }
        });

        clear.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                storeShapes.clear();
                shapesView.removeAllViewsInLayout();
                circleShape = 0;
                rectShape = 0;
                styleCount = 0;
                factoryTest = AbstractShapeFactory.getShapeFactory(styleCount);
                myTV.setText(String.format(" Rect: %d  Circle: %d Style: %d", rectShape, circleShape, styleCount));

                if(shapeToast != null){ shapeToast.cancel(); }
                shapeToast = Toast.makeText(getApplicationContext(),
                        "All shapes are removed!", Toast.LENGTH_SHORT);
                shapeToast.show();
                randomColors();
            }
        });
    }

    void adjustShapeAlpha()
    {
        Shape shapeInVec;
        float nuAlpha;

        for(int i = 0; i < storeShapes.size(); i++)
        {
            shapeInVec = storeShapes.get(i);
            nuAlpha = shapeInVec.getShapeAlpha();
            nuAlpha -= (0.1f);
            shapeInVec.setShapeAlpha(nuAlpha);

            if(nuAlpha <= 0.0f)
            {
                storeShapes.remove(shapeInVec);
                shapeInVec.removeShape();
            }
        }
    }

    void updateShapeCount()
    {
        for(Shape shapeCount: storeShapes)
        {
            if(shapeCount.getShapeType().equals("circle"))
            {
                circleShape++;
            }
            else if(shapeCount.getShapeType().equals("rectangle"))
            {
                rectShape++;
            }
        }
        myTV.setText(String.format(" Rect: %d  Circle: %d Style: %d", rectShape, circleShape, styleCount));
        myTV.invalidate();
        circleShape = 0;
        rectShape = 0;
    }

    void randomColors()
    {
        Random randColor = new Random();
        int toastColor = Color.argb(70, randColor.nextInt(256),
                randColor.nextInt(256), randColor.nextInt(256));
        shapeToast.getView().setBackgroundColor(toastColor);
    }
}
