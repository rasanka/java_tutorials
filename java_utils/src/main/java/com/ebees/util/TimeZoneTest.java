package com.ebees.util;

import java.util.List;

public class TimeZoneTest {

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        
        List<LocationDto> dataList = TimeZoneUtil.getTimeZonesByCountryCode("AU");
        for(LocationDto location : dataList) {
            System.out.println(location.getCity()+" - "+location.getZoneId());
        }
        
        System.out.println("--------------------------------------------------"); 
        
        LocationDto auObj = TimeZoneUtil.getLocationByTimeZoneId("Australia/Melbourne");
        System.out.println(auObj.getCity());
    }

}
