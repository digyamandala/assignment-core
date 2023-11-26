package com.govtech.assignmentcore.service.model;

public class UpdateProductServiceRequest {

  private String category;

  private String description;

  private long id;

  private String sku;

  private String title;

  public UpdateProductServiceRequest() {
  }

  public UpdateProductServiceRequest(String category, String description, long id, String sku, String title) {
    this.category = category;
    this.description = description;
    this.id = id;
    this.sku = sku;
    this.title = title;
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
}
