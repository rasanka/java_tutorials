package com.ebees.util;

import java.util.List;
import java.util.Locale;

import com.google.common.collect.Lists;
import com.ibm.icu.util.TimeZone;

/**
 * Utility class to get List of Timezone's
 *
 */
public class TimeZoneUtil {

    private static final String NOT_AVAILABLE = "N/A";
    private static final String COUNTRY_CODE_GB = "GB";
    private static final String COUNTRY_CODE_UK = "UK";

    /**
     * Method used to fetch list of time zones by country code
     * Example country codes: NZ, AU, CA, US
     * Special handling for UK it should be GB
     * 
     * @param countryCode
     * @return List of Time zone's City and time zone ID
     */
    
    public static void printIDs() {
        for(String str : TimeZone.getAvailableIDs()) {
            System.out.println(str);
        }
    }
    
    public static List<LocationDto> getTimeZonesByCountryCode(String countryCode) {
        countryCode = isUK(countryCode) ? COUNTRY_CODE_GB : countryCode;

        List<LocationDto> locationsList = Lists.newArrayList();
        for (String tzId : TimeZone.getAvailableIDs(countryCode)) {

            if (!tzId.contains("/") || tzId.startsWith("System") || tzId.startsWith("Etc") || tzId.startsWith("US/") || tzId.startsWith(
                "Canada/")) {
                continue;
            }

            String countryName = getCountryName(tzId);
            String cityWithCountry = formatCityAndCountryName(tzId, countryName);
            locationsList.add(new LocationDto(cityWithCountry, tzId));
        }
        return locationsList;
    }

    /**
     * Extract city name from time zone and concatenate with country name
     * Example - London, United Kingdom
     * @param tzId
     * @param countryName
     * @return city, countryName
     */
    private static String formatCityAndCountryName(String tzId, String countryName) {
        return tzId.substring(tzId.lastIndexOf("/") + 1).replaceAll("_", " ") + ", " + countryName;
    }

    /**
     * Retrieve country name from time zone region
     * @param tzId
     * @return countryName
     */
    private static String getCountryName(String tzId) {
        String countryName = NOT_AVAILABLE;
        for (String isoCountryCode : Locale.getISOCountries()) {
            if (isoCountryCode.equals(TimeZone.getRegion(tzId))) {
                Locale locale = new Locale(Locale.ENGLISH.getISO3Language(), isoCountryCode);
                countryName = locale.getDisplayCountry();
            }
        }
        return countryName;
    }

    /**
     * Method used to retrieve City, Country name from given time zone id
     * 
     * @param timeZoneId
     * @return Location object with city for given time zone id
     */
    public static LocationDto getLocationByTimeZoneId(String timeZoneId) {
        TimeZone tz = TimeZone.getTimeZone(timeZoneId);
        String tzId = tz.getID();
        String countryName = getCountryName(tzId);
        String cityWithCountry = formatCityAndCountryName(tzId, countryName);
        return new LocationDto(cityWithCountry, timeZoneId);
    }

    private static boolean isUK(String country) {
        return country.equals(COUNTRY_CODE_UK);
    }
}
