package com.uday.leave_management.service;

import com.uday.leave_management.dto.LeaveRequestDto;
import com.uday.leave_management.dto.LeaveResponseDto;
import org.springframework.stereotype.Service;

@Service
public interface LeaveRequestService {
    LeaveResponseDto applyLeave(Long employeeId, LeaveRequestDto requestDto);
    LeaveResponseDto approveLeave(Long leaveRequestId);


}
