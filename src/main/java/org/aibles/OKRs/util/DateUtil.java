package org.aibles.OKRs.util;

import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.time.format.DateTimeFormatter;

public class DateUtil {
  private static final int DECIMAL_LIMIT = 10;
  private static final String ZERO_VALUE = "0";

  private static final String TWELVE_AM = "00:00:00";

  private static final String DATE_FORMAT = "yyyyMMdd HH:mm:ss";

  private static final DateTimeFormatter FORMATTER = DateTimeFormatter.ofPattern(DATE_FORMAT);

  public static Integer convertLocalDateTimeToInteger(LocalDateTime localDateTime) {
    String year = Integer.toString(localDateTime.getYear());
    String month = Integer.toString(localDateTime.getMonthValue());
    String day = Integer.toString(localDateTime.getDayOfMonth());
    if (localDateTime.getMonthValue() < DECIMAL_LIMIT) {
      month = ZERO_VALUE + month;
    }
    if (localDateTime.getDayOfMonth() < DECIMAL_LIMIT) {
      day = ZERO_VALUE + day;
    }

    return Integer.parseInt(year + month + day);
  }

  public static LocalDateTime convertIntegerToLocalDateTime(Integer integerTime) {
    return LocalDateTime.parse(String.valueOf(integerTime) + ' ' + TWELVE_AM, FORMATTER);
  }

  public static Integer convertEpochToInteger(Long epochTime) {
    return convertLocalDateTimeToInteger(LocalDateTime.ofEpochSecond(epochTime, 0, ZoneOffset.UTC));
  }

  public static Long convertIntegerToEpoch(Integer integerTime) {
    return convertIntegerToLocalDateTime(integerTime).toEpochSecond(ZoneOffset.UTC);
  }
}
