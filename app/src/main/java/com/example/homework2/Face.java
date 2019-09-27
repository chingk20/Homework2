package com.example.homework2;

import android.graphics.Canvas;
import java.util.Random;
import android.content.Context;
import android.graphics.Path;
import android.graphics.Point;
import android.graphics.RectF;
import android.view.SurfaceView;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;

public class Face extends SurfaceView{

    int skinColor;
    int eyeColor;
    int hairColor;
    int hairStyle=0;
    int redColor=150;
    int blueColor=150;
    int greenColor=150;
    int userColor;
    public boolean hairChecked = false;
    public boolean eyesChecked = false;
    public boolean skinChecked = false;

    Paint paint = new Paint();
    Random random = new Random();

    public float radius=100;
    public float eyeRadius = 100;
    public float innerEyeRadius = 75;
    public float pupilRadius = 50;
    public float noseRadius = 25;
    public float hairRadius = 125;

    public Face (Context context, AttributeSet attrs)
    {
        super(context, attrs);
        setWillNotDraw(false);
        userColor = Color.rgb(redColor, greenColor, blueColor);
    }

    public void randomize()
    {
        skinColor = random.nextInt(256);
        eyeColor = random.nextInt(256);
        hairColor = random.nextInt(256);
        hairStyle = random.nextInt(3);
    }

    public void onDraw(Canvas canvas)
    {
        drawBasicFace(canvas);
        drawEyes(canvas);
        drawHair(canvas);
    }

    public void drawBasicFace(Canvas canvas)
    {
        float width = (float) getWidth();
        float height = (float) getHeight();


        if (width > height) {
            radius = height / 4;
        } else {
            radius = width / 4;
        }

        //draw face shape
        paint.setStyle(Paint.Style.FILL);
        paint.setColor(0xFFDEC48B);
        RectF oval1 = new RectF(width/8, height/8, width - width/8, height - height/8);
        canvas.drawOval(oval1, paint);


        //draw mouth
        Path path = new Path();
        path.addCircle(width / 3,
                height / 3, radius,
                Path.Direction.CW);

        paint.setColor(0XFF543A0B);
        paint.setStrokeWidth(20);
        paint.setStyle(Paint.Style.FILL);

        float center_x, center_y;
        final RectF oval = new RectF();
        paint.setStyle(Paint.Style.FILL);

        center_x = width / 2;
        center_y = height / 2 + height / 13;

        oval.set(center_x - radius,
                center_y - radius,
                center_x + radius,
                center_y + radius);
        canvas.drawArc(oval, 30, 120, false, paint);

        paint.setColor(Color.WHITE);
        paint.setStyle(Paint.Style.FILL);
        //canvas.drawArc(oval, 20, 140, false, paint);

        //draw nose
        //paint.setStrokeWidth(10);
        paint.setStyle(Paint.Style.FILL);
        paint.setColor(0XFF543A0B);
        canvas.drawCircle(width/2-30,height/2+100,noseRadius,paint);
        canvas.drawCircle(width/2+30,height/2+100,noseRadius,paint);

    }

    public void drawHair(Canvas canvas)
    {


        float width = (float) getWidth();
        float height = (float) getHeight();
        paint.setStyle(Paint.Style.FILL);
        paint.setColor(userColor); //NEED TO CHANGE

        switch(hairStyle){
            case 0:
                Path path = new Path();
                path.addCircle(width / 3, height / 3, radius, Path.Direction.CW);
                paint.setStrokeWidth(20);
                float center_x, center_y;
                final RectF oval = new RectF();

                center_x = width / 2;
                center_y = height / 5 + 50;

                oval.set(center_x - radius-100, center_y - radius, center_x + radius+100,
                        center_y + radius);
                canvas.drawArc(oval, 185, 170, false, paint);
                break;

            case 1:
                canvas.drawCircle(2*(width/8)-50,height/4,hairRadius,paint);
                canvas.drawCircle(3*(width/8)-50,height/5-50,hairRadius,paint);
                canvas.drawCircle(4*(width/8),height/6-50,hairRadius,paint);
                canvas.drawCircle(5*(width/8)+50,height/5-50,hairRadius,paint);
                canvas.drawCircle(6*(width/8)+50,height/4,hairRadius,paint);
                break;

            case 2:
                RectF oval2 = new RectF(width/20, height/8, 5*(width/20), 5*(height/8));
                canvas.drawOval(oval2, paint);
                RectF oval3 = new RectF(width-5*(width/20), height/8, width-(width/20), 5*(height/8));
                canvas.drawOval(oval3,paint);
                RectF oval4 = new RectF(width/10, height/15, width-(width/10), 4*(height/15));
                canvas.drawOval(oval4,paint);
                break;
        }
    }

    public void drawEyes(Canvas canvas)
    {
        float width = (float) getWidth();
        float height = (float) getHeight();
        paint.setStrokeWidth(10);
        paint.setStyle(Paint.Style.STROKE);
        paint.setColor(Color.BLACK);
        canvas.drawCircle(width/2-150, height/4+200,eyeRadius,paint);
        canvas.drawCircle(width/2+150,height/4+200,eyeRadius,paint);
        paint.setStyle(Paint.Style.FILL);
        paint.setColor(Color.WHITE);
        canvas.drawCircle(width/2-150,height/4+200,eyeRadius,paint);
        canvas.drawCircle(width/2+150,height/4+200,eyeRadius,paint);
        paint.setColor(userColor); //color of the eye NEED TO CHANGE
        canvas.drawCircle(width/2-150,height/4+200,innerEyeRadius,paint);
        canvas.drawCircle(width/2+150,height/4+200,innerEyeRadius,paint);
        paint.setColor(Color.BLACK);
        canvas.drawCircle(width/2-150,height/4+200,pupilRadius,paint);
        canvas.drawCircle(width/2+150,height/4+200,pupilRadius,paint);
    }
}
