package com.uday.leave_management.service;

import com.uday.leave_management.dto.EmployeeRequestDto;
import com.uday.leave_management.dto.EmployeeResponseDto;

public interface EmployeeService {
    EmployeeResponseDto createEmployee(EmployeeRequestDto requestDto);
}
