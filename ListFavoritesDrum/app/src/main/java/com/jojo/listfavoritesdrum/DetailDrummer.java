package com.jojo.listfavoritesdrum;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.codesgood.views.JustifiedTextView;
import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.YouTubePlayer;
import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.listeners.AbstractYouTubePlayerListener;
import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.views.YouTubePlayerView;

public class DetailDrummer extends AppCompatActivity {

TextView tvname;
TextView tvDetail;
ImageView ivDrum;






    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_drummer);

        tvname = findViewById(R.id.tvName);
        tvDetail = findViewById(R.id.tvDetails);
//        ivDrum = findViewById(R.id.imageView);

        final Intent intent = getIntent();
        String name = intent.getStringExtra("drummer");
        String details = intent.getStringExtra("detail");
        int images = intent.getIntExtra("photo",0);

        tvname.setText(name);
        tvDetail.setText(details);
//        ivDrum.setImageResource(images);

        //      playerView = findViewById(R.id.player);
        YouTubePlayerView youTubePlayerView = findViewById(R.id.youtube);
        getLifecycle().addObserver(youTubePlayerView);
        youTubePlayerView.addYouTubePlayerListener(new AbstractYouTubePlayerListener() {
            @Override
            public void onReady(YouTubePlayer youTubePlayer) {

//            Drummer data = (Drummer) getIntent().getSerializableExtra("videos");
               // String video = intent.getStringExtra("videos");


              final Intent i = getIntent();
                String data = i.getStringExtra("videos");

                youTubePlayer.loadVideo(data,0);
            }
        });







        //    Intent intent = getIntent().getParcelableExtra("drummer");
//    intent = getIntent().getParcelableExtra("detail");
////        tvname = getIntent().getSerializableExtra("drummer");
//        getIntent().getSerializableExtra("detail");


    }
}
