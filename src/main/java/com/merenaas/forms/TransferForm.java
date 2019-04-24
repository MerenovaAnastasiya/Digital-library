package com.merenaas.forms;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class TransferForm {
    private Integer accountTo;
    private Integer amount;
    private Object csrfToken;
}
