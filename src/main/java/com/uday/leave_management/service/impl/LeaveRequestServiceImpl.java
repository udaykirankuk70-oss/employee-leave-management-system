package com.uday.leave_management.service.impl;

import com.uday.leave_management.dto.LeaveRequestDto;
import com.uday.leave_management.dto.LeaveResponseDto;
import com.uday.leave_management.entity.Employee;
import com.uday.leave_management.entity.LeaveRequest;
import com.uday.leave_management.entity.LeaveStatus;
import com.uday.leave_management.exception.EmployeeNotFoundException;
import com.uday.leave_management.exception.InsufficientLeaveBalanceException;
import com.uday.leave_management.exception.InvalidLeaveDateException;
import com.uday.leave_management.mapper.LeaveMapper;
import com.uday.leave_management.repository.EmployeeRepository;
import com.uday.leave_management.repository.LeaveRequestRepository;
import com.uday.leave_management.service.LeaveRequestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
@Service
public class LeaveRequestServiceImpl implements LeaveRequestService {

    private final EmployeeRepository employeeRepository;
    private final LeaveRequestRepository leaveRequestRepository;
    private final LeaveMapper leaveMapper;
    public LeaveRequestServiceImpl(EmployeeRepository employeeRepository, LeaveRequestRepository leaveRequestRepository, LeaveMapper leaveMapper){
        this.employeeRepository= employeeRepository;
        this.leaveRequestRepository=leaveRequestRepository;
        this.leaveMapper=leaveMapper;
    }
    @Override
    public LeaveResponseDto applyLeave(Long employeeId, LeaveRequestDto requestDto) {

        Employee employee = employeeRepository.findById(employeeId)
                .orElseThrow(() ->
                        new EmployeeNotFoundException(
                                "Employee not found with id: " + employeeId));
        if(requestDto.getStartDate().isBefore(LocalDate.now())){
            throw new InvalidLeaveDateException(" start date cannot be in the past ");

        }

        if(requestDto.getEndDate().isBefore(requestDto.getStartDate())){
            throw new InvalidLeaveDateException(" End date cannot be before start date");
        }

        int totalDays= (int) ChronoUnit.DAYS.between(requestDto.getStartDate(),requestDto.getEndDate())+1;

        if(totalDays>employee.getLeaveBalance()){
            throw new InsufficientLeaveBalanceException(" Insufficient Leave Balance ");
        }

        LeaveRequest leaveRequest=leaveMapper.toEntity(requestDto);

        leaveRequest.setTotalDays(totalDays);
        leaveRequest.setStatus(LeaveStatus.PENDING);
        leaveRequest.setEmployee(employee);

        LeaveRequest savedLeave= leaveRequestRepository.save(leaveRequest);

        return leaveMapper.toResponse(savedLeave);

    }
}
