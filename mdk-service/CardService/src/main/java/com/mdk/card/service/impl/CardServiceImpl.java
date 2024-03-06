package com.mdk.card.service.impl;

import com.mdk.card.dto.CardDto;
import com.mdk.card.entity.Card;
import com.mdk.card.exception.CardNotFoundException;
import com.mdk.card.mapper.CardMapper;
import com.mdk.card.repository.CardRepository;
import com.mdk.card.service.CardService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class CardServiceImpl implements CardService {


    private CardRepository cardRepository;


    @Override
    public CardDto findbyPhoneNumber(String phoneNumber) {
        return null;
    }

    @Override
    public CardDto findbyCardNumber(String cardNumber) {
        return null;
    }

    @Override
    public List<CardDto> getAllCards() {
        return null;
    }

    @Override
    public CardDto createCard(String phoneNumber, BigDecimal cardAmount) {
        return null;
    }

    @Override
    public CardDto updateCard(String phoneNumber, BigDecimal payment) {
        return null;
    }

    @Override
    public boolean deleteCard(String phoneNumber) {
        return false;
    }
}
