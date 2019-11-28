package com.jojo.moviecatalogue.com.jojo.movie;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.jojo.moviecatalogue.R;
import com.jojo.moviecatalogue.com.jojo.entities.Movie;

public class DetailMovie extends AppCompatActivity {
    ImageView poster;
    TextView title, year, genre, duration, description;
    Movie movie;
    public static final String DETAIL_MOVIE = "DETAIL_MOVIE";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_movie);

        movie = getIntent().getParcelableExtra("DETAIL_MOVIE");
        title = findViewById(R.id.tv_title);
        poster = findViewById(R.id.imgPoster);
        year = findViewById(R.id.year);
        genre = findViewById(R.id.tv_genre);
        duration = findViewById(R.id.tv_duration);
        description = findViewById(R.id.tv_description);
        show(movie);


    }

    public void show(Movie movies) {
        year.setText(movies.getYear());
        description.setText(movies.getDescription());
        poster.setImageResource(movies.getPoster());
        duration.setText(movies.getDuration());
        genre.setText(movies.getGenre());
        title.setText(movies.getTitle());

    }


}
