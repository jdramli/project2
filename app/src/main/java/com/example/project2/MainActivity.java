package com.example.project2;

import android.graphics.Color;
import android.graphics.Paint;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.SurfaceHolder;
import android.view.View;
import android.widget.Button;
import android.widget.SeekBar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

public class MainActivity extends AppCompatActivity implements View.OnTouchListener {
    DrawingSurface testsurface = null;
    ConstraintLayout c_layout = null;
    private SeekBar seekBar = null;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        setTitle("Just a Drawer");

        //sets buttons and layout handle
        final Button upbutton = findViewById((R.id.upbutton));
        final Button downbutton = findViewById((R.id.downbutton));
        c_layout = (ConstraintLayout)findViewById(R.id.constraintLayout);
        testsurface = new DrawingSurface((getApplicationContext()));
        c_layout.addView(testsurface);
        c_layout.setBackgroundColor(Color.GRAY);
        testsurface.setBackgroundColor(Color.WHITE);
        testsurface.getHolder().setFixedSize(900,900);
        //testsurface.setOnTouchListener(this);

        // testsurface.drawSomething();
        seekBar = (SeekBar)findViewById(R.id.seekBar);
        seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            //parameters progress and fromUser seem to be predefined based on the seekBar widget and android OS input/output interface
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                testsurface.setX(progress);
                testsurface.setY(progress);
                testsurface.drawRed();
                //customGraph.drawGreen();
                //customGraph.drawYellow();
                //downbutton.setText("Position on Seekbar has changed!");

            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {
                downbutton.setText("You started tracking on the seekbar!");


            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
                testsurface.randX();
                testsurface.randY();
                testsurface.drawMiddle();
                downbutton.setText("SeekBar Tracking Stopped now!");

            }
        });

        upbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                upbutton.setText("button clicked successfully!");
                //draw an object
                Paint paint = new Paint();
                paint.setColor(Color.RED);
                //testsurface.setPaint(paint);
                // testsurface.drawSomething();
                testsurface.drawMiddle();
                //testsurface.drawBall();

            }
        });

    }

    @Override
    public boolean onTouch(View view, MotionEvent motionEvent) {

        if(view.performClick()){
            testsurface.drawMiddle();
            return true;
        }

        else{
            return false;
        }

    }
}
