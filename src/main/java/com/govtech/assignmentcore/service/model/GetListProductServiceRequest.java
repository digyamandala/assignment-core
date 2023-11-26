package com.govtech.assignmentcore.service.model;

import com.govtech.assignmentcore.common.PagingRequest;

public class GetListProductServiceRequest {

  private String category;

  private PagingRequest pagingRequest;

  private String sku;

  private String title;

  public GetListProductServiceRequest(String category, PagingRequest pagingRequest, String sku, String title) {
    this.category = category;
    this.pagingRequest = pagingRequest;
    this.sku = sku;
    this.title = title;
  }

  public GetListProductServiceRequest() {
  }

  public String getCategory() {
    return category;
  }

  public void setCategory(String category) {
    this.category = category;
  }

  public PagingRequest getPagingRequest() {
    return pagingRequest;
  }

  public void setPagingRequest(PagingRequest pagingRequest) {
    this.pagingRequest = pagingRequest;
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
