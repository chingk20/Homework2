/*
*   @author:Keisha Ching
*   Class: CS 301
*   Homework 2
*   Date: 10/01/2019
*
 */
package com.example.homework2;

import android.graphics.Canvas;
import java.util.Random;
import android.content.Context;
import android.graphics.Path;
import android.graphics.RectF;
import android.view.SurfaceView;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;

public class Face extends SurfaceView{

    //used to change color of face and hairstyle
    protected int skinColor;
    protected int eyeColor;
    protected int hairColor;
    protected int hairStyle;

    //used to create custom color
    public int redColor;
    public int blueColor;
    public int greenColor;

    //used to check which radio button is clicked
    public boolean hairChecked = false;
    public boolean eyesChecked = false;
    public boolean skinChecked = false;

    //used to create different colors for face
    protected Paint paint = new Paint();
    protected Paint eyeOutline = new Paint();
    protected Paint noseColor = new Paint();
    protected Paint mouthColor = new Paint();
    protected Paint eyeWhite = new Paint();
    protected Paint finalSkinColor = new Paint();
    protected Paint finalEyeColor = new Paint();
    protected Paint finalHairColor = new Paint();
    protected Random random = new Random();

    //used for creating face graphics
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
        this.randomize();   //starts face at random
        this.eyeOutline.setColor(Color.BLACK);
        this.noseColor.setColor(0XFF543A0B);
        this.mouthColor.setColor(0XFF543A0B);
        this.eyeWhite.setColor(Color.WHITE);
    }

    //sets random color to skin, eyes, and hair, with random hair style
    public void randomize()
    {
        /*
        External Citation
        Date: 25 September 2019
        Problem: Did not know how to generate random color

        Resource:
        https://stackoverflow.com/questions/5280367/
        android-generate-random-color-on-click
        Solution: I used the example code from this post.
        */

        skinColor = Color.argb(255, random.nextInt(256),
                random.nextInt(256), random.nextInt(256));
        eyeColor = Color.argb(255, random.nextInt(256),
                random.nextInt(256), random.nextInt(256));
        hairColor = Color.argb(255, random.nextInt(256),
                random.nextInt(256), random.nextInt(256));
        hairStyle = random.nextInt(3);
        hairChecked = false;
        eyesChecked = false;
        skinChecked = false;
    }

    public void onDraw(Canvas canvas)
    {
        drawBasicFace(canvas);
        drawEyes(canvas);
        drawHair(canvas);
    }

    //draws the basic shape of the face with nose and mouth
    public void drawBasicFace(Canvas canvas)
    {
        float width = (float) getWidth();
        float height = (float) getHeight();

        if (width > height) {
            radius = height / 4;
        } else {
            radius = width / 4;
        }

        //checks if skin button is clicked
        if(skinChecked == true) {
            if(redColor != 0 || greenColor != 0 || blueColor != 0) {
                skinColor = (Color.rgb(redColor, greenColor, blueColor));
            }
        }
        this.finalSkinColor.setColor(skinColor);

        //draw face shape
        RectF oval1 = new RectF(width/8, height/8,
                width - width/8, height - height/8);
        canvas.drawOval(oval1, finalSkinColor);

        //draw mouth

        /*
        External Citation
        Date: 25 September 2019
        Problem: Did not know how to create a half circle

        Resource:
        https://stackoverflow.com/questions/31705870/how-to-draw-a-half-circle-in-android
        Solution: I used the example code from this post.
        */

        Path path = new Path();
        path.addCircle(width / 3, height / 3, radius, Path.Direction.CW);

        float center_x, center_y;
        final RectF oval = new RectF();

        center_x = width / 2;
        center_y = height / 2 + height / 13;

        oval.set(center_x - radius, center_y - radius,
                center_x + radius, center_y + radius);
        canvas.drawArc(oval, 30, 120, false, mouthColor);

        //draw nose
        canvas.drawCircle(width/2-30,height/2+100,noseRadius,noseColor);
        canvas.drawCircle(width/2+30,height/2+100,noseRadius,noseColor);

    }

    //draws hair with three different options depending on which options is picked from spinner
    public void drawHair(Canvas canvas)
    {
        if(hairChecked == true) {
            if(redColor != 0 || greenColor != 0 || blueColor != 0) {
                hairColor = (Color.rgb(redColor, greenColor, blueColor));
            }
        }
        this.finalHairColor.setColor(hairColor);

        float width = (float) getWidth();
        float height = (float) getHeight();

        switch(hairStyle){
            case 0:
                canvas.drawCircle(2*(width/8)-50,height/4,hairRadius,finalHairColor);
                canvas.drawCircle(3*(width/8)-50,height/5-50,hairRadius,finalHairColor);
                canvas.drawCircle(4*(width/8),height/6-50,hairRadius,finalHairColor);
                canvas.drawCircle(5*(width/8)+50,height/5-50,hairRadius,finalHairColor);
                canvas.drawCircle(6*(width/8)+50,height/4,hairRadius,finalHairColor);
                break;

            case 1:
                RectF oval2 = new RectF(width/20, height/8, 5*(width/20), 5*(height/8));
                canvas.drawOval(oval2, finalHairColor);
                RectF oval3 = new RectF(width-5*(width/20), height/8, width-(width/20), 5*(height/8));
                canvas.drawOval(oval3,finalHairColor);
                RectF oval4 = new RectF(width/10, height/15, width-(width/10), 4*(height/15));
                canvas.drawOval(oval4,finalHairColor);
                break;

            case 2:
                Path path = new Path();
                path.addCircle(width / 3, height / 3, radius, Path.Direction.CW);
                paint.setStrokeWidth(20);
                float center_x, center_y;
                final RectF oval = new RectF();

                center_x = width / 2;
                center_y = height / 5 + 50;

                oval.set(center_x - radius-100, center_y - radius, center_x + radius+100,
                        center_y + radius);
                canvas.drawArc(oval, 185, 170, false, finalHairColor);
                break;
        }
    }

    //draws eyes with different color depending on slider bar
    public void drawEyes(Canvas canvas)
    {
        if(eyesChecked == true) {
            if(redColor != 0 || greenColor != 0 || blueColor != 0)
            {
                eyeColor = (Color.rgb(redColor, greenColor, blueColor));
            }
        }
        this.finalEyeColor.setColor(eyeColor);

        float width = (float) getWidth();
        float height = (float) getHeight();
        eyeOutline.setStrokeWidth(10);
        eyeOutline.setStyle(Paint.Style.STROKE);
        canvas.drawCircle(width/2-150, height/4+200,eyeRadius,eyeOutline);
        canvas.drawCircle(width/2+150,height/4+200,eyeRadius,eyeOutline);
        canvas.drawCircle(width/2-150,height/4+200,eyeRadius,eyeWhite);
        canvas.drawCircle(width/2+150,height/4+200,eyeRadius,eyeWhite);
        canvas.drawCircle(width/2-150,height/4+200,innerEyeRadius, finalEyeColor);
        canvas.drawCircle(width/2+150,height/4+200,innerEyeRadius, finalEyeColor);
        eyeOutline.setStyle(Paint.Style.FILL);
        canvas.drawCircle(width/2-150,height/4+200,pupilRadius,eyeOutline);
        canvas.drawCircle(width/2+150,height/4+200,pupilRadius,eyeOutline);
    }
}
