package com.ebees.util;

import java.text.DecimalFormat;

import com.ibm.icu.math.BigDecimal;

public class DoubleToBigD {

    public static void main(String[] args) {
        
        String creditCardNumber = "XXXX-XXXX-XXXX-561";
        System.out.println(creditCardNumber.substring(10));
        
        
       Double doubleVal = 0.64;
       BigDecimal bigDVal = new BigDecimal(doubleVal);
       System.out.println(bigDVal);
       
       System.out.println(convertToCurrencyFormat(bigDVal));
    }
    
    
    private static String convertToCurrencyFormat(BigDecimal value) {
        if (value != null) {
            DecimalFormat df = new DecimalFormat("$###,##0.00");
            return df.format(value.doubleValue());
        } else {
            return "--";
        }
    }

}
