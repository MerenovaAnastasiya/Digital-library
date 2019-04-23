package com.merenaas.controllers;

import com.merenaas.forms.SignUpForm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import com.merenaas.services.UserService;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;
import java.util.List;

@Controller
public class UserController {
    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/signUp")
    public String signUpPost(@Valid @ModelAttribute("signUpForm")
                                     SignUpForm signUpForm, BindingResult result) {
        if(result.hasErrors()) {
            return "signUp";
        }

        userService.signUp(signUpForm);
        return "redirect:/profile";
    }
}
