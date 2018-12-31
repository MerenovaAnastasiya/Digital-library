package models;

import lombok.*;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import lombok.Builder;

@Getter
@Setter
@ToString(exclude = "basket")
@Builder
@EqualsAndHashCode(exclude = "basket")


public class User {
    private Long id;
    private String login;
    private String phoneNumber;
    private String email;
    private String password;
    private List<Order> orders;
    private String uuid;
    private Basket basket;
}

