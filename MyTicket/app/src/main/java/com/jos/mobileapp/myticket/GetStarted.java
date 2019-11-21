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

public class GetStarted extends AppCompatActivity {
    Button btn_sign_in,btn_new_account_create;
    Animation anim_get_started,anim_subtitle;
    ImageView emblem_app;
    TextView  intro_app;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_get_started);
        anim_get_started = AnimationUtils.loadAnimation(this,R.anim.anim_get_started);
        anim_subtitle = AnimationUtils.loadAnimation(this,R.anim.anim_subtitle);

        btn_sign_in = findViewById(R.id.btn_sign_in);
        btn_new_account_create = findViewById(R.id.btn_new_account_create);
        emblem_app = findViewById(R.id.emblem_app);
        intro_app = findViewById(R.id.intro_app);
        emblem_app.startAnimation(anim_get_started);
        intro_app.startAnimation(anim_get_started);
        btn_new_account_create.startAnimation(anim_subtitle);
        btn_sign_in.startAnimation(anim_subtitle);
        btn_sign_in.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent gotosign = new Intent(GetStarted.this, SignIn.class);
                startActivity(gotosign);
            }
        });
        btn_new_account_create.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent gotoregis = new Intent(GetStarted.this, RegisterOne.class);
                startActivity(gotoregis);
            }
        });
    }
}
