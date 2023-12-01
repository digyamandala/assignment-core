package com.govtech.assignmentcore.common;

import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;

import java.util.Collections;
import java.util.List;

@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
public class PagingRequest {

  private int itemPerPage;

  private int page;

  private List<SortProperty> sortBy;

  public PagingRequest(int itemPerPage, int page, List<SortProperty> sortBy) {
    this.itemPerPage = itemPerPage;
    this.page = page;
    this.sortBy = sortBy;
  }

  public int getItemPerPage() {
    return itemPerPage;
  }

  public void setItemPerPage(int itemPerPage) {
    this.itemPerPage = itemPerPage;
  }

  public int getPage() {
    return page;
  }

  public void setPage(int page) {
    this.page = page;
  }

  public List<SortProperty> getSortBy() {
    return sortBy;
  }

  public void setSortBy(List<SortProperty> sortBy) {
    this.sortBy = sortBy;
  }

  public void setDefaultSortBy() {
    this.sortBy = Collections.singletonList(new SortProperty("created_date", "desc"));
  }
}
