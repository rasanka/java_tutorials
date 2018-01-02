package com.ebees.util;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

import dk.nykredit.jackson.dataformat.hal.annotation.Resource;

@Resource
@JsonInclude(Include.NON_NULL)
public class LocationDto {

    private String city;
    private String zoneId;
    private String businessStartTime;
    
    public LocationDto(String city, String zoneId) {
        super();
        this.city = city;
        this.zoneId = zoneId;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getZoneId() {
        return zoneId;
    }

    public void setZoneId(String zoneId) {
        this.zoneId = zoneId;
    }

    public String getBusinessStartTime() {
        return businessStartTime;
    }

    public void setBusinessStartTime(String businessStartTime) {
        this.businessStartTime = businessStartTime;
    }

}
