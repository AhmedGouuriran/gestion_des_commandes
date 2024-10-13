package com.fsjdida.gestion_des_commandes.Exceptions;

public class EntityNotFoundException  extends RuntimeException{

    public EntityNotFoundException() {
    }

    public EntityNotFoundException(String message) {
        super(message);
    }
}
