package com.mdk.card.cmdrunner;

import com.mdk.card.entity.Card;
import com.mdk.card.repository.CardRepository;
import com.mdk.card.service.CardService;
import lombok.AllArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.util.Random;

@Component
@AllArgsConstructor
public class CommandRunner implements CommandLineRunner {

    private CardService cardService;


    @Override
    public void run(String... args) throws Exception {

        cardService.createCard("5551234567", BigDecimal.valueOf(1524.25));
        cardService.createCard("5559876543", BigDecimal.valueOf(8585.25));
        cardService.createCard("5555678901", BigDecimal.valueOf(292.25));
        cardService.createCard("5552345678", BigDecimal.valueOf(2522.23));
        cardService.createCard("5558765432", BigDecimal.valueOf(8955.20));
        cardService.createCard("5551231235", BigDecimal.valueOf(895.25));
        cardService.createCard("5552447059", BigDecimal.valueOf(782.52));
        cardService.createCard("5552847059", BigDecimal.valueOf(3851.82));

    }
}
