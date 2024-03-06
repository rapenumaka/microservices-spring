package com.mdk.card.service;

import com.mdk.card.dto.CardDto;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;

@Service
public interface CardService {



    public CardDto findbyPhoneNumber(String phoneNumber);

    public CardDto findbyCardNumber(String cardNumber);

    public List<CardDto> getAllCards();

    public CardDto createCard(String phoneNumber, BigDecimal cardAmount);

    public CardDto updateCard(String phoneNumber, BigDecimal payment);

    public boolean deleteCard(String phoneNumber);


}
