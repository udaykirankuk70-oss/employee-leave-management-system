package com.uday.leave_management.service.impl;

import com.uday.leave_management.dto.EmployeeRequestDto;
import com.uday.leave_management.dto.EmployeeResponseDto;
import com.uday.leave_management.entity.Employee;
import com.uday.leave_management.exception.EmailAlreadyExistsException;
import com.uday.leave_management.exception.EmployeeCodeAlreadyExistsException;
import com.uday.leave_management.mapper.EmployeeMapper;
import com.uday.leave_management.repository.EmployeeRepository;
import com.uday.leave_management.service.EmployeeService;
import org.springframework.stereotype.Service;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    private final EmployeeRepository employeeRepository;
    private final EmployeeMapper employeeMapper;

    public EmployeeServiceImpl(EmployeeRepository employeeRepository,
                               EmployeeMapper employeeMapper) {
        this.employeeRepository = employeeRepository;
        this.employeeMapper = employeeMapper;
    }

    @Override
    public EmployeeResponseDto createEmployee(EmployeeRequestDto requestDto) {

        if (employeeRepository.existsByEmail(requestDto.getEmail())) {
            throw new EmailAlreadyExistsException("Email already exists");
        }

        if (employeeRepository.existsByEmployeeCode(requestDto.getEmployeeCode())) {
            throw new EmployeeCodeAlreadyExistsException("Employee code already exists");
        }

        Employee employee = employeeMapper.toEntity(requestDto);

        employee.setLeaveBalance(20);

        Employee savedEmployee = employeeRepository.save(employee);

        return employeeMapper.toResponse(savedEmployee);
    }
}