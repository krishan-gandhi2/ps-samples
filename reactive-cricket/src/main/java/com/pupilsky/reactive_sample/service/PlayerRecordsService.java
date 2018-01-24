package com.pupilsky.reactive_sample.service;

import java.time.Duration;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.stream.Stream;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;

import com.pupilsky.reactive_sample.model.Player;

import reactor.core.publisher.Flux;
import reactor.util.function.Tuple2;

@Service
public class PlayerRecordsService {
    
    List<Player> playerList = new ArrayList<>();
    List<String> countryList = Arrays.asList("India,Australia,England,SriLanka".split(","));
    List<String> playerNames = Arrays.asList("Virat,Smith,Kallis,Sachin,Rohit,Steve,Dhoni".split(","));

    @Bean
    CommandLineRunner commandLineRunner() {
        return args -> {
            createRandomPlayer();
        };
    }
    
    public Flux<Player> getPlayerRecordss() {
        Flux<Long> interval = Flux.interval(Duration.ofSeconds(1));
        Flux<Player> playerRecordsFlux = Flux.fromStream(Stream.generate(() -> new Player(getRandomName(), generateRandomCountry())));
        return Flux.zip(interval, playerRecordsFlux)
            .map(Tuple2::getT2);
    }
    
    Integer getRandomRuns() {
        Integer min = 30;
        Integer max = 50;
        return  new Random().nextInt() * (max - min);
    }

    Player getRandomPlayer() {
        return playerList.get(new Random().nextInt(playerList.size()));
    }
    
    void createRandomPlayer() {
        playerNames.forEach(player -> {
            playerList.add(new Player(player, generateRandomCountry()));
        });
    }

    String getRandomName() {
        return playerNames.get(new Random().nextInt(playerNames.size()));
    }
    
    String generateRandomCountry() {
        return countryList.get(new Random().nextInt(countryList.size()));
    }

    String changeCountry() {
        return countryList.get(new Random().nextInt(countryList.size()));
    }

    float roundFloat(float number) {
        return Math.round(number * 100.0) / 100.0f;
    }
}
