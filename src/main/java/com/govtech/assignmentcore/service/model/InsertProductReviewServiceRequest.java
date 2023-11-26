package com.govtech.assignmentcore.service.model;

public class InsertProductReviewServiceRequest {

  private String comment;

  private long productId;

  private double rating;

  public InsertProductReviewServiceRequest(String comment, long productId, double rating) {
    this.comment = comment;
    this.productId = productId;
    this.rating = rating;
  }

  public String getComment() {
    return comment;
  }

  public void setComment(String comment) {
    this.comment = comment;
  }

  public long getProductId() {
    return productId;
  }

  public void setProductId(long productId) {
    this.productId = productId;
  }

  public double getRating() {
    return rating;
  }

  public void setRating(double rating) {
    this.rating = rating;
  }
}
