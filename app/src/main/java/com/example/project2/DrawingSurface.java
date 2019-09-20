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
    private int speed = 1; // might set the speed (which would look like sharpness of the curve, higher number should be lower curve?

    //TODO: CONSIDER REFACTORING INTO A CIRCLE AND A SQUARE AND A LINE CLASS THAT EACH EXTEND SURFACEVIEW?


    public DrawingSurface(Context context){
        super(context);
        paint = new Paint();
        paint.setColor(Color.YELLOW);
        //this.setBackgroundColor(Color.LTGRAY);
        for(int i = 0; i < this.getHeight(); i=i+5){
            drawGridLine(0,i,this.getWidth(),i);
        }
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
    public void decreasePower() {this.power--;}
    public void resetPower() {this.power = 1;}
    public void increaseSlope(){this.m = (float) (this.m + 0.1);}
    public void decreaseSlope(){this.m = (float) (this.m - 0.1);}
    public void resetSlope(){this.m = 1;}
    public void setSlope(float m){this.m = m; }
    public float getSlope(){return this.m;}
    public void setY_int(float b){ this.b =b; }
    public void resetY_int(){this.b = 0; }
    public float getY_int(){return this.b; }

    public void drawGridLine(float x1, float y1, float x2, float y2){
        surfaceHolder = getHolder();
        Canvas canvas = surfaceHolder.lockCanvas();
        Paint surfaceBackground = new Paint();
        surfaceBackground.setColor(Color.LTGRAY);
        canvas.drawRect(0,0,this.getWidth(),this.getHeight(),surfaceBackground);
        paint.setColor(Color.RED);
        paint.setStrokeWidth(2);
        //canvas.drawLine(this.x,this.y,this.x+100,this.y+100,surfaceBackground);

        canvas.drawLine(x1,y1,x2,y2,paint);
        surfaceHolder.unlockCanvasAndPost(canvas);

    }
    public void drawLineOnClicks(float user_x_start, float user_y_start, float user_x_end, float user_y_end){
        surfaceHolder = getHolder();
        Canvas canvas = surfaceHolder.lockCanvas();
        Paint surfaceBackground = new Paint();
        surfaceBackground.setColor(Color.LTGRAY);
        canvas.drawRect(0,0,this.getWidth(),this.getHeight(),surfaceBackground);
        paint.setColor(Color.RED);
        paint.setStrokeWidth(10);
        //TODO: FIND A WAY TO CAPTURE THE 4 NECESSARY INPUTS ABOVE AND CALL THIS FUNCTION EFFECTIVELY IN MAIN
        canvas.drawLine(user_x_start, user_y_start, user_x_end, user_y_end, paint);



        surfaceHolder.unlockCanvasAndPost(canvas);

    }
    public void drawSimpleEquation(float user_x){
        surfaceHolder = getHolder();
        Canvas canvas = surfaceHolder.lockCanvas();
        Paint surfaceBackground = new Paint();
        surfaceBackground.setColor(Color.LTGRAY);
        canvas.drawRect(0,0,this.getWidth(),this.getHeight(),surfaceBackground);
        paint.setColor(Color.YELLOW);
        paint.setStrokeWidth(10);
        //canvas.drawLine(this.x,this.y,this.x+100,this.y+100,surfaceBackground);
        float startx = 0;
        float starty = m*startx + b;
        float endx = user_x;
        float endy = m*endx + b;
        canvas.drawLine(startx,starty, endx,endy,paint);



        surfaceHolder.unlockCanvasAndPost(canvas);

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
        float endx = startx + speed;
        float endy = (float) (Math.pow(endx,power)*m + b);
        canvas.drawLine(startx,starty, endx,endy,paint);
        float temp_endx;
        float temp_endy;

        for(int i = 0; i < user_x; i++){
            //startx = startx + 5;
            //starty = m*startx + b;
            //endx = startx + 5;
            //endy = (float) (Math.pow(endx,power)*m + b);
            temp_endx = endx + speed;
            temp_endy = (float) (Math.pow(temp_endx,power)*m + b);
            paint.setColor(Color.YELLOW);
            canvas.drawLine(endx,endy, temp_endx,temp_endy,paint);
            endx = temp_endx;
            endy = temp_endy;
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
        canvas.drawCircle(this.x,this.y,100,paint);

        //Unlock the canvas object and post the new draw.
        surfaceHolder.unlockCanvasAndPost(canvas);
    }
    public void drawBlueLine(float motion_x, float motion_y){
        float startx = 0;
        float starty = b;
        surfaceHolder = getHolder();
        //Get and lock canvas object from surfaceHolder
        Canvas canvas = surfaceHolder.lockCanvas();
        Paint surfaceBackground = new Paint();
        //Set the surfaceview background color
        surfaceBackground.setColor(Color.LTGRAY);
        //Draw the surfacview background color
        canvas.drawRect(0,0,this.getWidth(),this.getHeight(),surfaceBackground);

        //Draw the circle
        paint.setColor(Color.BLUE);
        canvas.drawLine(startx,starty,motion_x,motion_y,paint);

        //Unlock the canvas object and post the new draw.
        surfaceHolder.unlockCanvasAndPost(canvas);

    }
    public void setX(float x){
        //Random float_rand = new Random();
        //Random int_rand = new Random();
        this.x = x;
    }
    public void setY(float y){
        //this.y = (float) (0.01 * y * this.getWidth());
        //Random float_rand = new Random();
        //Random int_rand = new Random();
        this.y = y;
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

