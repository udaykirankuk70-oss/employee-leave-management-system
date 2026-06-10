package com.uday.leave_management.service;

import com.uday.leave_management.dto.LeaveRequestDto;
import org.springframework.stereotype.Service;

@Service
public class LeaveRequestService {
    LeaveRequestDto applyLeave(Long employeeId, LeaveRequestDto requestDto);
}
