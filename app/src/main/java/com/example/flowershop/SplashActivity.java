package com.example.flowershop;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.flowershop.Activity.MainActivity;

public class SplashActivity extends AppCompatActivity {

    private static final int SPLASH_SCREEN_TIME_OUT = 2000;
    ImageView app_icon;
    TextView app_name;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);

        app_icon = findViewById(R.id.appIcon);
        app_name = findViewById(R.id.appName);
        Animation animation_icon = AnimationUtils.loadAnimation(SplashActivity.this, R.anim.splash_rotate);
        Animation animation_name = AnimationUtils.loadAnimation(SplashActivity.this, R.anim.splash_fadein);

        app_icon.startAnimation(animation_icon);
        app_name.startAnimation(animation_name);


        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent intent = new Intent(SplashActivity.this, MainActivity.class);
                startActivity(intent);
                finish();
            }
        }, SPLASH_SCREEN_TIME_OUT);
    }
}