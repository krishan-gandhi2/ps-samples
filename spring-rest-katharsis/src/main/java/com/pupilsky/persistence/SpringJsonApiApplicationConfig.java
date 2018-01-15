package com.pupilsky.persistence;

import javax.annotation.PostConstruct;

import com.pupilsky.persistence.domain.model.User;
import com.pupilsky.persistence.domain.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;



@Configuration
public class SpringJsonApiApplicationConfig {

  @Autowired
  UserRepository userRepository;

  @PostConstruct
  public void init() {
    User user1 = new User(1L, "John","john@test.com");
    userRepository.save(user1);
    User user2 = new User(2L, "John2","john2@test.com");
    userRepository.save(user2);
  }
}
