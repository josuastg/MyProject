package com.jos.mobileapp.myticket;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;

public class SplashScreen extends AppCompatActivity {
    Animation app_splash,anim_subttile;
    ImageView app_logo;
    TextView  app_subtitle;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splashscreen);
        app_splash = AnimationUtils.loadAnimation(this, R.anim.app_splash);
        anim_subttile = AnimationUtils.loadAnimation(this,R.anim.anim_subtitle);
        app_logo = findViewById(R.id.app_logo);
        app_subtitle = findViewById(R.id.app_subtitle);
        //run animation
        app_logo.startAnimation(app_splash);
        app_subtitle.startAnimation(anim_subttile);
        Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent get = new Intent(SplashScreen.this, GetStarted.class);
                startActivity(get);
                finish();
            }
        }, 2000); // 2s
    }
}