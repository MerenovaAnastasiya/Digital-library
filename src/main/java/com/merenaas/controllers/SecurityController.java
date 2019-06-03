package com.merenaas.controllers;

import com.merenaas.forms.SignUpForm;
import com.merenaas.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.util.Collection;
import java.util.Locale;

@Controller
public class SecurityController {

    private final UserService userService;
    private MessageSource messageSource;

    @Autowired
    public SecurityController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping(value = "/success")
    public String successAfterLogin(Authentication authentication) {
        Collection<? extends GrantedAuthority> authorities = authentication.getAuthorities();
        if(authorities.stream().anyMatch(e -> (e.getAuthority().equals("ADMIN")))) {
            return "redirect:/admin";
        }
        return "redirect:/profile";
    }

    @GetMapping(value = "/signIn")
    public String signInPage() {
        return "signIn";
    }

    @GetMapping(value = "/signUp")
    public String signUpPage(Model model) {
        model.addAttribute("signUpForm", new SignUpForm());
        return "signUp";
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

}
