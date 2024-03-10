package com.mdk.card.service.impl;

import com.mdk.card.dto.CardDto;
import com.mdk.card.entity.Card;
import com.mdk.card.exception.CardNotFoundException;
import com.mdk.card.exception.CardWithPhoneNumberAlreadyExistsException;
import com.mdk.card.exception.PhoneNumberNotFoundException;
import com.mdk.card.mapper.CardMapper;
import com.mdk.card.repository.CardRepository;
import com.mdk.card.service.CardService;
import com.mdk.card.utils.CardNumberGenerator;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class CardServiceImpl implements CardService {


    private CardRepository cardRepository;


    @Override
    public CardDto findbyPhoneNumber(String phoneNumber) {
        Optional<Card> byPhoneNumber = this.cardRepository.findByPhoneNumber(phoneNumber);

        if(byPhoneNumber.isPresent()){
            return CardMapper.maptoCardDto(byPhoneNumber.get());
        }else{
            throw new PhoneNumberNotFoundException(phoneNumber);
        }
    }

    @Override
    public CardDto findbyCardNumber(String cardNumber) {
        Optional<Card> byCardNumber = this.cardRepository.findByCardNumber(cardNumber);

        if(byCardNumber.isPresent()){
            return CardMapper.maptoCardDto(byCardNumber.get());
        }else{
            throw new CardNotFoundException(cardNumber);
        }
    }

    @Override
    public List<CardDto> getAllCards() {
       return this.cardRepository.findAll().
               stream().
               map(CardMapper::maptoCardDto).
               collect(Collectors.toList());

    }

    @Override
    public CardDto createCard(String phoneNumber, BigDecimal cardAmount) {

        if(this.cardRepository.findByPhoneNumber(phoneNumber).isPresent()){
            throw new CardWithPhoneNumberAlreadyExistsException(phoneNumber);
        };


        CardDto cardDto = new CardDto();
        cardDto.setPhoneNumber(phoneNumber);
        cardDto.setCardNo(CardNumberGenerator.generate());
        cardDto.setCardLimit(cardAmount);
        cardDto.setCardBalance(BigDecimal.ZERO);

        this.cardRepository.save(CardMapper.mapToCard(cardDto));

        return cardDto;
    }

    @Override
    public CardDto updateCard(String phoneNumber, BigDecimal payment) {
        if(this.cardRepository.findByPhoneNumber(phoneNumber).isPresent()){
            throw new PhoneNumberNotFoundException(phoneNumber);
        };

        CardDto cardDto = new CardDto();
        cardDto.setPhoneNumber(phoneNumber);
        cardDto.setCardBalance(cardDto.getCardLimit().subtract(payment));
        cardDto.setCardBalance(BigDecimal.ZERO);
        Card save = this.cardRepository.save(CardMapper.mapToCard(cardDto));

        return CardMapper.maptoCardDto(save);
    }

    @Override
    public boolean deleteCard(String phoneNumber) {
        if(this.cardRepository.findByPhoneNumber(phoneNumber).isPresent()){
            throw new PhoneNumberNotFoundException(phoneNumber);
        };

        this.cardRepository.delete(this.cardRepository.findByPhoneNumber(phoneNumber).get());
        return true;
    }
}
