package com.jos.mobileapp.myticket;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class SuccessRegister extends AppCompatActivity {
    Button btn_explore;
    ImageView icon_success;
    TextView success_title,success_subtitle ;
    Animation app_splash,anim_subttile,anim_get_started;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_success_register);
        btn_explore = findViewById(R.id.btn_explore);
        icon_success = findViewById(R.id.icon_success);
        success_title = findViewById(R.id.success_title);
        success_subtitle = findViewById(R.id.success_subtitle);

        //load animation
        app_splash = AnimationUtils.loadAnimation(this, R.anim.app_splash);
        anim_subttile = AnimationUtils.loadAnimation(this,R.anim.anim_subtitle);
        anim_get_started = AnimationUtils.loadAnimation(this,R.anim.anim_get_started);
        //run animation
        btn_explore.startAnimation(anim_subttile);
        icon_success.startAnimation(app_splash);
        success_title.startAnimation(anim_get_started);
        success_subtitle.startAnimation(anim_get_started);

        btn_explore.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent gotohome = new Intent (SuccessRegister.this, Home.class);
                startActivity(gotohome);
            }
        });
    }
}
