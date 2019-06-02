package com.merenaas.controllers;

import com.merenaas.forms.CheckoutForm;
import com.merenaas.forms.SignUpForm;
import com.merenaas.forms.UpdateProfileForm;
import com.merenaas.models.Order;
import com.merenaas.models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.http.HttpRequest;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import com.merenaas.services.UserService;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;
import java.util.Locale;

@Controller
public class UserController {
    private final UserService userService;
    private MessageSource messageSource;

    @Autowired
    public UserController(UserService userService) {

        this.userService = userService;
    }

    @PostMapping("/checkOut")
    public String checkOutPost(@Valid @ModelAttribute("checkOutForm")
                                       CheckoutForm checkoutForm
            , @AuthenticationPrincipal User user ){
        userService.checkOut(checkoutForm, user);
        return "redirect:/profile";
    }

    @PostMapping("/updateProfile")
    public String updateProfilePost(@Valid @ModelAttribute("updateProfileForm")
                                    UpdateProfileForm updateProfileForm,
                                    BindingResult result,
                                    @AuthenticationPrincipal User user,
                                    RedirectAttributes attr){
        if(userService.getUserByEmail(updateProfileForm.getEmail())!= null) {
            FieldError ssoError = new FieldError("updateProfileForm", "email",
                    messageSource.getMessage("email.used", null, Locale.getDefault()));
            result.addError(ssoError);
        }
        if(userService.getUserByLogin(updateProfileForm.getLogin())!= null) {
            FieldError ssoError = new FieldError("updateProfileForm", "login",
                    messageSource.getMessage("login.used", null, Locale.getDefault()));
            result.addError(ssoError);
        }
        if(userService.getUserByPhoneNumber(updateProfileForm.getPhoneNumber())!= null) {
            FieldError ssoError = new FieldError("updateProfileForm", "phoneNumber",
                    messageSource.getMessage("phone.used", null, Locale.getDefault()));
            result.addError(ssoError);
        }
        if (result.hasErrors()) {
            //TODO debug
            attr.addFlashAttribute(result);
            attr.addFlashAttribute(updateProfileForm);
            return "redirect:/profile";
        }
        userService.updateInformation(updateProfileForm, user);
        return "redirect:/profile";
    }

    @Autowired
    public void setMessageSource(MessageSource messageSource) {
        this.messageSource = messageSource;
    }

}
