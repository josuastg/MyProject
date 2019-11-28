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
import com.jojo.moviecatalogue.com.jojo.entities.TvShow;
import com.jojo.moviecatalogue.com.jojo.tvshow.DetailTvShow;

import java.util.ArrayList;

public class TvShowAdapter extends RecyclerView.Adapter<TvShowAdapter.ViewHolder> {
    private ArrayList<TvShow> listTvShow;
    private Context context;


    public void setListTvshow(ArrayList<TvShow> listTvshow) {
        this.listTvShow = listTvshow;
    }

    public TvShowAdapter(Context context, ArrayList<TvShow> listTvshow) {
        this.context = context;
        this.listTvShow = listTvshow;
    }

    public TvShowAdapter(ArrayList<TvShow> listTvShow) {
        this.listTvShow = listTvShow;
    }

    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_row_tvshow, parent, false);
        return new ViewHolder(view);

    }

    @Override
    public void onBindViewHolder(@NonNull final ViewHolder holder, int position) {
        TvShow dataTvShow = listTvShow.get(position);
        holder.img_poster.setImageResource(dataTvShow.getPoster());
        holder.tv_title.setText(dataTvShow.getTitle());
        holder.tv_rating.setText(dataTvShow.getRating());
        holder.tv_desc.setText(dataTvShow.getDescription());
        holder.tv_creator.setText(dataTvShow.getCreator());
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent detail = new Intent(holder.itemView.getContext(), DetailTvShow.class);
                detail.putExtra(DetailTvShow.DETAIL_TVSHOW, listTvShow.get(holder.getAdapterPosition()));
                holder.itemView.getContext().startActivity(detail);
            }
        });

    }


    @Override
    public int getItemCount() {
        return listTvShow.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private TextView tv_title, tv_rating, tv_desc, tv_creator;
        private ImageView img_poster;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            tv_creator = itemView.findViewById(R.id.tv_director_tvshow);
            tv_desc = itemView.findViewById(R.id.tv_description_tvshow);
            tv_title = itemView.findViewById(R.id.tv_title_tvshow);
            tv_rating = itemView.findViewById(R.id.tv_rating_tvshow);
            img_poster = itemView.findViewById(R.id.imgPoster_tvhshow);


        }
    }
}
