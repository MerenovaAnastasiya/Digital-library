package com.merenaas.controllers;

import com.merenaas.forms.CheckoutForm;
import com.merenaas.forms.SignUpForm;
import com.merenaas.models.Order;
import com.merenaas.models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.http.HttpRequest;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import com.merenaas.services.UserService;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import java.lang.reflect.Field;
import java.time.LocalDate;
import java.util.List;
import java.util.Locale;

@Controller
public class UserController {
    private final UserService userService;
    private MessageSource messageSource;

    @Autowired
    public UserController(UserService userService) {

        this.userService = userService;
    }

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


    @PostMapping("/checkOut")
    public String checkOutPost(@Valid @ModelAttribute("checkOutForm")
                                       CheckoutForm checkoutForm
            , @AuthenticationPrincipal User user ){
        userService.checkOut(checkoutForm, user);
        return "redirect:/profile";
    }

    @Autowired
    public void setMessageSource(MessageSource messageSource) {
        this.messageSource = messageSource;
    }

}
