package com.merenaas.forms;

import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@EqualsAndHashCode

public class SignInForm{
    private String email;
    private String password;

}
