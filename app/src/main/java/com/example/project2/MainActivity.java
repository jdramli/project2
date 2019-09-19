package com.example.project2;

import android.graphics.Color;
import android.graphics.Paint;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.SurfaceView;
import android.view.View;
import android.widget.Button;
import android.widget.SeekBar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import java.util.Random;

public class MainActivity extends AppCompatActivity implements View.OnTouchListener {
    DrawingSurface testsurface = null;
    ConstraintLayout c_layout = null;
    private SeekBar seekBar = null;
    Button increase = null;
    Button rand = null;
    Button decrease = null;
    Button power = null;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        setTitle("Line Seeker");

        //sets buttons and layout handle
        increase = findViewById((R.id.increase));
        rand = findViewById((R.id.rand));
        decrease = findViewById((R.id.decrease));
        power = findViewById((R.id.power));
        c_layout = (ConstraintLayout)findViewById(R.id.constraintLayout);
        testsurface = new DrawingSurface((getApplicationContext()));
        c_layout.addView(testsurface);
        c_layout.setBackgroundColor(Color.GRAY);
        //testsurface.setBackgroundColor(Color.WHITE);
        //testsurface.getHolder().setFixedSize(900,900);
        testsurface.setOnTouchListener(this);
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
                testsurface.drawEquation(position);
                //rand.setText("Equation from 0 to " + progress + " has been written");
                //testsurface.drawInverseEquation(position);

            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {
                //rand.setText("You started tracking on the seekbar!");
                //testsurface.randX();
                //testsurface.randY();
                //testsurface.drawMiddle();


            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

                //rand.setText("SeekBar Tracking Stopped now!");

            }
        });

        increase.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
               // increase.setText("Click to increase power by 1, current power is: "+testsurface.getPower());
               // decrease.setText("Click to decrease power by 1, current power is: "+testsurface.getPower());
                testsurface.increaseSlope();
                power.setText("Slope = "+testsurface.getSlope());
                //testsurface.drawMiddle();
                //testsurface.drawBall();

            }
        });
        rand.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                Random temp_rand = new Random();
                testsurface.setSlope(temp_rand.nextInt(10) + temp_rand.nextFloat());
                testsurface.drawEquation(testsurface.makeRandX());
                //rand.setText("Equation 0 to random_number_x has been drawn! (Click again to redraw)");
            }

        });
        decrease.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
              //  decrease.setText("Click to decrease power by 1, current power is: "+testsurface.getPower());
              //  increase.setText("Click to increase power by 1, current power is: "+testsurface.getPower());
                testsurface.decreaseSlope();
                power.setText("Slope = "+testsurface.getSlope());
                //testsurface.drawMiddle();
                //testsurface.drawBall();

            }
        });

    }


    @Override
    public boolean onTouch(View view, MotionEvent motionEvent) {

        // If user touch the custom SurfaceView object.
        if(view instanceof SurfaceView) {
            view.invalidate();

            float x = motionEvent.getX();

            float y = motionEvent.getY();


            testsurface.setX(x);
            testsurface.setY(y);
            //testsurface.drawRed();
            testsurface.drawYellow();




            // Tell android os the onTouch event has been processed.
            return true;
        }else
        {
            // Tell android os the onTouch event has not been processed.
            return false;
        }
    }

}
