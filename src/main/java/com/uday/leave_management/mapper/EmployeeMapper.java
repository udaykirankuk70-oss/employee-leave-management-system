package com.uday.leave_management.mapper;

import com.uday.leave_management.dto.EmployeeRequestDto;
import com.uday.leave_management.dto.EmployeeResponseDto;
import com.uday.leave_management.entity.Employee;
import org.springframework.stereotype.Component;

@Component
public class EmployeeMapper {
    public Employee toEntity(EmployeeRequestDto dto){
        Employee employee=new Employee();
        employee.setEmployeeCode(dto.getEmployeeCode());
        employee.setName(dto.getName());
        employee.setEmail(dto.getEmail());
        employee.setDepartment(dto.getDepartment());
        return employee;
    }
    public EmployeeResponseDto toResponse(Employee employee){
        EmployeeResponseDto responseDto=new EmployeeResponseDto();
        responseDto.setId(employee.getId());
        responseDto.setEmployeeCode(employee.getEmployeeCode());
        responseDto.setName(employee.getName());
        responseDto.setEmail(employee.getEmail());
        responseDto.setDepartment(employee.getDepartment());
        responseDto.setLeaveBalance(employee.getLeaveBalance());

        return responseDto;
    }
    }

