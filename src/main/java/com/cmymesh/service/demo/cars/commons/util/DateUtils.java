package com.cmymesh.service.demo.cars.commons.util;

import java.time.OffsetDateTime;
import java.time.ZoneOffset;
import java.util.Date;

import lombok.experimental.UtilityClass;

@UtilityClass
public final class DateUtils {

  /**
   * Helper function that helps transform Dates into its OffsetDateTime.
   *
   * @param utilDate to Convert
   * @return a representation of utilDate as {@link OffsetDateTime}
   */
  public static OffsetDateTime dateToOffsetDateTime(Date utilDate) {
    return utilDate == null ? null : utilDate.toInstant().atOffset(ZoneOffset.UTC);
  }

}
