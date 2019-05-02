package com.example.demo.define;

public class Define {

  public static final int initialPage = 0;
  public static final int initialPageSize = 5;

  public static final String TYPE_UNSTABLE = "UNSTABLE";

  public static final String STR_YES = "YES";
  public static final String STR_NO = "NO";

  public static final double DEFAULT_PRICE = 250000.0;
  public static final double DEFAULT_NONE = 0.0;

  public static final String PATTERN_DATE = "yyyy-MM-dd";
  public static Long idCustomer;

  public static java.sql.Date convertUtilToSql(java.util.Date uDate) {
    uDate.setHours(12);
    java.sql.Date sDate = new java.sql.Date(uDate.getTime());
    return sDate;
  }

}
