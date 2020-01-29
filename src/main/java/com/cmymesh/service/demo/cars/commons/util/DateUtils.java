package com.cmymesh.service.demo.cars.commons.util;

import java.time.OffsetDateTime;
import java.time.ZoneOffset;
import java.util.Date;

public class DateUtils {

  private DateUtils() {

  }

  public static OffsetDateTime dateToOffsetDateTime(Date utilDate) {
    return utilDate == null ? null : utilDate.toInstant().atOffset(ZoneOffset.UTC);
  }

}
