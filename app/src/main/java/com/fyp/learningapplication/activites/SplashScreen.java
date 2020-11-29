package com.fyp.learningapplication.activites;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Toast;

import com.fyp.learningapplication.R;
import com.fyp.learningapplication.extra.ExtraFeatures;

public class SplashScreen extends AppCompatActivity {
    private static int SPLASH_TIME_OUT = 3000;
    private static int UI_TIME_OUT = 1000;
    private ExtraFeatures features;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        //hide status bar
        features = new ExtraFeatures(this);
        View v = getWindow().getDecorView();
        v.setOnSystemUiVisibilityChangeListener(listener);
        //Calling Splash Screen Timer
        runSplash();
    }


    private void runSplash() {
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                //moving to new activity
                Toast.makeText(SplashScreen.this, "Splash Added...", Toast.LENGTH_SHORT).show();
            }
        }, SPLASH_TIME_OUT);
    }

    View.OnSystemUiVisibilityChangeListener listener = new View.OnSystemUiVisibilityChangeListener() {
        @Override
        public void onSystemUiVisibilityChange(int visibility) {
            if (visibility == 0) {
                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        features.hideSystemUI();
                    }
                }, UI_TIME_OUT);
            }
        }
    };

    @Override
    public void onWindowFocusChanged(boolean hasFocus) {
        super.onWindowFocusChanged(hasFocus);
        if (hasFocus) {
            features.hideSystemUI();
        }
    }
}