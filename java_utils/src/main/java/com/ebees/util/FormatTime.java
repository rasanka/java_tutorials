package com.ebees.util;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimeZone;
import java.util.concurrent.TimeUnit;

class FormatTime {
    
    static String formatTime(int millis) {
        if(millis > 3600000) {
            long minutes = TimeUnit.MILLISECONDS.toMinutes(millis);
            Date date = new Date(minutes);
            SimpleDateFormat formatter= new SimpleDateFormat("m:ss");
            formatter.setTimeZone(TimeZone.getTimeZone("UTC"));
            return formatter.format(date );
        } else {
            Date date = new Date(millis);
            SimpleDateFormat formatter= new SimpleDateFormat("m:ss");
            formatter.setTimeZone(TimeZone.getTimeZone("UTC"));
            return formatter.format(date );
        }
    }
    
    // Examples
    public static void main(String[] args) {
        System.out.println("test1: "+("0:00".equals(formatTime(0))?"pass":"fail"));
        System.out.println("test2: "+("0:00".equals(formatTime(999))?"pass":"fail"));
        System.out.println("test3: "+("0:01".equals(formatTime(1000))?"pass":"fail"));
        System.out.println("test4: "+("1:00".equals(formatTime(60000))?"pass":"fail"));
        System.out.println("test5: "+("22:10".equals(formatTime(1330001))?"pass":"fail"));
        System.out.println("test6: "+("61:00".equals(formatTime(3660000))?"pass":"fail"));
        System.out.println("test7: "+("2880:00".equals(formatTime(172800000))?"pass":"fail"));
    }
}