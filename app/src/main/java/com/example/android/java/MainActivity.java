package com.example.android.java;

import android.animation.Animator;
import android.annotation.TargetApi;
import android.graphics.Path;
import android.os.Build;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.transition.Transition;
import android.transition.TransitionValues;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.view.animation.PathInterpolator;
import android.widget.ImageView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private ImageView imageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        imageView = (ImageView) findViewById(R.id.faceIcon);


        /* arcTo() and PathInterpolator only available on API 21+
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            Path path = new Path();
            path.arcTo(0f, 0f, 1000f, 1000f, 270f, -180f, true);
            PathInterpolator pathInterpolator = new PathInterpolator(path);
        }*/


    }

    public void onButtonClick(View v) {
        Animation grow =
                AnimationUtils.loadAnimation(this, R.anim.grow);
        final Animation blink = AnimationUtils.loadAnimation(this, R.anim.brillo);
        final Animation zoom_in = AnimationUtils.loadAnimation(this, R.anim.zoom_in);
        final Animation zoom_out = AnimationUtils.loadAnimation(this, R.anim.zoom_out);
        final Animation fade_in = AnimationUtils.loadAnimation(this, R.anim.concolor);
        final Animation fade_out = AnimationUtils.loadAnimation(this, R.anim.sincolor);
        //final Animation inter = AnimationUtils.loadAnimation(this, R.anim.interpolator);




        /*animation.setAnimationListener(new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {
            }

            @Override
            public void onAnimationEnd(Animation animation) {
                imageView.setScaleX(2);
                imageView.setScaleY(2);
            }

            @Override
            public void onAnimationRepeat(Animation animation) {
            }
        });*/

        grow.setAnimationListener(new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {
            }

            @Override
            public void onAnimationEnd(Animation animation) {
                //imageView.setScaleX(2);
                //imageView.setScaleY(2);
                imageView.startAnimation(zoom_out);
                //
            }

            @Override
            public void onAnimationRepeat(Animation animation) {
            }
        });





        blink.setAnimationListener(new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {

            }

            @Override
            public void onAnimationEnd(Animation animation) {
                //imageView.startAnimation(zoom_out);
            }

            @Override
            public void onAnimationRepeat(Animation animation) {

            }
        });
        /*inter.setAnimationListener(new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {

            }

            @Override
            public void onAnimationEnd(Animation animation) {
                //imageView.startAnimation(zoom_out);
                imageView.startAnimation(blink);
            }

            @Override
            public void onAnimationRepeat(Animation animation) {

            }
        });*/
        zoom_in.setAnimationListener(new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {

            }

            @Override
            public void onAnimationEnd(Animation animation) {
                imageView.startAnimation(blink);
                //imageView.startAnimation(inter);
            }

            @Override
            public void onAnimationRepeat(Animation animation) {

            }
        });
        zoom_out.setAnimationListener(new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {

            }

            @Override
            public void onAnimationEnd(Animation animation) {
                imageView.startAnimation(fade_out);
            }

            @Override
            public void onAnimationRepeat(Animation animation) {

            }
        });
        fade_in.setAnimationListener(new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {

            }

            @Override
            public void onAnimationEnd(Animation animation) {
                imageView.startAnimation(zoom_in);
            }

            @Override
            public void onAnimationRepeat(Animation animation) {

            }
        });
        fade_out.setAnimationListener(new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {

            }

            @Override
            public void onAnimationEnd(Animation animation) {
                imageView.startAnimation(fade_in);
            }

            @Override
            public void onAnimationRepeat(Animation animation) {

            }
        });









        imageView.startAnimation(grow);
    }



}

/*@TargetApi(Build.VERSION_CODES.KITKAT)
class CustomTransition extends Transition {

    // Define a key for storing a property value in
    // TransitionValues.values with the syntax
    // package_name:transition_class:property_name to avoid collisions
    private static final String PROPNAME_BACKGROUND =
            "com.example.android.customtransition:CustomTransition:background";

    @Override
    public void captureStartValues(TransitionValues transitionValues) {
        // Call the convenience method captureValues
        captureValues(transitionValues);
    }


    // For the view in transitionValues.view, get the values you
    // want and put them in transitionValues.values
    private void captureValues(TransitionValues transitionValues) {
        // Get a reference to the view
        View view = transitionValues.view;
        // Store its background property in the values map
        transitionValues.values.put(PROPNAME_BACKGROUND, view.getBackground());
    }

    @Override
    public void captureEndValues(TransitionValues transitionValues) {
        captureValues(transitionValues);
    }

}*/