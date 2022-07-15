package com.example.flowershop;

public class Flower {
    String name;
    int photo,ratingbar;

    public Flower(String name, int photo, int ratingbar) {
        this.name = name;
        this.photo = photo;
        this.ratingbar = ratingbar;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPhoto() {
        return photo;
    }

    public void setPhoto(int photo) {
        this.photo = photo;
    }

    public int getRatingbar() {
        return ratingbar;
    }

    public void setRatingbar(int ratingbar) {
        this.ratingbar = ratingbar;
    }
}
