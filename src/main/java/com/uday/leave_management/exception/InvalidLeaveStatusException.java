package com.uday.leave_management.exception;

public class InvalidLeaveStatusException extends RuntimeException{
    public InvalidLeaveStatusException(String message){
        super(message);
    }
}
