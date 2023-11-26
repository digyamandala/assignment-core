package com.govtech.assignmentcore.entity;

import java.util.List;

public class Product extends BaseEntity {

  private double averageRating;

  private String category;

  private String description;

  private long id;

  private List<ProductImage> images;

  private double price;

  private long reviewCount;

  private String sku;

  private String title;

  private double weight;

  public Product(double averageRating, String category, String description, long id, List<ProductImage> images,
      double price, long reviewCount, String sku, String title, double weight) {
    this.averageRating = averageRating;
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

  public Product() {
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

  public List<ProductImage> getImages() {
    return images;
  }

  public void setImages(List<ProductImage> images) {
    this.images = images;
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
