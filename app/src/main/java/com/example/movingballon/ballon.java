package com.example.movingballon;

import androidx.appcompat.app.AppCompatActivity;

import android.animation.ObjectAnimator;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
public class ballon extends AppCompatActivity {
    private TextView score;
    private ImageView ballon;
    private int clicks = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ballon);

        this.score=(TextView) findViewById(R.id.score);
        this.ballon=(ImageView) findViewById(R.id.ballon);
        ObjectAnimator animator = ObjectAnimator.ofFloat(ballon, "translationY", 0f, 500f);
        animator.setDuration(5000);
        animator.setRepeatCount(ObjectAnimator.INFINITE);
        animator.setRepeatMode(ObjectAnimator.REVERSE);
        animator.start();

        ballon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Animation animation= AnimationUtils.loadAnimation(ballon.this,R.anim.lefttoright);
                ballon.startAnimation(animation);
                clicks++;

                score.setText("Points :" + clicks);
                if (clicks>=10){
                    finish();}

            }
        });

    }
}