package com.cmymesh.service.demo.cars.commons.exceptions;

/**
 * HTTP Code: 401. Unauthorized.
 * 
 * @author caruruiz
 *
 */
public class UnauthorizedException extends RuntimeException {

  private static final long serialVersionUID = 1L;

  public UnauthorizedException(String message) {
    super(message);
  }
}
