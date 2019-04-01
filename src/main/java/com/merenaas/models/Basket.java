package com.merenaas.models;

import lombok.*;

import java.util.List;

@Getter
@Setter
@ToString(exclude = "user")
//@EqualsAndHashCode
@Builder
@Data
public class Basket {
    private Long id;
    private User user;
    private List<Book> books;
}
