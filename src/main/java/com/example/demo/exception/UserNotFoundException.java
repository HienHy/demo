package com.example.demo.exception;

import net.bytebuddy.implementation.bind.annotation.Super;

public class UserNotFoundException extends Throwable {

    public UserNotFoundException(String message) {
        super(message);
    }
}
