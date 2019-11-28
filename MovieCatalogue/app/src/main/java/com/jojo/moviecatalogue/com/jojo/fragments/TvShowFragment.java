package com.jojo.moviecatalogue.com.jojo.fragments;


import android.content.res.TypedArray;
import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.jojo.moviecatalogue.R;
import com.jojo.moviecatalogue.com.jojo.adapter.TvShowAdapter;
import com.jojo.moviecatalogue.com.jojo.entities.TvShow;

import java.util.ArrayList;


public class TvShowFragment extends Fragment {
    private ArrayList<TvShow> listTvShow;
    private TvShowAdapter tvShowAdapter;
    private String[] tvShowTitle, tvShowYear, tvShowRating, tvShowDescription, tvShowCreator, tvShowGenre, tvShowDuration;
    private TypedArray tvShowPoster;

    public TvShowFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        addData();
        addComponent();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_tv_show, container, false);
        showListTvShow(view);
        return view;
    }

    public void addData() {
        tvShowTitle = getResources().getStringArray(R.array.tvshow_title);
        tvShowDuration = getResources().getStringArray(R.array.tvshow_duration);
        tvShowDescription = getResources().getStringArray(R.array.tvshow_desc);
        tvShowPoster = getResources().obtainTypedArray(R.array.tvshow_photo);
        tvShowGenre = getResources().getStringArray(R.array.tvshow_genre);
        tvShowCreator = getResources().getStringArray(R.array.tvshow_creator);
        tvShowRating = getResources().getStringArray(R.array.tvshow_rating);
        tvShowYear = getResources().getStringArray(R.array.tvshow_year);
    }

    public void addComponent() {
        listTvShow = new ArrayList<>();
        tvShowAdapter = new TvShowAdapter(listTvShow);

        for (int position = 0; position < tvShowTitle.length; position++) {
            TvShow tvShow = new TvShow();
            tvShow.setTitle(tvShowTitle[position]);
            tvShow.setRating(tvShowRating[position]);
            tvShow.setYear(tvShowYear[position]);
            tvShow.setCreator(tvShowCreator[position]);
            tvShow.setDescription(tvShowDescription[position]);
            tvShow.setDuration(tvShowDuration[position]);
            tvShow.setPoster(tvShowPoster.getResourceId(position, -1));
            tvShow.setGenre(tvShowGenre[position]);
            this.listTvShow.add(tvShow);
        }
        tvShowAdapter.setListTvshow(listTvShow);

    }


    private void showListTvShow(View view) {
        RecyclerView recyclerView = view.findViewById(R.id.rv_tvshow);
        tvShowAdapter = new TvShowAdapter(getContext(), listTvShow);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        recyclerView.setAdapter(tvShowAdapter);

    }


}
