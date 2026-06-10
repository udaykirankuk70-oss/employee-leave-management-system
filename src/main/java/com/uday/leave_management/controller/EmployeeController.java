package com.uday.leave_management.controller;

import com.uday.leave_management.dto.EmployeeRequestDto;
import com.uday.leave_management.dto.EmployeeResponseDto;
import com.uday.leave_management.service.EmployeeService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/employees")
public class EmployeeController {
    @Autowired
    EmployeeService employeeService;
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public EmployeeResponseDto createEmployee(@Valid @RequestBody EmployeeRequestDto requestDto){
        return employeeService.createEmployee(requestDto);
    }
    @GetMapping("/{id}")
    public EmployeeResponseDto getEmployeeById(@PathVariable Long id){
        return employeeService.getEmployeeById(id);
    }
    @GetMapping
    public List<EmployeeResponseDto> getAllEmployees(){
        return employeeService.getAllEmployees();
    }
}
