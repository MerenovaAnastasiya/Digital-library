package com.merenaas.controllers;

import org.springframework.stereotype.Controller;
import com.merenaas.services.UserService;

@Controller
public class UserController {
    private final UserService userService;

    public UserController(UserService userService) {

        this.userService = userService;
    }

}
