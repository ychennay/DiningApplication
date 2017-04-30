package com.application.model;

/**
 * Created by ychen4 on 4/30/2017.
 */
public class Review {

    public int id;
    public String userName;
    public String reviewText;

    public Review(int id, String userName, String reviewText) {
        this.id = id;
        this.userName = userName;
        this.reviewText = reviewText;
    }

    public Review(){}

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getReviewText() {
        return reviewText;
    }

    public void setReviewText(String reviewText) {
        this.reviewText = reviewText;
    }

    @Override
    public String toString() {
        return "Review{" +
                "id=" + id +
                ", userName='" + userName + '\'' +
                ", reviewText='" + reviewText + '\'' +
                '}';
    }
}
