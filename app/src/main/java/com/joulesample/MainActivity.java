package com.joulesample;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;

import com.skyfishjy.library.RippleBackground;
/*
After Splash First Activity
 */

public class MainActivity extends AppCompatActivity {
    RippleBackground rippleBackground;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button button = (Button) findViewById(R.id.getStarted);

        rippleBackground = (RippleBackground) findViewById(R.id.content);
        rippleBackground.startRippleAnimation();


        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Animation bottomUp = AnimationUtils.loadAnimation(MainActivity.this, R.anim.left_right);
                bottomUp.setAnimationListener(new Animation.AnimationListener() {
                    @Override
                    public void onAnimationStart(Animation animation) {
                    }

                    @Override
                    public void onAnimationEnd(Animation animation) {
                        rippleBackground.stopRippleAnimation();
                        rippleBackground.setVisibility(View.INVISIBLE);

                        Intent intent = new Intent(MainActivity.this, IntroductionActivity.class);
                        startActivity(intent);
                    }

                    @Override
                    public void onAnimationRepeat(Animation animation) {

                    }
                });
                rippleBackground.startAnimation(bottomUp);
            }
        });

    }
}
