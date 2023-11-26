package com.govtech.assignmentcore.service.model;

import java.util.List;

public class GetProductServiceResponse {

  private double averageRating;

  private String category;

  private long createdDate;

  private String description;

  private long id;

  private List<ProductImageServiceResponse> images;

  private long lastModifiedDate;

  private double price;

  private long reviewCount;

  private String sku;

  private String title;

  private double weight;

  public GetProductServiceResponse() {
  }

  public GetProductServiceResponse(double averageCount, String category, String description, long id,
      List<ProductImageServiceResponse> images, double price, long reviewCount, String sku, String title,
      double weight) {
    this.averageRating = averageCount;
    this.category = category;
    this.description = description;
    this.id = id;
    this.images = images;
    this.price = price;
    this.reviewCount = reviewCount;
    this.sku = sku;
    this.title = title;
    this.weight = weight;
  }

  public double getAverageRating() {
    return averageRating;
  }

  public void setAverageRating(double averageRating) {
    this.averageRating = averageRating;
  }

  public String getCategory() {
    return category;
  }

  public void setCategory(String category) {
    this.category = category;
  }

  public long getCreatedDate() {
    return createdDate;
  }

  public void setCreatedDate(long createdDate) {
    this.createdDate = createdDate;
  }

  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  public long getId() {
    return id;
  }

  public void setId(long id) {
    this.id = id;
  }

  public List<ProductImageServiceResponse> getImages() {
    return images;
  }

  public void setImages(List<ProductImageServiceResponse> images) {
    this.images = images;
  }

  public long getLastModifiedDate() {
    return lastModifiedDate;
  }

  public void setLastModifiedDate(long lastModifiedDate) {
    this.lastModifiedDate = lastModifiedDate;
  }

  public double getPrice() {
    return price;
  }

  public void setPrice(double price) {
    this.price = price;
  }

  public long getReviewCount() {
    return reviewCount;
  }

  public void setReviewCount(long reviewCount) {
    this.reviewCount = reviewCount;
  }

  public String getSku() {
    return sku;
  }

  public void setSku(String sku) {
    this.sku = sku;
  }

  public String getTitle() {
    return title;
  }

  public void setTitle(String title) {
    this.title = title;
  }

  public double getWeight() {
    return weight;
  }

  public void setWeight(double weight) {
    this.weight = weight;
  }
}
