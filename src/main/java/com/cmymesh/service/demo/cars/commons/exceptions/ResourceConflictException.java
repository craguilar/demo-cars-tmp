package com.cmymesh.service.demo.cars.commons.exceptions;

public class ResourceConflictException extends RuntimeException {

  private static final long serialVersionUID = 1L;

  public ResourceConflictException(String message) {
    super(message);
  }
}