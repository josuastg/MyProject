package com.jojo.moviecatalogue.com.jojo.adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.jojo.moviecatalogue.R;
import com.jojo.moviecatalogue.com.jojo.entities.Movie;
import com.jojo.moviecatalogue.com.jojo.movie.DetailMovie;

import java.util.ArrayList;

public class MovieAdapter extends RecyclerView.Adapter<MovieAdapter.ViewHolder> {
    private Context context;
    private ArrayList<Movie> movies;

    public void setMovies(ArrayList<Movie> movies) {
        this.movies = movies;
    }

    public MovieAdapter(Context context, ArrayList<Movie> movies) {
        this.context = context;
        this.movies = movies;
    }

    public MovieAdapter(ArrayList<Movie> movies) {
        this.movies = movies;
    }


    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_row_movie, parent, false);

        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull final ViewHolder holder, int position) {
        Movie dataMovies = movies.get(position);
        holder.img_poster.setImageResource(dataMovies.getPoster());
        holder.tv_title.setText(dataMovies.getTitle());
        holder.tv_rating.setText(dataMovies.getRating());
        holder.tv_desc.setText(dataMovies.getDescription());
        holder.tv_direct.setText(dataMovies.getDirector());
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent detail = new Intent(holder.itemView.getContext(), DetailMovie.class);
                detail.putExtra(DetailMovie.DETAIL_MOVIE, movies.get(holder.getAdapterPosition()));
                holder.itemView.getContext().startActivity(detail);
            }
        });

    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public int getItemCount() {
        return movies.size();
    }


    public class ViewHolder extends RecyclerView.ViewHolder {
        private TextView tv_title, tv_rating, tv_desc, tv_direct;
        private ImageView img_poster;

        ViewHolder(View view) {
            super(view);
            tv_title = view.findViewById(R.id.tv_title);
            tv_rating = view.findViewById(R.id.rating);
            tv_desc = view.findViewById(R.id.tv_description);
            img_poster = view.findViewById(R.id.imgPoster);
            tv_direct = view.findViewById(R.id.tv_director);

        }


    }

}
