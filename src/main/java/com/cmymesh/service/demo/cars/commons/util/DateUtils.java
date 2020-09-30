package com.cmymesh.service.demo.cars.commons.util;

import java.time.OffsetDateTime;
import java.time.ZoneOffset;
import java.util.Date;

import lombok.experimental.UtilityClass;

/**
 * @author caruizag
 */
@UtilityClass
public final class DateUtils {

  /**
   * 
   * @param utilDate
   * @return
   */
  public static OffsetDateTime dateToOffsetDateTime(Date utilDate) {
    return utilDate == null ? null : utilDate.toInstant().atOffset(ZoneOffset.UTC);
  }

}
