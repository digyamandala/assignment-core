package com.govtech.assignmentcore.service.model;

public class ProductImageServiceRequest {

  private String description;

  private boolean thumbnail;

  private String url;

  public ProductImageServiceRequest(String description, boolean thumbnail, String url) {
    this.description = description;
    this.thumbnail = thumbnail;
    this.url = url;
  }

  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  public String getUrl() {
    return url;
  }

  public void setUrl(String url) {
    this.url = url;
  }

  public boolean isThumbnail() {
    return thumbnail;
  }

  public void setThumbnail(boolean thumbnail) {
    this.thumbnail = thumbnail;
  }
}
