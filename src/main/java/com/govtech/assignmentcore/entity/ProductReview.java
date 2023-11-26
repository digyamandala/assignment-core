package com.govtech.assignmentcore.entity;

public class ProductReview extends BaseEntity {

  private String comment;

  private long id;

  private long productId;

  private double rating;

  public ProductReview(String comment, long id, long productId, double rating) {
    this.comment = comment;
    this.id = id;
    this.productId = productId;
    this.rating = rating;
  }

  public ProductReview() {
  }

  public String getComment() {
    return comment;
  }

  public void setComment(String comment) {
    this.comment = comment;
  }

  public long getId() {
    return id;
  }

  public void setId(long id) {
    this.id = id;
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
