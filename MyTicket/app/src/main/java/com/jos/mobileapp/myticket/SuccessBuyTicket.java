package com.jos.mobileapp.myticket;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class SuccessBuyTicket extends AppCompatActivity {
    Animation app_splash,anim_subttile,anim_get_started;
    Button btn_view_ticket, btn_my_dashboard;
    ImageView icon_success_ticket;
    TextView app_title, app_subtitle_success;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_success_buy_ticket);
        btn_view_ticket= findViewById(R.id.btn_view_ticket);
        btn_my_dashboard = findViewById(R.id.btn_my_dashboard);
        icon_success_ticket = findViewById(R.id.icon_success_ticket);
        app_subtitle_success = findViewById(R.id.app_subtitle_success);
        app_title = findViewById(R.id.app_title);


        //load animation
        app_splash = AnimationUtils.loadAnimation(this, R.anim.app_splash);
        anim_subttile = AnimationUtils.loadAnimation(this,R.anim.anim_subtitle);
        anim_get_started = AnimationUtils.loadAnimation(this,R.anim.anim_get_started);

        btn_view_ticket.startAnimation(anim_subttile);
        btn_my_dashboard.startAnimation(anim_subttile);
        icon_success_ticket.startAnimation(app_splash);
        app_subtitle_success.startAnimation(anim_get_started);
        app_title.startAnimation(anim_get_started);
        btn_view_ticket.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent gotomyprofile = new Intent(SuccessBuyTicket.this, MyProfile.class);
                startActivity(gotomyprofile);
            }
        });

        btn_my_dashboard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent gotodash = new Intent(SuccessBuyTicket.this, Home.class);
                startActivity(gotodash);
            }
        });
    }
}
