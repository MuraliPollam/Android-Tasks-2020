package com.sidchiku9.taskone;

import androidx.appcompat.app.AppCompatActivity;

import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ViewFlipper;

import com.squareup.picasso.Picasso;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    ViewFlipper vf;
    Button next,prev;
    ImageView one,two,three,four;
    String oneU = "https://i.pinimg.com/originals/d0/63/1e/d0631e3f92c15e0d514970f3a7ab3b38.jpg",
            twoU = "https://i.pinimg.com/originals/a4/89/b8/a489b87aeed18a1dd8d742465aaf2326.jpg",
            threeU = "https://www.ecopetit.cat/wpic/mpic/45-454542_zoro-one-piece-art.jpg",
            fourU = "https://www.writeups.org/wp-content/uploads/Ichigo-Kurosaki-Bleach-Shonen-Jump-c.jpg";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        vf = findViewById(R.id.vf);
        next = findViewById(R.id.next);
        prev = findViewById(R.id.prev);

        one = findViewById(R.id.one);
        two = findViewById(R.id.two);
        three = findViewById(R.id.three);
        four = findViewById(R.id.four);

        Picasso.get().load(oneU).into(one);
        Picasso.get().load(twoU).into(two);
        Picasso.get().load(threeU).into(three);
        Picasso.get().load(fourU).into(four);

        next.setOnClickListener(this);
        prev.setOnClickListener(this);

        Animation in = AnimationUtils.loadAnimation(this, android.R.anim.slide_in_left);
        Animation out = AnimationUtils.loadAnimation(this, android.R.anim.slide_out_right);
        vf.setInAnimation(in);
        vf.setOutAnimation(out);
        vf.setFlipInterval(3000);
    }

    @Override
    public void onClick(View v){
        if(v==next){
            vf.showNext();
        }
        else if(v==prev){
            vf.showPrevious();
        }
    }
}
