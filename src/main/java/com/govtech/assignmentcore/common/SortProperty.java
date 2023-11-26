package com.govtech.assignmentcore.common;

public class SortProperty {

  private String field;

  private String order;

  public SortProperty() {
  }

  public SortProperty(String field, String order) {
    this.field = field;
    this.order = order;
  }

  public String getField() {
    return field;
  }

  public void setField(String field) {
    this.field = field;
  }

  public String getOrder() {
    return order;
  }

  public void setOrder(String order) {
    this.order = order;
  }
}
