package com.joulesample;

import android.content.Context;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.RelativeLayout;

/**
 * Created by Umang on 30/11/17.
 */

public class IntroductionAdapter extends PagerAdapter {

    IntroductionActivity context;

    public IntroductionAdapter(Context context) {
        this.context = (IntroductionActivity) context;
    }


    @Override
    public int getCount() {
        return 5;
    }


    @Override
    public boolean isViewFromObject(View view, Object object) {
        return view == object;
    }

    @Override
    public Object instantiateItem(final ViewGroup container, int position) {
        LayoutInflater inflater = (LayoutInflater) container.getContext()
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        // Using different layouts in the view pager instead of images.

        int resId = -1;

        switch (position) {
            case 0:
                resId = R.layout.first_page;
                break;
            case 1:
                resId = R.layout.second_page;
                break;
            case 2:
                resId = R.layout.third_page;
                break;
            case 3:
                resId = R.layout.fourth_page;
                break;
            case 4:
                resId = R.layout.fifth_page;
                break;
        }

        final View view = inflater.inflate(resId, container, false);
        ((ViewPager) container).addView(view, 0);

        if (position == 0) {    //PHONE VISIBLE

            ImageView triangle = view.findViewById(R.id.triangle);
            ImageView smallalien1 = view.findViewById(R.id.smallalien1);
            ImageView bulb1 = view.findViewById(R.id.bulb1);
            ImageView smallBulb1 = view.findViewById(R.id.smallBulb1);
            ImageView smallBulb = view.findViewById(R.id.smallBulb);
            ImageView alien = view.findViewById(R.id.alien);
            ImageView smallalien = view.findViewById(R.id.smallalien);
            ImageView bulb3 = view.findViewById(R.id.bulb3);
            ImageView alien1 = view.findViewById(R.id.alien1);
            ImageView bulb2 = view.findViewById(R.id.bulb2);
            ImageView phone = view.findViewById(R.id.phone);

            phone.setAlpha(0f);
            phone.setVisibility(View.VISIBLE);

            phone.animate().alpha(1f).setDuration(1000).setListener(null);

            triangle.setAlpha(0f);
            triangle.setVisibility(View.VISIBLE);

            triangle.animate().alpha(1f).setDuration(4000).setListener(null);

            smallalien1.setAlpha(0f);
            smallalien1.setVisibility(View.VISIBLE);

            smallalien1.animate().alpha(1f).setDuration(5000).setListener(null);

            bulb1.setAlpha(0f);
            bulb1.setVisibility(View.VISIBLE);

            bulb1.animate().alpha(1f).setDuration(5000).setListener(null);

            alien.setAlpha(0f);
            alien.setVisibility(View.VISIBLE);

            alien.animate().alpha(1f).setDuration(7000).setListener(null);

            smallBulb1.setAlpha(0f);
            smallBulb1.setVisibility(View.VISIBLE);

            smallBulb1.animate().alpha(1f).setDuration(9000).setListener(null);

            smallBulb.setAlpha(0f);
            smallBulb.setVisibility(View.VISIBLE);

            smallBulb.animate().alpha(1f).setDuration(10000).setListener(null);

            bulb3.setAlpha(0f);
            bulb3.setVisibility(View.VISIBLE);

            bulb3.animate().alpha(1f).setDuration(11000).setListener(null);

            smallalien.setAlpha(0f);
            smallalien.setVisibility(View.VISIBLE);

            smallalien.animate().alpha(1f).setDuration(13000).setListener(null);

            bulb2.setAlpha(0f);
            bulb2.setVisibility(View.VISIBLE);

            bulb2.animate().alpha(1f).setDuration(15000).setListener(null);

            alien1.setAlpha(0f);
            alien1.setVisibility(View.VISIBLE);

            alien1.animate().alpha(1f).setDuration(17000).setListener(null);

        } else if (position == 1) {     //BULB VISIBLE

            final ImageView bulbImage = view.findViewById(R.id.bulb);
            final ImageView outlineImage = view.findViewById(R.id.ouline);

            bulbImage.setAlpha(0f);
            bulbImage.setVisibility(View.VISIBLE);

            bulbImage.animate()
                    .alpha(1f)
                    .setDuration(4000)
                    .setListener(null);

            outlineImage.setAlpha(0f);
            outlineImage.setVisibility(View.VISIBLE);

            outlineImage.animate()
                    .alpha(1f)
                    .setDuration(10000)
                    .setListener(null);

        } else if (position == 2) {             //NOTIFICATION

            final RelativeLayout centerBus = view.findViewById(R.id.centerBus);
            final RelativeLayout centerBuslarge = view.findViewById(R.id.centerBuslarge);
            final RelativeLayout notification = view.findViewById(R.id.notification);

            centerBus.setAlpha(1f);

            centerBus.animate()
                    .alpha(0f)
                    .setDuration(4000)
                    .setListener(null);

            centerBuslarge.setAlpha(0f);
            centerBuslarge.setVisibility(View.VISIBLE);

            centerBuslarge.animate()
                    .alpha(1f)
                    .setDuration(7000)
                    .setListener(null);

            notification.setAlpha(0f);
            notification.setVisibility(View.VISIBLE);

            notification.animate()
                    .alpha(1f)
                    .setDuration(8000)
                    .setListener(null);

        } else if (position == 3) {           //ENERGY ROTATION

            RelativeLayout linearLayout = view.findViewById(R.id.layout_linear);
            linearLayout.startAnimation(
                    AnimationUtils.loadAnimation(context, R.anim.rotate));

        }
        return view;
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        container.removeView((View) object);
    }

}

