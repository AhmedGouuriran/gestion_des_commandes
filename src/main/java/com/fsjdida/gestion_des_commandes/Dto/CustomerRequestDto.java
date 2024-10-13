package com.fsjdida.gestion_des_commandes.Dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CustomerRequestDto {

    private String firstName;
    private String lastName;
    private String email;
}
