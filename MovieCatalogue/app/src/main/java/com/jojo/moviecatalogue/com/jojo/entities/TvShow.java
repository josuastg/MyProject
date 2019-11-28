package com.jojo.moviecatalogue.com.jojo.entities;

import android.os.Parcel;
import android.os.Parcelable;

public class TvShow implements Parcelable {
    private int poster;
    private String title, year, genre, duration, description, creator, rating;

    public int getPoster() {
        return poster;
    }

    public String getCreator() {
        return creator;
    }

    public void setPoster(int poster) {
        this.poster = poster;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public String getDuration() {
        return duration;
    }

    public void setDuration(String duration) {
        this.duration = duration;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }


    public void setCreator(String creator) {
        this.creator = creator;
    }

    public String getRating() {
        return rating;
    }

    public void setRating(String rating) {
        this.rating = rating;
    }

    public TvShow() {
    }

    ;


    protected TvShow(Parcel ins) {
        this.poster = ins.readInt();
        this.description = ins.readString();
        this.creator = ins.readString();
        this.duration = ins.readString();
        this.genre = ins.readString();
        this.rating = ins.readString();
        this.year = ins.readString();
        this.title = ins.readString();
    }

    public static final Creator<TvShow> CREATOR = new Creator<TvShow>() {
        @Override
        public TvShow createFromParcel(Parcel in) {
            return new TvShow(in);
        }

        @Override
        public TvShow[] newArray(int size) {
            return new TvShow[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(this.poster);
        dest.writeString(this.description);
        dest.writeString(this.creator);
        dest.writeString(this.duration);
        dest.writeString(this.genre);
        dest.writeString(this.rating);
        dest.writeString(this.year);
        dest.writeString(this.title);

    }
}
