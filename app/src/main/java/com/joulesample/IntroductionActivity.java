package com.joulesample;

import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;

import com.rd.PageIndicatorView;
import com.skyfishjy.library.RippleBackground;

import static android.R.attr.button;

/**
 * Created by Umang on 30/11/17.
 */

public class IntroductionActivity extends AppCompatActivity {


    public PageIndicatorView pageIndicatorView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.introduction);

        ViewPager viewPager = (ViewPager) findViewById(R.id.viewPager);
        viewPager.setAdapter(new IntroductionAdapter(IntroductionActivity.this));

        pageIndicatorView = (PageIndicatorView) findViewById(R.id.pageIndicatorView);
        pageIndicatorView.setViewPager(viewPager);

        viewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
                Log.e("onPageScrolled:: ", position + "");
                if (position != 4) {
                    pageIndicatorView.setVisibility(View.VISIBLE);
                }
            }

            @Override
            public void onPageSelected(int position) {
                Log.e("onPageSelected:: ", position + "");

                //FOR LAST SCREEN ANIMATION

                if (position == 4) {
                    final RippleBackground rippleBackground = (RippleBackground) findViewById(R.id.content_start);
                    rippleBackground.startRippleAnimation();
                    final Button button = (Button) findViewById(R.id.start);
                    Animation bottomUp = AnimationUtils.loadAnimation(IntroductionActivity.this, R.anim.right_left);
                    bottomUp.setAnimationListener(new Animation.AnimationListener() {
                        @Override
                        public void onAnimationStart(Animation animation) {
                            button.setVisibility(View.INVISIBLE);
                            pageIndicatorView.setVisibility(View.INVISIBLE);
                        }

                        @Override
                        public void onAnimationEnd(Animation animation) {
                            pageIndicatorView.setVisibility(View.INVISIBLE);
                            button.setVisibility(View.VISIBLE);
                            rippleBackground.startRippleAnimation();
                        }

                        @Override
                        public void onAnimationRepeat(Animation animation) {

                        }
                    });

                    rippleBackground.startAnimation(bottomUp);

                } else {
                    pageIndicatorView.setVisibility(View.VISIBLE);
                }

            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
    }
}
