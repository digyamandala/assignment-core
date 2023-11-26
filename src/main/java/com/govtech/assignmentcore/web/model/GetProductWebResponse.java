package com.govtech.assignmentcore.web.model;

import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;

import java.util.List;

public class GetProductWebResponse {

  private double averageRating;

  private String category;

  private long createdDate;

  private String description;

  private long id;

  private List<ProductImageWebResponse> images;

  private long lastModifiedDate;

  private double price;

  private long reviewCount;

  private String sku;

  private double weight;

  public GetProductWebResponse() {
  }

  public GetProductWebResponse(double averageRating, String category, String description, long id,
      List<ProductImageWebResponse> images, double price, long reviewCount, String sku, double weight) {
    this.averageRating = averageRating;
    this.category = category;
    this.description = description;
    this.id = id;
    this.images = images;
    this.price = price;
    this.reviewCount = reviewCount;
    this.sku = sku;
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

  public List<ProductImageWebResponse> getImages() {
    return images;
  }

  public void setImages(List<ProductImageWebResponse> images) {
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

  public double getWeight() {
    return weight;
  }

  public void setWeight(double weight) {
    this.weight = weight;
  }
}
