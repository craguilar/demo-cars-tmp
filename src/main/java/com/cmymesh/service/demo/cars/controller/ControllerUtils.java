package com.cmymesh.service.demo.cars.controller;

import org.springframework.util.StringUtils;

import com.cmymesh.service.demo.cars.commons.exceptions.BadRequestException;

public class ControllerUtils {

  private ControllerUtils() {

  }

  public static final Integer DEFAULT_LIMIT_SHORTLIST = 10;

  public static final String DEFAULT_OFFSET_PAGE = "0";

  public static void validateMandatoryParameter(String parameter, String parameterName) {
    if (StringUtils.isEmpty(parameter)) {
      throw new BadRequestException(String.format("Invalid parameter %s", parameterName));
    }
  }

  public static Integer getLimit(Integer limit) {
    if (limit == null) {
      return DEFAULT_LIMIT_SHORTLIST;
    }
    return limit;
  }

  public static String getPage(String page) {
    if (StringUtils.isEmpty(page)) {
      return DEFAULT_OFFSET_PAGE;
    }
    return page;
  }

  public static String getSortOrder(String sortOrder) {
    return sortOrder;
  }

  public static String getSortBy(String sortBy) {
    return sortBy;
  }
}
