package com.cmymesh.service.demo.cars.controller;

import org.springframework.util.StringUtils;

import com.cmymesh.service.demo.cars.commons.exceptions.BadRequestException;

public class ControllerUtils {

  public static final Integer DEFAULT_LIMIT_SHORTLIST = 10;

  public static final Integer MAX_LIMIT_SHORTLIST = 100;

  public static final Integer DEFAULT_OFFSET_PAGE = 0;

  public static final String SORT_DIRECTION_ASC = "ASC";

  public static final String SORT_DIRECTION_DESC = "DESC";

  public static final String DEFAULT_SORT_BY = "timeCreated";

  public static final String SORT_BY_PLATE = "plate";

  public static final String SORT_BY_MAKE = "make";

  public static final String SORT_BY_TIMECREATED = "timeCreated";

  private ControllerUtils() {

  }

  public static void validateMandatoryParameter(String parameter, String parameterName) {
    if (StringUtils.isEmpty(parameter)) {
      throw new BadRequestException(String.format("Invalid parameter %s", parameterName));
    }
  }

  public static Integer getLimit(Integer limit) {
    if (limit == null || limit < 0 || limit > MAX_LIMIT_SHORTLIST) {
      return DEFAULT_LIMIT_SHORTLIST;
    }
    return limit;
  }

  public static Integer getPage(String page) {
    if (StringUtils.isEmpty(page) || !page.chars().allMatch(Character::isDigit)) {
      return DEFAULT_OFFSET_PAGE;
    }
    Integer result = Integer.valueOf(page);
    return result;
  }

  public static String getSortOrder(String sortOrder) {
    if (StringUtils.isEmpty(sortOrder)
        || (!sortOrder.equalsIgnoreCase(SORT_DIRECTION_ASC) && !sortOrder.equalsIgnoreCase(SORT_DIRECTION_DESC))) {
      return SORT_DIRECTION_DESC;
    }
    return sortOrder.toUpperCase();
  }

  /**
   * Valid
   * 
   * @param sortBy
   *          plate, make, timeCreated
   * @return
   */
  public static String getSortBy(String sortBy) {
    if (StringUtils.isEmpty(sortBy) || (!sortBy.equalsIgnoreCase(SORT_BY_PLATE)
        && !sortBy.equalsIgnoreCase(SORT_BY_MAKE) && !sortBy.equalsIgnoreCase(SORT_BY_TIMECREATED))) {
      return DEFAULT_SORT_BY;
    }
    return getPojoToEntitySortByMapping(sortBy.toUpperCase());
  }

  private static String getPojoToEntitySortByMapping(String pojoAttribute) {
    if (pojoAttribute.equalsIgnoreCase(SORT_BY_PLATE)) {
      return "id";
    }
    return pojoAttribute;
  }
}
