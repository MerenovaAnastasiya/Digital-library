package com.merenaas.models;

import lombok.*;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import lombok.Builder;
import org.springframework.web.bind.annotation.ModelAttribute;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Getter
@Setter
@ToString(exclude = "basket")
@Builder
@EqualsAndHashCode(exclude = "basket")

public class User {
    private Long id;
    @NotNull
    @Size(min = 5, max = 60)
    private String login;
    private String phoneNumber;
    @Email
    private String email;
    private String password;
    private List<Order> orders;
    private String uuid;
    private Basket basket;
}

