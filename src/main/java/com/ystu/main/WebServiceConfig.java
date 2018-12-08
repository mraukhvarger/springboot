package com.ystu.main;


import com.ystu.entities.User;
import com.ystu.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.event.EventListener;


@Configuration
public class WebServiceConfig {

    @Autowired
    UserRepository userRepository;

    @EventListener(ApplicationReadyEvent.class)
    void fillDatabaseOnStartup() {
        userRepository.save(new User("user", "password"));
        userRepository.save(new User("abcd", "1234"));
    }
}
