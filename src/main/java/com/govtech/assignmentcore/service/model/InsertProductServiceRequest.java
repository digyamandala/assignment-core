package com.govtech.assignmentcore.service.model;

import java.util.List;

public class InsertProductServiceRequest {

  private String category;

  private String description;

  private long id;

  private List<ProductImageServiceRequest> images;

  private double price;

  private String sku;

  private String title;

  private double weight;

  public InsertProductServiceRequest() {
  }

  public InsertProductServiceRequest(String category, String description, long id,
      List<ProductImageServiceRequest> images, double price, String sku, String title, double weight) {
    this.category = category;
    this.description = description;
    this.id = id;
    this.images = images;
    this.price = price;
    this.sku = sku;
    this.title = title;
    this.weight = weight;
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

  public List<ProductImageServiceRequest> getImages() {
    return images;
  }

  public void setImages(List<ProductImageServiceRequest> images) {
    this.images = images;
  }

  public double getPrice() {
    return price;
  }

  public void setPrice(double price) {
    this.price = price;
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
