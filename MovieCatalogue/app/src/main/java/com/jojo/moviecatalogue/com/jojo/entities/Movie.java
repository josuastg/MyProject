package com.jojo.moviecatalogue.com.jojo.entities;

import android.os.Parcel;
import android.os.Parcelable;

public class Movie implements Parcelable {


    private int poster;
    private String title, year, genre, duration, description, director, rating;

    public int getPoster() {
        return poster;
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

    public String getDirector() {
        return director;
    }

    public void setDirector(String director) {
        this.director = director;
    }

    public String getRating() {
        return rating;
    }

    public void setRating(String rating) {
        this.rating = rating;
    }

    public Movie() {
    }

    ;

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(this.poster);
        dest.writeString(this.description);
        dest.writeString(this.director);
        dest.writeString(this.duration);
        dest.writeString(this.genre);
        dest.writeString(this.rating);
        dest.writeString(this.year);
        dest.writeString(this.title);


    }

    protected Movie(Parcel ins) {
        this.poster = ins.readInt();
        this.description = ins.readString();
        this.director = ins.readString();
        this.duration = ins.readString();
        this.genre = ins.readString();
        this.rating = ins.readString();
        this.year = ins.readString();
        this.title = ins.readString();
    }

    public static final Parcelable.Creator<Movie> CREATOR = new Parcelable.Creator<Movie>() {
        @Override
        public Movie createFromParcel(Parcel source) {
            return new Movie(source);
        }

        @Override
        public Movie[] newArray(int size) {
            return new Movie[size];
        }
    };


}
