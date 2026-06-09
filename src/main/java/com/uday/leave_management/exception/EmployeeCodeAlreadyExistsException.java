package com.uday.leave_management.exception;

public class EmployeeCodeAlreadyExistsException extends RuntimeException{
    public EmployeeCodeAlreadyExistsException(String message){
        super(message);
    }
}
