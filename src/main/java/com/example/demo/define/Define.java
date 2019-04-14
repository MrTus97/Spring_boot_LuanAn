package com.example.demo.define;

import com.example.demo.services.JwtService;
import org.springframework.beans.factory.annotation.Autowired;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class Define {
  public static final long tokenExpireLength = 864000000;

  public static final int initialPage = 0;
  public static final int initialPageSize = 5;

  public static final int monthChangeRemainAbsence = 3;

  public static final String dateChangeRemainAbsence = "-03-31";

  public static final String timeMonthToChangeAddAbsence = "-03-31";
  public static final String timeMonthFromChangeAddAbsence = "-04-01";

  public static final String timeYearToChangeAddAbsence = "-12-31";
  public static final String timeYearFromChangeAddAbsence = "-01-01";

  public static final String emailDefault = "nals_pmo@nal.com";
  public static Long idCustomer;

  public static String dateAfter(String date){
    try {
      Calendar c = Calendar.getInstance();
      Date dDate = new SimpleDateFormat("yyyy-MM-dd").parse(date);
      c.setTime(dDate);
      c.add(Calendar.DATE,1);
      String SDateAfter = String.valueOf(c.get(Calendar.YEAR)) + "-" +
              String.valueOf(c.get(Calendar.MONTH)+ 1) + "-" +
              String.valueOf(c.get(Calendar.DATE));
      return SDateAfter;
    }catch (Exception e){
      e.printStackTrace();
      return null;
    }
  }

  public static java.sql.Date convertUtilToSql(java.util.Date uDate) {
    java.sql.Date sDate = new java.sql.Date(uDate.getTime());
    return sDate;
  }



}
