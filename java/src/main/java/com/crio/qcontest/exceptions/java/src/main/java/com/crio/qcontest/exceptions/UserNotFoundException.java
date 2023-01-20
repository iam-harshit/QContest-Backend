package com.crio.qcontest.exceptions.java.src.main.java.com.crio.qcontest.exceptions;

public class UserNotFoundException extends RuntimeException{
    public UserNotFoundException(){
        super();
    }

    public UserNotFoundException(String msg){
        super(msg);
    }
}

