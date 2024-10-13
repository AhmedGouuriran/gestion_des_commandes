package com.fsjdida.gestion_des_commandes.Dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CustomerResponseDto {

    private long id;
    private String firstName;
    private String lastName;
    private String email;
}
