package com.raja.app.utils;

import com.raja.app.exception.InsufficentAmountException;

import java.util.HashMap;
import java.util.Map;

public class PaymentUtils {

    private static Map<String, Double> paymentMap = new HashMap<>();

    static {
        paymentMap.put("CITI",12000.00);
        paymentMap.put("VISA",6000.00);
        paymentMap.put("MASTER",5000.00);
        paymentMap.put("AMEX",8000.00);
        paymentMap.put("DISCOVER",15000.00);
    }

    public  static boolean validateLimits(String account, double amount){
        if(paymentMap.keySet().contains(account)){
            if(amount >paymentMap.get(account)){
                 throw new InsufficentAmountException("insufficient fund ... ");
            }else{
                return true;
            }
        }else{
            throw new RuntimeException("account not found");
        }

    }
}
