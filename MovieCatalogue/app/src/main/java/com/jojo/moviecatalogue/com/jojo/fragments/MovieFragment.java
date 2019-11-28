package com.jojo.moviecatalogue.com.jojo.fragments;


import android.content.res.TypedArray;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.jojo.moviecatalogue.com.jojo.adapter.MovieAdapter;
import com.jojo.moviecatalogue.R;
import com.jojo.moviecatalogue.com.jojo.entities.Movie;

import java.util.ArrayList;

public class MovieFragment extends Fragment {
    private MovieAdapter movieAdapter;
    private ArrayList<Movie> listMovies;
    private String[] movieTitle, movieYear, movieRating, movieDescription, movieDirector, movieGenre, movieDuration;
    private TypedArray moviePoster;


    public MovieFragment() {
        // Required empty public constructor
    }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        addData();
        addComponent();

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_movie, container, false);
        showListMovies(view);
        return view;
    }


    public void addData() {
        movieTitle = getResources().getStringArray(R.array.movie_title);
        movieDuration = getResources().getStringArray(R.array.movie_duration);
        movieDescription = getResources().getStringArray(R.array.movie_desc);
        movieGenre = getResources().getStringArray(R.array.movie_genre);
        movieDirector = getResources().getStringArray(R.array.movie_director);
        moviePoster = getResources().obtainTypedArray(R.array.movie_photo);
        movieYear = getResources().getStringArray(R.array.movie_year);
        movieRating = getResources().getStringArray(R.array.movie_rating);
    }

    public void addComponent() {
        listMovies = new ArrayList<>();
        movieAdapter = new MovieAdapter(listMovies);

        for (int position = 0; position < movieTitle.length; position++) {
            Movie movie = new Movie();
            movie.setTitle(movieTitle[position]);
            movie.setRating(movieRating[position]);
            movie.setYear(movieYear[position]);
            movie.setDirector(movieDirector[position]);
            movie.setDescription(movieDescription[position]);
            movie.setDuration(movieDuration[position]);
            movie.setPoster(moviePoster.getResourceId(position, -1));
            movie.setGenre(movieGenre[position]);
            this.listMovies.add(movie);

        }
        movieAdapter.setMovies(listMovies);
    }

    private void showListMovies(View view) {
        RecyclerView recyclerView = view.findViewById(R.id.rv_movie);
        movieAdapter = new MovieAdapter(getContext(), listMovies);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        recyclerView.setAdapter(movieAdapter);


    }


}
