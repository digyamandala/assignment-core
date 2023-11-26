package com.govtech.assignmentcore.web.exception;

import org.springframework.dao.DuplicateKeyException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.validation.ValidationException;
import java.util.Collections;
import java.util.Map;

@RestControllerAdvice
public class ControllerAdvice {

  @ResponseStatus(code = HttpStatus.NOT_FOUND)
  @ExceptionHandler({DuplicateKeyException.class})
  public ResponseEntity<Map<String, Object>> duplicate(RuntimeException e) {
    return new ResponseEntity<>(Collections.singletonMap("message", e.getMessage()), HttpStatus.BAD_REQUEST);
  }

  @ResponseStatus(code = HttpStatus.NOT_FOUND)
  @ExceptionHandler({EmptyResultDataAccessException.class})
  public ResponseEntity<Map<String, Object>> notFound(RuntimeException e) {
    return new ResponseEntity<>(Collections.singletonMap("message", "No Data Found!"), HttpStatus.NOT_FOUND);
  }
}
