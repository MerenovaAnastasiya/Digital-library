package com.merenaas.controllers;

import com.merenaas.forms.SignUpForm;
import com.merenaas.forms.TransferForm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import java.util.Date;
import java.util.List;
import java.util.Locale;

@Controller
public class BankController {

    private PasswordEncoder passwordEncoder;
    private MessageSource messageSource;
    private String hash;

    @GetMapping(value = "/transfer")
    public String transfer(HttpSession session, @ModelAttribute("transferForm") TransferForm transferForm, BindingResult result)
    {
        if(session.getAttribute("csrfToken") == null) {
            Date date = new Date();
            hash = passwordEncoder.encode(date.toString());
            session.setAttribute("csrfToken", hash);
            System.out.println("создали " + transferForm.getCsrfToken().toString());
            System.out.println(transferForm.toString());
        }
        return "transfer";
    }

    @PostMapping(value = "/transfer")
    public String transferpost(HttpSession session, @Valid @ModelAttribute("transferForm") TransferForm transferForm, BindingResult result) {
        System.out.println(transferForm.getAmount());
      if(!session.getAttribute("csrfToken").equals(transferForm.getCsrfToken())) {
          FieldError ssoError = new FieldError("transferForm", "amount", messageSource.getMessage("сsrf", null,Locale.getDefault()));
          result.addError(ssoError);
      }
      return "transfer";
    }
    @Autowired
    public void setMessageSource(MessageSource messageSource) {
        this.messageSource = messageSource;
    }

    @Autowired

    public void setPasswordEncoder(PasswordEncoder passwordEncoder) {
        this.passwordEncoder = passwordEncoder;
    }
}
