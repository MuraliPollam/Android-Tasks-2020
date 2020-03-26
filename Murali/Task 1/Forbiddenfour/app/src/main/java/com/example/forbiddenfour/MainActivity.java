package com.example.forbiddenfour;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;


import com.bumptech.glide.Glide;

public class MainActivity extends AppCompatActivity {

    int i=0;
    String[] urls={
            "https://i.pinimg.com/originals/d0/63/1e/d0631e3f92c15e0d514970f3a7ab3b38.jpg",
            "https://i.pinimg.com/originals/a4/89/b8/a489b87aeed18a1dd8d742465aaf2326.jpg",
            "https://www.ecopetit.cat/wpic/mpic/45-454542_zoro-one-piece-art.jpg",
            "https://www.writeups.org/wp-content/uploads/Ichigo-Kurosaki-Bleach-Shonen-Jump-c.jpg"};
    private ImageView pic;
    private Button next;
    private Button previous;
    private Animation anim1,anim2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        pic = findViewById(R.id.pic);
        next = findViewById(R.id.next);
        previous = findViewById(R.id.previous);
        anim1 = AnimationUtils.loadAnimation(this,R.anim.fade_in);
        anim2 = AnimationUtils.loadAnimation(this, R.anim.fade_out);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(i==3){
                    i=-1;
                }
                i++;
                nextpic1();
            }
        });
        previous.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(i==0){
                    i=4;
                }
                i--;
                prevpic1();
            }
        });
    }
    private void nextpic1() {
        Glide.with(this).load(urls[i]).into(pic);
        pic.startAnimation(anim1);
    }
    private void prevpic1(){
        Glide.with(this).load(urls[i]).into(pic);
        pic.startAnimation(anim2);
    }

}
