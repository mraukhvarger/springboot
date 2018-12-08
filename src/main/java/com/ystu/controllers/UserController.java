package com.ystu.controllers;

import com.ystu.entities.User;
import com.ystu.main.Main;
import com.ystu.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Collections;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/user")
public class UserController {

    @Autowired
    UserRepository userRepository;

    @GetMapping(value = "/auth/{login}/{password}")
    @ResponseBody
    public Map login(@PathVariable String login,
                     @PathVariable String password) {
        userRepository.save(new User(login, password));

        return Collections.singletonMap("Result", "OK");
    }

    @GetMapping(value = "/all")
    @ResponseBody
    public List all() {
        return userRepository.findAll();
    }

    @GetMapping(value = "/findByLogin/{login}")
    @ResponseBody
    public List findByLogin(@PathVariable String login) {
        return userRepository.findAllByLoginLike("%" + login + "%");
    }
}
