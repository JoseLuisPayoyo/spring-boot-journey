package com.payoyo.web_intro.controllers;

import java.util.HashMap;
import java.util.Map;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.payoyo.web_intro.models.User;

@RestController
@RequestMapping("/api")
public class UserRestController {

    @GetMapping("/details")
    public Map<String, Object> details() {
        User user = new User("Jose Luis", "Rodriguez");
        Map<String, Object> body = new HashMap<>();

        body.put("tittle", "Hola Spring");
        body.put("user", user);

        return body;
    }
    
}
