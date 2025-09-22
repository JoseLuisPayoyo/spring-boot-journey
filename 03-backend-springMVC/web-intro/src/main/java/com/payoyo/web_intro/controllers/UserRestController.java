package com.payoyo.web_intro.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.payoyo.web_intro.models.User;
import com.payoyo.web_intro.models.dto.UserDTO;

@RestController
@RequestMapping("/api")
public class UserRestController {

    // @GetMapping("/details")
    // public Map<String, Object> details() {
    //     User user = new User("Jose Luis", "Rodriguez");
    //     Map<String, Object> body = new HashMap<>();

    //     body.put("tittle", "Hola Spring");
    //     body.put("user", user);

    //     return body;
    // }

    @GetMapping("/details")
    public UserDTO details() {
        UserDTO userDTO = new UserDTO();
        User user = new User("Jose Luis", "Rodriguez");
        userDTO.setUser(user);
        userDTO.setTitle("Hola desde Spring");
        // Map<String, Object> body = new HashMap<>();

        // body.put("tittle", "Hola Spring");
        // body.put("user", user);

        return userDTO;
    }
    
}
