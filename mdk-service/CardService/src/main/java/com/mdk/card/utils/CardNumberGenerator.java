package com.mdk.card.utils;

import java.util.Random;

public class CardNumberGenerator {


   public static String generate(){
       long min = 1000000000000000L; //15 digits inclusive
       long max = 10000000000000000L; //16 digits exclusive
       Random random = new Random();
       long number = min+((long)(random.nextDouble()*(max-min)));

       String value = String.valueOf(number);

       value = String.format("%s-%s-%s-%s", value.substring(0,4),value.substring(4,8),value.substring(8,12),value.substring(12,16));

       return value;
   }
}
