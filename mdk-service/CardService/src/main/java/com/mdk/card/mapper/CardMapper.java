package com.mdk.card.mapper;

import com.mdk.card.dto.CardDto;
import com.mdk.card.entity.Card;

public class CardMapper {


    public static Card mapToCard(CardDto cardDto){
        Card card = new Card();
        card.setCardBalance(cardDto.getCardBalance());
        card.setLimit(cardDto.getCardLimit());
        card.setPhoneNumber(cardDto.getPhoneNumber());
        card.setCardNumber(cardDto.getCardNo());
        return card;
    }

    public static CardDto maptoCardDto(Card card){
        CardDto cardDto = new CardDto();
        cardDto.setCardBalance(card.getCardBalance());
        cardDto.setCardLimit(card.getLimit());
        cardDto.setCardNo(card.getCardNumber());
        cardDto.setPhoneNumber(card.getPhoneNumber());
        return cardDto;
    }
}
