package com.govtech.assignmentcore.service.impl;

import org.junit.jupiter.api.Test;

class TimeServiceImplTest {

  private final TimeServiceImpl timeService = new TimeServiceImpl();

  @Test
  void now() {
    timeService.now();
  }
}