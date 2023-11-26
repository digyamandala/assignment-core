package com.govtech.assignmentcore.common;

import java.util.List;

public class PagingRequestAccessor {

  private int itemPerPage;

  private int offset;

  private List<SortProperty> sortBy;

  public PagingRequestAccessor() {
  }

  public PagingRequestAccessor(int itemPerPage, int offset, List<SortProperty> sortBy) {
    this.itemPerPage = itemPerPage;
    this.offset = offset;
    this.sortBy = sortBy;
  }

  public int getItemPerPage() {
    return itemPerPage;
  }

  public void setItemPerPage(int itemPerPage) {
    this.itemPerPage = itemPerPage;
  }

  public int getOffset() {
    return offset;
  }

  public void setOffset(int offset) {
    this.offset = offset;
  }

  public List<SortProperty> getSortBy() {
    return sortBy;
  }

  public void setSortBy(List<SortProperty> sortBy) {
    this.sortBy = sortBy;
  }
}
