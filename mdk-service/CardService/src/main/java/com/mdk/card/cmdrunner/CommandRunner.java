package com.mdk.card.cmdrunner;

import com.mdk.card.entity.Card;
import com.mdk.card.repository.CardRepository;
import lombok.AllArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.Random;

@Component
@AllArgsConstructor
public class CommandRunner implements CommandLineRunner {

    private CardRepository cardRepository;


    @Override
    public void run(String... args) throws Exception {



    }
}
