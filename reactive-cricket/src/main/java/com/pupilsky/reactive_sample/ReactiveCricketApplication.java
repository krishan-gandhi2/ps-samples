package com.pupilsky.reactive_sample;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.pupilsky.reactive_sample.model.Player;
import com.pupilsky.reactive_sample.service.PlayerRecordsService;

import reactor.core.publisher.Flux;

@SpringBootApplication
public class ReactiveCricketApplication {

	public static void main(String[] args) {
		SpringApplication.run(ReactiveCricketApplication.class, args);
	}

    @RestController
    @RequestMapping("/player/records")
    class PlayerRecordsController {

        @Autowired
        PlayerRecordsService playerRecordsService;

        @GetMapping(produces = MediaType.APPLICATION_STREAM_JSON_VALUE)
        public Flux<Player> PlayerRecordsEvents(){
            return playerRecordsService.getPlayerRecordss();
        }
    }

    

}
