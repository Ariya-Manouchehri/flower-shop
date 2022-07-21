package com.example.flowershop;

public class Comment {
    String name,comment;
    float rating;

    public Comment(String name, String comment, float rating) {
        this.name = name;
        this.comment = comment;
        this.rating = rating;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public float getRating() {
        return rating;
    }

    public void setRating(float rating) {
        this.rating = rating;
    }
}
