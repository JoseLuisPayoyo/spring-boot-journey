package com.payoyo.web_intro.models.dto;

import com.payoyo.web_intro.models.User;

public class UserDTO {

    private String title;
    private User user;

    public UserDTO() {}
    public UserDTO(String title, User user) {
        this.title = title;
        this.user = user;
    }
    public String getTitle() {
        return title;
    }
    public void setTitle(String title) {
        this.title = title;
    }
    public User getUser() {
        return user;
    }
    public void setUser(User user) {
        this.user = user;
    }
    
    
}
