package com.swaqny.differantimages;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

public class Main2Activity extends AppCompatActivity {
    ImageView imageView2 ;
    TextView X  ,flawer , Y;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        imageView2 =(ImageView)findViewById(R.id.imageView2);
        X=(TextView)findViewById(R.id.X);
        flawer =(TextView)findViewById(R.id.flawer);
        Y =(TextView)findViewById(R.id.y);
        imageView2.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {
                double x = motionEvent.getX();
                double y = motionEvent.getY();
                 X.setText(x+"");
                Y.setText(y+"");

//      Toast.makeText(getApplicationContext(),x+"      " +"touched"+"     "+y,Toast.LENGTH_SHORT).show();

                return false;
            }
        });

        imageView2.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                int[] values = new int[2];
                view.getLocationOnScreen(values);
//                Toast.makeText(getApplicationContext(),"X & Y"+values[0]+" "+values[1],Toast.LENGTH_SHORT).show();
                Log.d("X & Y",values[0]+" "+values[1]);
            }
        });

    }


}
