package com.ebees.util;

public class StringFormatTest {

    public static void main(String[] args) {
        String str = "Test String %s formatter %s";
        System.out.println(String.format(str, "TEST1", "TEST2"));
    }

}
