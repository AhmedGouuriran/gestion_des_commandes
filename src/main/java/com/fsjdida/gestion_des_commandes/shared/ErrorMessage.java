package com.fsjdida.gestion_des_commandes.shared;

import lombok.*;
import lombok.experimental.FieldDefaults;

import java.util.Date;

@AllArgsConstructor
@NoArgsConstructor
@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
@Builder
public class ErrorMessage {

    String message;
    Date Timestemp ;
    Integer code ;

}
