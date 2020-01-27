package com.cmymesh.service.demo.cars.commons.exceptions;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.cmymesh.service.demo.cars.model.pojo.Error;

/**
 * This class is used as an Exception Handling Mechanism for SAPI (CSA Service
 * API Template project) based on common HTTP Exceptions. For more information
 * please visit this
 * <a href= "https://confluence.oraclecorp.com/confluence/x/nAXTPg"> link</a>
 * 
 * @author caruruiz
 *
 */
@ControllerAdvice
public class ApiExceptionHandler {

  private Logger log = LoggerFactory.getLogger(ApiExceptionHandler.class);

  @ExceptionHandler(BadRequestException.class)
  public ResponseEntity<Error> handleException(BadRequestException e) {
    return buildResponseEntity("400", e.getMessage(), HttpStatus.BAD_REQUEST);
  }

  @ExceptionHandler(InternalServerErrorException.class)
  public ResponseEntity<Error> handleException(InternalServerErrorException e) {
    return buildResponseEntity("500", e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
  }

  @ExceptionHandler(NotFoundException.class)
  public ResponseEntity<Error> handleException(NotFoundException e) {
    return buildResponseEntity("404", e.getMessage(), HttpStatus.NOT_FOUND);
  }

  @ExceptionHandler(ResourceConflictException.class)
  public ResponseEntity<Error> handleException(ResourceConflictException e) {
    return buildResponseEntity("409", e.getMessage(), HttpStatus.CONFLICT);
  }

  @ExceptionHandler(UnauthorizedException.class)
  public ResponseEntity<Error> handleException(UnauthorizedException e) {
    return buildResponseEntity("401", e.getMessage(), HttpStatus.UNAUTHORIZED);
  }

  @ExceptionHandler({ Exception.class })
  public ResponseEntity<Error> handleAll(Exception e) {
    log.error("", e);
    return buildResponseEntity("500", e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
  }

  private ResponseEntity<Error> buildResponseEntity(String code, String message, HttpStatus status) {
    Error error = new Error();
    error.setCode(code);
    error.setMessage(message);
    return new ResponseEntity<>(error, status);
  }
}