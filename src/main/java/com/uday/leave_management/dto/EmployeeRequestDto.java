package com.uday.leave_management.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class EmployeeRequestDto {

    @NotNull(message = "Employee code is required")
    private String employeeCode;
    @NotNull(message = "Name is required")
    private String name;
    @Email(message = "Invalid email format")
    @NotNull(message= "Email is required")
    private String email;
    @NotNull(message = " Department is required")
    private String department;
}
