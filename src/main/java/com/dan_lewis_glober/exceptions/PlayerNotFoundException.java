package com.dan_lewis_glober.exceptions;

public class PlayerNotFoundException extends Exception {

    public PlayerNotFoundException() {
        super("No player found for this id");
    }

    public PlayerNotFoundException(String message) {
        super(message);
    }
}
