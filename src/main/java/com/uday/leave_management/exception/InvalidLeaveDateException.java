package com.uday.leave_management.exception;

public class InvalidLeaveDateException extends RuntimeException{
    InvalidLeaveDateException(String message){
        super(message);
    }
}
