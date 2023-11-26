package com.govtech.assignmentcore.web.model;

public class FilterProductWebRequest {

  private String category;

  private String sku;

  private String title;

  public FilterProductWebRequest() {
  }

  public FilterProductWebRequest(String category, String sku, String title) {
    this.category = category;
    this.sku = sku;
    this.title = title;
  }

  public String getCategory() {
    return category;
  }

  public void setCategory(String category) {
    this.category = category;
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
