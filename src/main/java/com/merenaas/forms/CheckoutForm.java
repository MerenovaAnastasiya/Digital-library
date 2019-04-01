package com.merenaas.forms;


import lombok.*;
import com.merenaas.models.Book;
import com.merenaas.models.User;

import java.time.LocalDate;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@EqualsAndHashCode
public class CheckoutForm {

    private String address;
    private LocalDate date;
    private String userFirstName;
    private String userLastName;
    private String phone;
    private String email;
    private String comment;
}
