package com.merenaas.forms;


import lombok.*;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@EqualsAndHashCode
public class CheckoutForm {

    private String address;
    private String phone;
    private String email;
    private String comment;
    private String dateOfDelivery;
    private String dateOfReturn;

}
