package com.merenaas.forms;

import lombok.*;

import javax.validation.constraints.NotBlank;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@EqualsAndHashCode
public class UpdateProfileForm {
    private String login;
    private String email;
    private String phoneNumber;
}
