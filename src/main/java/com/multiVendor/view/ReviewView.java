package com.multiVendor.view;

public class ReviewView {

    private Integer id;

    private String review;

    private Integer rating;

    public ReviewView() {
        super();
    }

    public ReviewView(Integer id, String review, Integer rating) {
        this.id = id;
        this.review = review;
        this.rating = rating;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getReview() {
        return review;
    }

    public void setReview(String review) {
        this.review = review;
    }

    public Integer getRating() {
        return rating;
    }

    public void setRating(Integer rating) {
        this.rating = rating;
    }

}
