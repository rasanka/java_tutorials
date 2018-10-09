package com.ebees.util;

import java.util.*;
 
class ThreeFive {
 
    
    static List<String> doThreeFive(int max) {
        
        List<String> numberList = new ArrayList<String>();
        for(int i =1; i <= max; i++) {
            if(i%3 == 0) {
                numberList.add("three");
            } else if(i%5 == 0) {
                numberList.add("five");
            } else if(i%3 == 0 && i%5 == 0) {
                numberList.add("threefive");
            } else {
                numberList.add(String.valueOf(i));
            }
        }
        return numberList;
    }
    
    public static void main(String args[]) {
        System.out.println(doThreeFive(16));
    }
}