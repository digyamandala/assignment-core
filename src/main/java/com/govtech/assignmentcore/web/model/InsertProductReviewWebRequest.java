package com.govtech.assignmentcore.web.model;

public class InsertProductReviewWebRequest {

  private String comment;

  private double rating;

  public InsertProductReviewWebRequest() {
  }

  public String getComment() {
    return comment;
  }

  public void setComment(String comment) {
    this.comment = comment;
  }

  public double getRating() {
    return rating;
  }

  public void setRating(double rating) {
    this.rating = rating;
  }
}
