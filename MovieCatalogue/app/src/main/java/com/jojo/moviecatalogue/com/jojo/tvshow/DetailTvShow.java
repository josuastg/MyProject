package com.jojo.moviecatalogue.com.jojo.tvshow;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.jojo.moviecatalogue.R;
import com.jojo.moviecatalogue.com.jojo.entities.TvShow;

public class DetailTvShow extends AppCompatActivity {
    ImageView poster;
    TextView title, year, genre, duration, description;
    TvShow tvShow;
    public static final String DETAIL_TVSHOW = "DETAIL_TVSHOW";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_tv_show);
        tvShow = getIntent().getParcelableExtra("DETAIL_TVSHOW");
        poster = findViewById(R.id.imgPoster_tvhshow);
        title = findViewById(R.id.tv_title_tvshow);
        year = findViewById(R.id.tv_year_tvshow);
        genre = findViewById(R.id.tv_genre_tvhshow);
        duration = findViewById(R.id.tv_duration_tvshow);
        description = findViewById(R.id.tv_description_tvshow);
        Show(tvShow);
    }

    public void Show(TvShow tvShow) {
        title.setText(tvShow.getTitle());
        year.setText(tvShow.getYear());
        genre.setText(tvShow.getGenre());
        duration.setText(tvShow.getDuration());
        description.setText(tvShow.getDescription());
        poster.setImageResource(tvShow.getPoster());
    }
}
