package com.uday.leave_management.service;

import com.uday.leave_management.dto.EmployeeRequestDto;
import com.uday.leave_management.dto.EmployeeResponseDto;

import java.util.List;

public interface EmployeeService {
    EmployeeResponseDto createEmployee(EmployeeRequestDto requestDto);
    EmployeeResponseDto getEmployeeById(Long id);
    List<EmployeeResponseDto> getAllEmployees();
}
