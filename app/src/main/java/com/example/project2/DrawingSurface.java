package com.example.project2;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import java.util.Random;

public class DrawingSurface extends SurfaceView implements SurfaceHolder.Callback {

    public SurfaceHolder surfaceHolder = null;
    private Paint paint = null;
    private float x, y; //will hold the x and y cooridnates of the drawn object in each method


    public DrawingSurface(Context context){
        super(context);
        paint = new Paint();
        paint.setColor(Color.YELLOW);
    }

    @Override
    public void surfaceCreated(SurfaceHolder surfaceHolder) {

    }

    @Override
    public void surfaceChanged(SurfaceHolder surfaceHolder, int i, int i1, int i2) {

    }

    @Override
    public void surfaceDestroyed(SurfaceHolder surfaceHolder) {
        paint = null;
    }
    public void drawMiddle(){
        surfaceHolder = getHolder();
        //Get and lock canvas object from surfaceHolder
        Canvas canvas = surfaceHolder.lockCanvas();
        Paint surfaceBackground = new Paint();
        //Set the surfaceview background color
        surfaceBackground.setColor(Color.BLUE);
        //Draw the surfacview background color
        canvas.drawRect(0,0,this.getWidth(),this.getHeight(),surfaceBackground);

        //Draw the circle
        paint.setColor(Color.YELLOW);
        this.x = 200;
        this.y = 200;
        canvas.drawCircle(this.x, this.y,100,paint);

        //Unlock the canvas object and post the new draw.
        surfaceHolder.unlockCanvasAndPost(canvas);
    }
    public void drawYellow(){
        surfaceHolder = getHolder();
        //Get and lock canvas object from surfaceHolder
        Canvas canvas = surfaceHolder.lockCanvas();
        Paint surfaceBackground = new Paint();
        //Set the surfaceview background color
        surfaceBackground.setColor(Color.BLUE);
        //Draw the surfacview background color
        canvas.drawRect(0,0,this.getWidth(),this.getHeight(),surfaceBackground);

        //Draw the circle
        paint.setColor(Color.YELLOW);
        canvas.drawCircle(x,y,100,paint);

        //Unlock the canvas object and post the new draw.
        surfaceHolder.unlockCanvasAndPost(canvas);

    }

    public void drawRed(){
        surfaceHolder = getHolder();
        //Get and lock canvas object from surfaceHolder
        Canvas canvas = surfaceHolder.lockCanvas();
        Paint surfaceBackground = new Paint();
        //Set the surfaceview background color
        surfaceBackground.setColor(Color.BLACK);
        //Draw the surfacview background color
        canvas.drawRect(0,0,this.getWidth(),this.getHeight(),surfaceBackground);

        //Draw the circle
        paint.setColor(Color.YELLOW);
        canvas.drawCircle(x,y,100,paint);

        //Unlock the canvas object and post the new draw.
        surfaceHolder.unlockCanvasAndPost(canvas);
    }
    public void setX(float x){
        Random float_rand = new Random();
        Random int_rand = new Random();
        x = float_rand.nextFloat() + int_rand.nextInt(this.getWidth());
    }
    public void setY(float y){
        //this.y = (float) (0.01 * y * this.getWidth());
        Random float_rand = new Random();
        Random int_rand = new Random();
        y = float_rand.nextFloat() + int_rand.nextInt(this.getHeight());
    }
}

