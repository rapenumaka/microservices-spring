package com.mdk.card.utils;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;


class CardNumberGeneratorTest {

    @Test
    public void test_generate(){
        String card = CardNumberGenerator.generate();
        System.out.println(card);
    }

}