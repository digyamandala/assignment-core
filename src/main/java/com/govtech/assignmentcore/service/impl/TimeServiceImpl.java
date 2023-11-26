package com.govtech.assignmentcore.service.impl;

import com.govtech.assignmentcore.service.TimeService;
import org.springframework.stereotype.Service;

@Service
public class TimeServiceImpl implements TimeService {

  @Override
  public long now() {
    return System.currentTimeMillis();
  }
}
