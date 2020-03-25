package com.sudarshan.imageviewer;

import androidx.appcompat.app.AppCompatActivity;

import android.animation.ObjectAnimator;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {


    int imageIndex = 0;
    private static final int MAX_IMAGE_COUNT = 4;
    private int[] mImageIds = {
            R.drawable.first,
            R.drawable.second,
            R.drawable.third,
            R.drawable.fourth
    };





    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button buttonNext = findViewById(R.id.next);
        buttonNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                imageIndex++;
                if(imageIndex== MAX_IMAGE_COUNT)
                {
                    imageIndex = 0;
                }
                showImage(v);
            }
        });
        

        Button buttonPrevious = findViewById(R.id.prev);
        buttonPrevious.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                imageIndex --;
                if (imageIndex == -1)
                {
                    imageIndex = MAX_IMAGE_COUNT-1;
                }
                showImage(v);
            }
        });
    }

    public void showImage(View view)
    {
        ImageView imageView = findViewById(R.id.imageView);
        imageView.setImageResource(mImageIds[imageIndex]);
        ObjectAnimator.ofFloat(imageView, View.ALPHA, 0.2f, 1.0f).setDuration(2000).start();
    }



}
