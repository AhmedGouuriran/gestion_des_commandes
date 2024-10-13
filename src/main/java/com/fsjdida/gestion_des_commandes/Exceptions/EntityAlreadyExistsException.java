package com.fsjdida.gestion_des_commandes.Exceptions;

public class EntityAlreadyExistsException extends  RuntimeException{

    public EntityAlreadyExistsException() {
    }

    public EntityAlreadyExistsException(String message) {
        super(message);
    }
}
