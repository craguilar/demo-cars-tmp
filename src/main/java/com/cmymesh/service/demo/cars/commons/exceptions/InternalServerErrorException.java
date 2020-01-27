package com.cmymesh.service.demo.cars.commons.exceptions;

/**
 * HTTP Status code : 500. Internal Server error.
 * 
 * @author caruruiz
 *
 */
public class InternalServerErrorException extends RuntimeException {

  /**
   * 
   */
  private static final long serialVersionUID = 1L;

  public InternalServerErrorException(String message) {
    super(message);
  }

}
