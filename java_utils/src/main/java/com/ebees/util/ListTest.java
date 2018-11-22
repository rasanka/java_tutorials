package com.ebees.util;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class ListTest {
    
    private static void logFilteredList(List<String> filteredList) {
        filteredList.stream().filter(a -> a.contains("rakenapp.com")).collect(Collectors.toList()).forEach(System.out::println);
    }

    public static void main(String args[]) {
        
        List<String> emails = new ArrayList<>();
        emails.add("aa@test.com");
        emails.add("bb@rakenapp.com");
        emails.add("cc@test.com");
        
        logFilteredList(emails);
//        List<String> ccAddresses = Stream.of(emails.split(","))
//                .collect(Collectors.toList());
//        
//        //List<String> filteredList = ccAddresses.stream().filter(a -> !a.contains("rakenapp.com")).collect(Collectors.toList());
//        
//        ccAddresses.stream().filter(a -> !a.contains("rakenapp.com")).collect(Collectors.toList()).forEach(System.out::println);
//        List<String> cities = Arrays.asList("Milan", 
//                                            "London", 
//                                            "New York", 
//                                            "San Francisco");
//        String citiesCommaSeparated = String.join(",", cities);
//        System.out.println(citiesCommaSeparated);
//                
//        
//        for(String email : filteredList) {
//            System.out.println(email);
//        }
    }
}
