package com.example.project2;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import java.util.Random;
import java.lang.Math;

public class DrawingSurface extends SurfaceView implements SurfaceHolder.Callback {

    public SurfaceHolder surfaceHolder = null;
    private Paint paint = null;
    private float x, y; //will hold the x and y cooridnates of the drawn object in each method
    private float m = 1;
    private float b = 0;
    private int power = 1;
    private int[][] equation = null;


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

    public void increasePower(){
        this.power++;
    }
    public void drawEquation(float user_x){
        surfaceHolder = getHolder();
        Canvas canvas = surfaceHolder.lockCanvas();
        Paint surfaceBackground = new Paint();
        surfaceBackground.setColor(Color.LTGRAY);
        canvas.drawRect(0,0,this.getWidth(),this.getHeight(),surfaceBackground);
        paint.setColor(Color.BLUE);
        paint.setStrokeWidth(10);
        //canvas.drawLine(this.x,this.y,this.x+100,this.y+100,surfaceBackground);
        float startx = 0;
        float starty = m*startx + b;
        float endx = user_x;
        float endy = (float) (Math.pow(endx,power)*m + b);
        canvas.drawLine(startx,starty, endx,endy,paint);

        for(int i = 0; i < user_x; i++){
            startx = i;
            starty = m*startx + b;
            endx = i++;
            endy = (float) (Math.pow(endx,power)*m + b);
            paint.setColor(Color.YELLOW);
            canvas.drawLine(startx,starty, endx,endy,paint);
        }


        surfaceHolder.unlockCanvasAndPost(canvas);

    }
    public void drawInverseEquation(float user_x){
        surfaceHolder = getHolder();
        Canvas canvas = surfaceHolder.lockCanvas();
        Paint surfaceBackground = new Paint();
        surfaceBackground.setColor(Color.LTGRAY);
        canvas.drawRect(0,0,this.getWidth(),this.getHeight(),surfaceBackground);
        paint.setColor(Color.BLUE);
        paint.setStrokeWidth(10);
        //canvas.drawLine(this.x,this.y,this.x+100,this.y+100,surfaceBackground);
        float startx = 0;
        float starty = this.getHeight() - b;
        float endx = user_x;
        float endy = -(m*endx + b);

        canvas.drawLine(startx,starty, endx,endy,paint);
        surfaceHolder.unlockCanvasAndPost(canvas);

    }
    public void drawMiddle(){
        surfaceHolder = getHolder();
        //Get and lock canvas object from surfaceHolder
        Canvas canvas = surfaceHolder.lockCanvas();
        Paint surfaceBackground = new Paint();
        //Set the surfaceview background color
        surfaceBackground.setColor(Color.DKGRAY);
        //Draw the surfacview background color
        canvas.drawRect(0,0,this.getWidth(),this.getHeight(),surfaceBackground);

        //Draw the circle
        paint.setColor(Color.BLUE);
        //this.x = 200;
        //this.y = 200;
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
        paint.setColor(Color.RED);
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

    public void randX(){
        //this.x = (float) (0.01 * x * this.getWidth());
        Random float_rand = new Random();
        Random int_rand = new Random();
        this.x = float_rand.nextFloat() + int_rand.nextInt(this.getWidth());
    }
    public void randY(){
        //this.y = (float) (0.01 * y * this.getHeight());
        Random float_rand = new Random();
        Random int_rand = new Random();
        this.y = float_rand.nextFloat() + int_rand.nextInt(this.getHeight());
        System.out.println(this.y);
    }
    public float makeRandX(){
        Random float_rand = new Random();
        Random int_rand = new Random();
        return float_rand.nextFloat() + int_rand.nextInt(getWidth());
    }
    public float makeRandY(){
        Random float_rand = new Random();
        Random int_rand = new Random();
        return float_rand.nextFloat() + int_rand.nextInt(getHeight());
    }

    public int getPower(){
        return this.power;
    }
}

