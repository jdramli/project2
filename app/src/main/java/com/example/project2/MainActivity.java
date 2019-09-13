package com.example.project2;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.PixelFormat;
import android.os.Bundle;
import android.text.Layout;
import android.view.MotionEvent;
import android.view.SurfaceView;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.LinearLayout;

public class MainActivity extends AppCompatActivity implements View.OnTouchListener {
    MySurface testsurface;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        setTitle("Just a Drawer");

        //sets buttons and layout handle
        final Button upbutton = findViewById((R.id.upbutton));
        Button downbutton = findViewById((R.id.downbutton));
        ConstraintLayout c_layout = (ConstraintLayout)findViewById(R.id.constraintLayout);
        c_layout.setBackgroundColor(Color.GRAY);

        testsurface = new MySurface((getApplicationContext()));

        testsurface.setBackgroundColor(Color.BLUE);
        testsurface.getHolder().setFixedSize(500,500);
        testsurface.setOnTouchListener(this);
        c_layout.addView(testsurface);
        // testsurface.drawSomething();

        upbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                upbutton.setText("button clicked successfully!");
                //draw an object
                Paint paint = new Paint();
                paint.setColor(Color.RED);
                //testsurface.setPaint(paint);
                // testsurface.drawSomething();
                testsurface.drawBall();

            }
        });

    }

    @Override
    public boolean onTouch(View view, MotionEvent motionEvent) {
        return false;
    }
}
