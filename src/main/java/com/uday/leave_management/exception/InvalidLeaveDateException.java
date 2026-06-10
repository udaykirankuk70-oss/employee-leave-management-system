package com.uday.leave_management.exception;

public class InvalidLeaveDateException extends RuntimeException{
    public InvalidLeaveDateException(String message){
        super(message);
    }
}
