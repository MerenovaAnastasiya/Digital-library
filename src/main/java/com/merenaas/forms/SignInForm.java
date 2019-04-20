package com.merenaas.forms;

import lombok.*;
import org.springframework.context.annotation.Bean;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@EqualsAndHashCode
public class SignInForm{
    private String email;
    private String password;

}
