package com.payoyo.web_intro.controllers;

import java.util.Arrays;
import java.util.List;

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

    @GetMapping("/list")
    public List<User> listar(){
        User user1 = new User("Jose Luis", "Rodriguez");
        User user2 = new User("Jose ", "Perez");
        User user3 = new User("Luis", "Valenzuela");

        List<User> users = Arrays.asList(user1, user2, user3);
        // users.add(user1);
        // users.add(user2);
        // users.add(user3);

        return users;
    }
    
}
