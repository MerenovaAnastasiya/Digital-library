package com.merenaas.forms;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class SignUpForm  {

    @NotBlank
    @Pattern(regexp = "[A-Za-z0-9_]{3,16}", message = "{login.incorrect}")
    private String login;

    @NotBlank
    @Email
    private String email;

    @NotBlank
    @Pattern(regexp = "[A-Za-z0-9_]{6,16}", message = "{password.incorrect}")
    private String password;
}
