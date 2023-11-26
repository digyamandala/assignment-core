package com.govtech.assignmentcore.common;

public enum StoredFunctionName {
  GET_PRODUCT_BY_ID("get_product_by_id"),
  GET_PRODUCT_BY_SKU("get_product_by_sku"),
  COUNT_PRODUCT_BY_FILTER("count_product_by_filter"),
  GET_PRODUCT_BY_FILTER("get_product_by_filter"),
  INSERT_PRODUCT("insert_product"),
  UPDATE_PRODUCT("update_product");

  private final String functionName;

  StoredFunctionName(String functionName) {
    this.functionName = functionName;
  }

  public String getFunctionName() {
    return functionName;
  }
}
