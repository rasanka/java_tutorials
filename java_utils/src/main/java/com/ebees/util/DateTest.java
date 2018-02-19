package com.ebees.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.Month;
import java.time.Period;
import java.time.ZoneId;
import java.time.temporal.ChronoUnit;
import java.util.Date;

public class DateTest {

    private static final String DATE_TIME_FORMAT = "yyyy-MM-dd HH:mm:ss";
    private static final String US_DATE_TIME_FORMAT = "MM/dd/yyyy HH:mm:ss";
    private static final String DATE_FORMAT = "yyyy-MM-dd";

    public static void main(String args[]) {
        String dateStr = "2018-01-26 21:03:10.0";
        try {
            System.out.println(formatDateTime(dateStr));
            
            //System.out.println(new SimpleDateFormat(DATE_FORMAT).parse(dateStr));
            //System.out.println(calculateNoOfDaysSinceUserRegistered(new SimpleDateFormat(DATE_FORMAT).parse(dateStr)));
            
            System.out.println("GET DAYS - "+getDays(new SimpleDateFormat(DATE_TIME_FORMAT).parse(dateStr)));
        } catch (ParseException e) {
            e.printStackTrace();
        }
        
        
    }

    public static String formatDateTime(String dateStr) throws ParseException {
        Date date = new SimpleDateFormat(DATE_TIME_FORMAT).parse(dateStr);
        System.out.println(date);
        return new SimpleDateFormat(US_DATE_TIME_FORMAT).format(date);
    }

    private static int calculateNoOfDaysSinceUserRegistered(Date userCreatedDate) {
//        return Math.toIntExact(Duration.between(LocalDate.now(), userCreatedDate.toInstant().atZone(ZoneId.systemDefault()).toLocalDate())
//                .toDays());
        System.out.println("DATE - "+userCreatedDate.toInstant().atZone(ZoneId.systemDefault()).toLocalDate());
        Period p = Period.between(LocalDate.now(), LocalDate.of(2017, Month.JUNE, 26));
        return p.getDays();
    }
    
    private static int getDays(Date userCreatedDate) {
        return Math.toIntExact(ChronoUnit.DAYS.between(userCreatedDate.toInstant().atZone(ZoneId.systemDefault()).toLocalDate(), LocalDate.now()));
    }
}
