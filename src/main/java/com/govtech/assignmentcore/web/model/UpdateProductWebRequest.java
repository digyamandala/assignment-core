package com.govtech.assignmentcore.web.model;

public class UpdateProductWebRequest {

  private String category;

  private String description;

  private String sku;

  private String title;

  public UpdateProductWebRequest(String category, String description, String sku, String title) {
    this.category = category;
    this.description = description;
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
