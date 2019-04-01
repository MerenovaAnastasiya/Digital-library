package com.merenaas.models;
import lombok.*;

import java.time.LocalDate;
import java.util.List;

@Getter
@Setter
@ToString(exclude = "user")
@Builder
@EqualsAndHashCode
public class Order {
    private Long id;
    private User user;
    private List<Book> bookList;
    private String address;
    private LocalDate date;
    private String userFirstName;
    private String userLastName;
    private String phone;
    private String email;
    private String comment;
}
