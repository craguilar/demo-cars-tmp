package com.cmymesh.service.demo.cars.commons.exceptions;

/**
 * HTTP Status code : 400 .A bad request was made.
 * 
 * @author caruizag
 *
 */
public class BadRequestException extends RuntimeException {

  private static final long serialVersionUID = 1L;

  public BadRequestException(String message) {
    super(message);
  }

}
