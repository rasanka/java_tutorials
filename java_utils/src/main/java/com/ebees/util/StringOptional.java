package com.ebees.util;

import java.util.Optional;

public class StringOptional {

    public static void main(String[] args) {
       
        String test = "NOT NULL";
        System.out.println(Optional.ofNullable(test).orElse("NULL TEST"));
    }

}
