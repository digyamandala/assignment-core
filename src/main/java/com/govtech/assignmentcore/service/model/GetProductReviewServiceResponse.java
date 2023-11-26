package com.govtech.assignmentcore.service.model;

public class GetProductReviewServiceResponse {

  private String comment;

  private long createdDate;

  private long id;

  private long lastModifiedDate;

  private long productId;

  private double rating;

  public GetProductReviewServiceResponse(String comment, long createdDate, long id, long lastModifiedDate,
      long productId, double rating) {
    this.comment = comment;
    this.createdDate = createdDate;
    this.id = id;
    this.lastModifiedDate = lastModifiedDate;
    this.productId = productId;
    this.rating = rating;
  }

  public String getComment() {
    return comment;
  }

  public void setComment(String comment) {
    this.comment = comment;
  }

  public long getCreatedDate() {
    return createdDate;
  }

  public void setCreatedDate(long createdDate) {
    this.createdDate = createdDate;
  }

  public long getId() {
    return id;
  }

  public void setId(long id) {
    this.id = id;
  }

  public long getLastModifiedDate() {
    return lastModifiedDate;
  }

  public void setLastModifiedDate(long lastModifiedDate) {
    this.lastModifiedDate = lastModifiedDate;
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
