package com.example.project2;

import android.graphics.Color;
import android.graphics.Paint;
import android.os.Bundle;
import android.util.Pair;
import android.view.DragEvent;
import android.view.MotionEvent;
import android.view.SurfaceView;
import android.view.View;
import android.widget.Button;
import android.widget.SeekBar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import java.util.Random;

import static java.lang.Float.NaN;

public class MainActivity extends AppCompatActivity implements View.OnTouchListener, View.OnDragListener {
    DrawingSurface testsurface = null;
    ConstraintLayout c_layout = null;
    private SeekBar seekBar = null;
    Button increase = null;
    Button rand = null;
    Button decrease = null;
    Button slope = null;
    Button yint = null;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        setTitle("Random Draws");

        //sets buttons and layout handle
        increase = findViewById((R.id.increase));
        rand = findViewById((R.id.rand));
        decrease = findViewById((R.id.decrease));
        slope = findViewById((R.id.slope));
        yint = findViewById(R.id.yint);
        c_layout = (ConstraintLayout)findViewById(R.id.constraintLayout);
        testsurface = new DrawingSurface((getApplicationContext()));

        c_layout.addView(testsurface);
        c_layout.setBackgroundColor(Color.GRAY);
        testsurface.setWillNotDraw(false); // This and overriding the onDraw method in the class allows whatever is in onDraw to start instead
                                            //of just a black screen.
        //testsurface.setBackgroundColor(Color.WHITE);
        //testsurface.getHolder().setFixedSize(900,900);
        testsurface.setOnTouchListener(this);
        testsurface.setOnDragListener(this);


        //setContentView(testsurface);

        // testsurface.drawSomething();
        seekBar = (SeekBar)findViewById(R.id.seekBar);
        seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            //parameters progress and fromUser seem to be predefined based on the seekBar widget and android OS input/output interface
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                //testsurface.setX(progress);
                //testsurface.setY(progress);
                //testsurface.drawRed();
                //rand.setText("Position on Seekbar has changed!");
                float position = progress*10;
                testsurface.redrawSimpleEquation(position );
                //rand.setText("Equation from 0 to " + progress + " has been written");
                //testsurface.drawInverseEquation(position);


            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {
                //rand.setText("You started tracking on the seekbar!");
                //testsurface.randX();
                //testsurface.randY();
                //testsurface.drawMiddle();
                testsurface.setX(testsurface.makeRandX());
                testsurface.setY(testsurface.makeRandY());

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
                //testsurface.initShapeVertices();
                /*
                //This block of code can be used to make a disappearing quickly animated shape with random vertices
                float tempx1 = testsurface.makeRandX();
                float tempy1 = testsurface.makeRandY();
                float tempx2 = testsurface.makeRandX();
                float tempy2 = testsurface.makeRandY();
                for(int i = 0; i < 10; i++){
                    //testsurface.drawBlueLine((float)testsurface.shape_vertices[i].first,(float)testsurface.shape_vertices[i].second);

                    if(i % 2 == 0){
                        testsurface.drawLineTwoPoints(tempx1,tempy1,tempx2,tempy2);
                        tempx1 = testsurface.makeRandX();
                        tempy1 = testsurface.makeRandY();
                    }
                    else{
                        testsurface.drawLineTwoPoints(tempx2,tempy2,tempx1,tempy1);
                        tempx2 = testsurface.makeRandX();
                        tempy2 = testsurface.makeRandY();
                    }

                }
                */
            }

        });

        increase.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
               // increase.setText("Click to increase power by 1, current power is: "+testsurface.getPower());
               // decrease.setText("Click to decrease power by 1, current power is: "+testsurface.getPower());
                testsurface.increaseSlope();
                slope.setText("Click to reset: Slope = "+testsurface.getSlope());
                //testsurface.drawMiddle();
                //testsurface.drawBall();

            }
        });
        rand.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                Random temp_rand = new Random();
                testsurface.setSlope(temp_rand.nextInt(10) + temp_rand.nextFloat());
                testsurface.setY_int(temp_rand.nextInt(testsurface.getWidth()));
                slope.setText("Click to reset: Slope = " +testsurface.getSlope());
                yint.setText("Click to reset: Y_Int = "+testsurface.getY_int());

                //testsurface.drawInverseSimpleEquation(testsurface.makeRandX());
                Random flip = new Random();
                if(flip.nextInt()%2 == 0){
                    testsurface.drawSimpleEquation(testsurface.makeRandX());

                }
                else{
                    testsurface.drawInverseSimpleEquation(testsurface.makeRandX());
                }

                //rand.setText("Equation 0 to random_number_x has been drawn! (Click again to redraw)");
            }

        });
        decrease.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
              //  decrease.setText("Click to decrease power by 1, current power is: "+testsurface.getPower());
              //  increase.setText("Click to increase power by 1, current power is: "+testsurface.getPower());
                testsurface.decreaseSlope();
                slope.setText("Click to reset: Slope = "+testsurface.getSlope());
                //testsurface.drawMiddle();
                //testsurface.drawBall();

            }
        });

        slope.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                testsurface.resetSlope();
                slope.setText("Click to reset: Slope = "+testsurface.getSlope());
            }
        });

        yint.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                testsurface.resetY_int();
                yint.setText("Click to reset: Y_Int = "+testsurface.getY_int());
                //testsurface.redrawSimpleEquation();
            }
        });

    }


    @Override
    public boolean onTouch(View view, MotionEvent motionEvent) {

        // If user touch the custom SurfaceView object.
        //if(view instanceof SurfaceView && motionEvent.getAction() == MotionEvent.ACTION_DOWN) {
        if(view instanceof SurfaceView) {

            view.invalidate();
            if(view instanceof SurfaceView && motionEvent.getAction() == MotionEvent.ACTION_DOWN){

            }
            testsurface.drawBlueLine(motionEvent.getX(),motionEvent.getY());
            float x = motionEvent.getX();

            float y = motionEvent.getY();

            testsurface.setX(x);
            testsurface.setY(y);
            //testsurface.drawRed();
            //testsurface.drawYellow();
            testsurface.drawBlueLine(x,y);
            float temp_m = (y-testsurface.getY())/(x-testsurface.getX());
            testsurface.setSlope(temp_m);
            slope.setText("Click to reset: Slope = "+temp_m);


            if(view instanceof SurfaceView && motionEvent.getAction() == MotionEvent.ACTION_UP){
                //testsurface.drawBlueLine(motionEvent.getX(),motionEvent.getY());
                testsurface.drawBlueLine(x,y);
                //testsurface.drawYellowLine(x,y); //draws a Yellow line opposite the blue line
            }



            // Tell android os the onTouch event has been processed.
            return true;
        }

        else
        {
            // Tell android os the onTouch event has not been processed.
            return false;
        }
    }

    @Override
    public boolean onDrag(View view, DragEvent dragEvent) {
        //TODO: SEE IF YOU CAN MAKE THIS ONDRAG LISTENER DO ANYTHING AT ALL
        if(view instanceof SurfaceView){
            view.invalidate();
            if(dragEvent.getAction() == DragEvent.ACTION_DRAG_ENTERED){
                slope.setText("NOW THAT WAS A CLICK AND DRAG!");
                return true;
            }

        }

        return false;
    }
}
