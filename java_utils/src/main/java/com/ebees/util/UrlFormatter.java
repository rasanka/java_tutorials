package com.ebees.util;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.ZoneId;
import java.time.temporal.ChronoUnit;
import java.time.temporal.TemporalAdjusters;
import java.util.Date;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class UrlFormatter {

    public static void main(String args[]) {
        String urlOld = "/v1/balancesummaries?accountId=eyJjb2RlIjoiQyIsImlkIjoiMDAwMDIwOTAwMDUzNzk0NjAwMCJ9&from=2001-01-01&to=2002-01-01&period=monthly";
        
        String urlNew = "/v1/balancesummaries?accountId=eyJjb2RlIjoiQyIsImlkIjoiMDAwMDIwOTAwMDUzNzk0NjAwMCJ9{&from,to,period}";
        
        System.out.println(reconstructBalanceSummaryUrlNew(urlNew));
        
        System.out.println(reconstructBalanceSummaryUrl(urlOld));
    }
    
    private static String reconstructBalanceSummaryUrlNew(String url) {
        SimpleDateFormat SDF = new SimpleDateFormat("yyyy-MM-dd");
        LocalDate now = LocalDate.now();

        Date dateFrom = Date.from(now.minus(24, ChronoUnit.MONTHS).with(TemporalAdjusters.firstDayOfMonth())
                .atStartOfDay().atZone(ZoneId.systemDefault()).toInstant());
        Date toFrom = Date.from(now.minus(1, ChronoUnit.MONTHS).with(TemporalAdjusters.lastDayOfMonth()).atStartOfDay()
                .atZone(ZoneId.systemDefault()).toInstant());
        
        String urlWithoutParameters = url.substring(0,url.indexOf("{&"));
        System.out.println(urlWithoutParameters);
        
        StringBuilder urlBuilder = new StringBuilder(urlWithoutParameters);
        urlBuilder.append("&from=").append(SDF.format(dateFrom));
        urlBuilder.append("&to=").append(SDF.format(toFrom));
        urlBuilder.append("&period=monthly");
        
        return urlBuilder.toString();
    }
    
    private static String reconstructBalanceSummaryUrl(String url) {
        LocalDate now = LocalDate.now();

        Date dateFrom = Date.from(now.minus(24, ChronoUnit.MONTHS).with(TemporalAdjusters.firstDayOfMonth())
                .atStartOfDay().atZone(ZoneId.systemDefault()).toInstant());
        Date toFrom = Date.from(now.minus(1, ChronoUnit.MONTHS).with(TemporalAdjusters.lastDayOfMonth()).atStartOfDay()
                .atZone(ZoneId.systemDefault()).toInstant());

        SimpleDateFormat SDF = new SimpleDateFormat("yyyy-MM-dd");
        Pattern fromPattern = Pattern.compile("from=\\d{4}-\\d{1,}-\\d{1,}");
        Matcher fromMatcher = fromPattern.matcher(url);

        if (fromMatcher.find()) {
            url = url.replace(fromMatcher.group(), String.format("from=%s", SDF.format(dateFrom)));
        }

        Pattern toPattern = Pattern.compile("to=\\d{4}-\\d{1,}-\\d{1,}");
        Matcher toMatcher = toPattern.matcher(url);

        if (toMatcher.find()) {
            url = url.replace(toMatcher.group(), String.format("to=%s", SDF.format(toFrom)));
        }

        return url;
    }
}
