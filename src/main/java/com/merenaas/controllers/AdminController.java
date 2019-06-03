package com.merenaas.controllers;

import com.merenaas.services.OrderService;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
@Data
public class AdminController {

    @Autowired
    private OrderService orderService;

    @GetMapping(value="/admin")
    public String adminPage(Model model) {
        model.addAttribute("orders" , orderService.getAllOrders());
        return "admin/admin";
    }
}
