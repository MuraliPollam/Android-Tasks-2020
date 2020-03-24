package com.example.task1;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;

import com.bumptech.glide.GenericTransitionOptions;
import com.bumptech.glide.Glide;



public class MainActivity extends AppCompatActivity {
    Button prev,next;
    ImageView image;
    int state=0;
    String[] urls= new String[]{"https://i.pinimg.com/originals/d0/63/1e/d0631e3f92c15e0d514970f3a7ab3b38.jpg",
    "https://i.pinimg.com/originals/a4/89/b8/a489b87aeed18a1dd8d742465aaf2326.jpg",
    "https://www.ecopetit.cat/wpic/mpic/45-454542_zoro-one-piece-art.jpg",
    "https://www.writeups.org/wp-content/uploads/Ichigo-Kurosaki-Bleach-Shonen-Jump-c.jpg"};
    Animation in,out;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        getSupportActionBar().setTitle("Task1 : ImageViewer App");

        prev=findViewById(R.id.prev);
        next=findViewById(R.id.next);
        image=findViewById(R.id.image);
        in= AnimationUtils.loadAnimation(this,R.anim.out);
        out=AnimationUtils.loadAnimation(this,R.anim.in);
        imageviewi();


        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                state++;
                if(state==4){
                    state=0;
                }
                imageviewi();
            }
        });
        prev.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                state--;
                if(state==-1)
                {
                    state=3;
                }

                imageviewo();
            }
        });



    }

    private void imageviewi() {
      // Glide.with(this).load(urls[state]).transition(GenericTransitionOptions.<Drawable>with(R.anim.in)).into(image);
        //Glide.with(this).load(urls[state]).transition(DrawableTransitionOptions.withCrossFade()).into(image);
     Glide.with(this).load(urls[state]).into(image);
     image.startAnimation(in);

    }
    private void imageviewo(){
        //Glide.with(this).load(urls[state]).transition(GenericTransitionOptions.<Drawable>with(R.anim.out)).into(image);//This can be used to giv loading anim
      // Glide.with(this).load(urls[state]).transition(DrawableTransitionOptions.withCrossFade()).into(image);
       Glide.with(this).load(urls[state]).into(image);
       image.startAnimation(out);
    }
}
