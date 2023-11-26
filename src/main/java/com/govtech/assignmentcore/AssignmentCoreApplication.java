package com.govtech.assignmentcore;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;

@SpringBootApplication(exclude = SecurityAutoConfiguration.class)
public class AssignmentCoreApplication {

  public static void main(String[] args) {
    SpringApplication.run(AssignmentCoreApplication.class, args);
  }
}
