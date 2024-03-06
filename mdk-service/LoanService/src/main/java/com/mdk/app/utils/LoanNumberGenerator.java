package com.mdk.app.utils;

import java.util.Random;

public class LoanNumberGenerator {

    public static String  generate(){
        long max = 1000000000l;
        long min = 100000000l;
        Random random = new Random();

        long number = min+((long)(random.nextDouble()*(max-min)));

        return String.valueOf(number);

    }
}
