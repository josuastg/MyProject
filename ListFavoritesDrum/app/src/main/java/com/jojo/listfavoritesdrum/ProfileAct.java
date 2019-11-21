package com.jojo.listfavoritesdrum;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.google.android.youtube.player.YouTubeBaseActivity;
import com.google.android.youtube.player.YouTubeInitializationResult;
import com.google.android.youtube.player.YouTubePlayer;
import com.google.android.youtube.player.YouTubePlayerView;

public class ProfileAct extends AppCompatActivity{
//    YouTubePlayerView playerView;
//
//    String API_KEY = "AIzaSyCzUX2SO7NdkDVIKfDYXLPLSapQ95RiHMM";
//    String VIDEO_ID = "aJ7BoNG-r2c";



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);
        if (getSupportActionBar() != null) {
            getSupportActionBar().setTitle("My Profile");
        }
//        playerView = findViewById(R.id.player);
//        playerView.initialize(API_KEY, this);



    }
//    @Override
//    public void onInitializationSuccess(YouTubePlayer.Provider provider, YouTubePlayer youTubePlayer, boolean b) {
//
//    youTubePlayer.setPlayerStateChangeListener(this);
//    youTubePlayer.setPlaybackEventListener(this);
//    if (!b) {
//        youTubePlayer.cueVideo(VIDEO_ID);
//
//    }
//
//    }
//
//    @Override
//    public void onPlaying() {
//
//    }
//
//    @Override
//    public void onLoaded(String s) {
//
//    }
//
//    @Override
//    public void onLoading() {
//
//    }
//
//    @Override
//    public void onVideoStarted() {
//
//    }
//
//    @Override
//    public void onVideoEnded() {
//
//    }
//
//    @Override
//    public void onError(YouTubePlayer.ErrorReason errorReason) {
//
//    }
//
//    @Override
//    public void onAdStarted() {
//
//    }
//
//    @Override
//    public void onBuffering(boolean b) {
//
//    }
//
//    @Override
//    public void onStopped() {
//
//    }
//
//    @Override
//    public void onPaused() {
//
//    }
//
//    @Override
//    public void onSeekTo(int i) {
//
//    }
//
//
//
//    @Override
//    public void onInitializationFailure(YouTubePlayer.Provider provider, YouTubeInitializationResult youTubeInitializationResult) {
//
//    }
//
//    YouTubeBaseActivity implements YouTubePlayer.OnInitializedListener,
//    YouTubePlayer.PlaybackEventListener,YouTubePlayer.PlayerStateChangeListener
}
