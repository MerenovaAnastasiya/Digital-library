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



}
