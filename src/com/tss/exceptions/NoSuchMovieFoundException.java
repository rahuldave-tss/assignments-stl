package com.tss.exceptions;

public class NoSuchMovieFoundException extends Exception{
    @Override
    public String getMessage() {
        return "No such movie found !!";
    }
}
