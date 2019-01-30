package com.ebees.util;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegexTest {
    
    private static final String COMPANY_NAME_WHITELIST_PATTERN = "[^A-Za-z0-9\\.\\'\\#\\!\\@\\p{Sc}\\&\\(\\)\\{\\}\\;\\?\\+\\-\\s\\S]"; 
    private static final Pattern validCompanyNamePattern = Pattern.compile(COMPANY_NAME_WHITELIST_PATTERN);

    public static void main(String[] args) {
        validateInput("Lee\'s Knees", validCompanyNamePattern);        
    }
    
    private  static void validateInput(String value, Pattern pattern) {
        
        Matcher matcher = pattern.matcher(value);

        if (matcher.find()) {
            System.out.println("Invalid character found - "+ value);
        }
        System.out.println("Valid " + value);
    }

}
