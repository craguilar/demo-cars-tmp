package com.cmymesh.service.demo.cars.controller;

import org.springframework.util.StringUtils;

import com.cmymesh.service.demo.cars.commons.exceptions.BadRequestException;

public class ControllerUtils {

  public static void validateMandatoryParameter(String parameter, String parameterName) {
    if (StringUtils.isEmpty(parameter)) {
      throw new BadRequestException(String.format("Invalid parameter %s", parameterName));
    }
  }
}
