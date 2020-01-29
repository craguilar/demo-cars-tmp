package com.cmymesh.service.demo.cars.commons.exceptions;

/**
 * HTTP Code: 404. Not found.
 * 
 * @author caruruiz
 *
 */
public class NotFoundException extends RuntimeException {

  private static final long serialVersionUID = 1L;

  public NotFoundException() {
    super();
  }

  public NotFoundException(String message) {
    super(message);
  }

}
