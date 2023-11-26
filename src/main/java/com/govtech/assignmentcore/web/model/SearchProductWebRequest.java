package com.govtech.assignmentcore.web.model;

import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import com.govtech.assignmentcore.common.PagingRequest;

@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
public class SearchProductWebRequest {

  private FilterProductWebRequest filter;

  private PagingRequest pagingRequest;

  public SearchProductWebRequest(FilterProductWebRequest filter, PagingRequest pagingRequest) {
    this.filter = filter;
    this.pagingRequest = pagingRequest;
  }

  public FilterProductWebRequest getFilter() {
    return filter;
  }

  public void setFilter(FilterProductWebRequest filter) {
    this.filter = filter;
  }

  public PagingRequest getPagingRequest() {
    return pagingRequest;
  }

  public void setPagingRequest(PagingRequest pagingRequest) {
    this.pagingRequest = pagingRequest;
  }
}
