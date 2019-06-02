package com.merenaas.controllers;

import com.merenaas.models.Order;
import com.merenaas.repositories.OrderRepository;
import com.merenaas.services.OrderService;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
@Data
public class AdminController {

    private OrderService orderService;

    public AdminController(OrderService orderService) {
        this.orderService = orderService;
    }
    @GetMapping(value="/admin")
    public String adminPage(Model model) {
        List<Order> orders = orderService.getAllOrders();
        model.addAttribute("orders" , orders);
        return "admin";
    }
}
