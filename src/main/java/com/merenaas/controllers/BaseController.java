package com.merenaas.controllers;


import com.merenaas.forms.CheckoutForm;
import com.merenaas.forms.SignUpForm;
import com.merenaas.forms.UpdateProfileForm;
import com.merenaas.models.Basket;
import com.merenaas.models.Book;
import com.merenaas.models.Order;
import com.merenaas.models.User;
import lombok.NoArgsConstructor;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Set;


@Controller
@NoArgsConstructor
public class BaseController {


    @GetMapping(value = "/signIn")
    public String signInPage() {
        return "signIn";
    }

    @GetMapping(value = "/signUp")
    public String signUpPage(Model model) {
        model.addAttribute("signUpForm", new SignUpForm());
        return "signUp";
    }

    @GetMapping(value = "/profile")
    public String profilePage(Model model, @AuthenticationPrincipal User user, HttpServletRequest request) {
        request.getSession().setAttribute("user", user);
        model.addAttribute("user", user);
        List<Order> orders = user.getOrders();
        model.addAttribute("orders", orders);
        model.addAttribute("updateProfileForm", new UpdateProfileForm());
        return "user/profile";
    }


    @GetMapping(value = "/order")
    public String orderPage(Model model, @AuthenticationPrincipal User user) {
        Basket basket = user.getBasket();
        Set<Book> bookSet = basket.getBooks();
        model.addAttribute("books", bookSet);
        model.addAttribute("checkoutForm", new CheckoutForm());
        return "user/order";
    }

}
