package com.fsjdida.gestion_des_commandes.Dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CustomerRequestDto {

    @NotNull(message = "le nom est obligatoire")
    @Size(min = 5,max = 30 , message = "le nom doit contient de 5 a 30 caractere")
    private String firstName;

    @NotNull(message = "le nom est obligatoire")
    @Size(min = 5,max = 30 , message = "le nom doit contient de 5 a 30 caractere")
    private String lastName;

    @NotNull
    @Email(message = "Email is not valid", regexp = "^[a-zA-Z0-9_!#$%&'*+/=?`{|}~^.-]+@[a-zA-Z0-9.-]+$")
    private String email;
}
