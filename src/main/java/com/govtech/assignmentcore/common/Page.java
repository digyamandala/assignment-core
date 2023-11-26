package com.govtech.assignmentcore.common;

import java.util.List;

public class Page<T> {

  private long itemPerPage;

  private List<T> items;

  private long page;

  private long total;

  private Page() {
  }

  public Page(long itemPerPage, List<T> items, long page, long total) {
    this.itemPerPage = itemPerPage;
    this.items = items;
    this.page = page;
    this.total = total;
  }

  public long getItemPerPage() {
    return itemPerPage;
  }

  public void setItemPerPage(long itemPerPage) {
    this.itemPerPage = itemPerPage;
  }

  public List<T> getItems() {
    return items;
  }

  public void setItems(List<T> items) {
    this.items = items;
  }

  public long getPage() {
    return page;
  }

  public void setPage(long page) {
    this.page = page;
  }

  public long getTotal() {
    return total;
  }

  public void setTotal(long total) {
    this.total = total;
  }
}
