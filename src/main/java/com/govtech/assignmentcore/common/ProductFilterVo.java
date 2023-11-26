package com.govtech.assignmentcore.common;

public class ProductFilterVo {

  private String category;

  private PagingRequestAccessor pagingRequest;

  private String sku;

  private String title;

  public ProductFilterVo(String category, PagingRequestAccessor pagingRequest, String sku, String title) {
    this.category = category;
    this.pagingRequest = pagingRequest;
    this.sku = sku;
    this.title = title;
  }

  public String getCategory() {
    return category;
  }

  public void setCategory(String category) {
    this.category = category;
  }

  public PagingRequestAccessor getPagingRequest() {
    return pagingRequest;
  }

  public void setPagingRequest(PagingRequestAccessor pagingRequest) {
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
