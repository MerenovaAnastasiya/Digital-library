package com.merenaas.controllers;

import com.merenaas.forms.SignUpForm;
import com.merenaas.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.util.Locale;

@Controller
public class SecurityController {

    private final UserService userService;
    private MessageSource messageSource;

    @Autowired
    public SecurityController(UserService userService) {

        this.userService = userService;
    }

//    @GetMapping(value = "/success")
//    public String successAfterLogin(HttpServletRequest request) {
//        System.out.println(request.getUserPrincipal().getName());
//        if(request.getAuthType()) {
//            return "redirect:/admin";
//        }
//        return "redirect:/profile";
//    }

    @PostMapping("/signUp")
    public String signUpPost(@Valid @ModelAttribute("signUpForm")
                                     SignUpForm signUpForm, BindingResult result) {
        if(userService.getUserByEmail(signUpForm.getEmail())!= null) {
            FieldError ssoError = new FieldError("signUpForm", "email", messageSource.getMessage("email.used", null, Locale.getDefault()));
            result.addError(ssoError);
        }
        if(userService.getUserByLogin(signUpForm.getLogin())!= null) {
            FieldError ssoError = new FieldError("signUpForm", "login", messageSource.getMessage("login.used", null, Locale.getDefault()));
            result.addError(ssoError);
        }
        if (result.hasErrors()) {
            return "signUp";
        }

        userService.signUp(signUpForm);
        return "redirect:/profile";
    }

    @Autowired
    public void setMessageSource(MessageSource messageSource) {
        this.messageSource = messageSource;
    }

}
