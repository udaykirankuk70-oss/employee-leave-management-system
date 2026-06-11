package com.uday.leave_management.controller;

import com.uday.leave_management.dto.LeaveRequestDto;
import com.uday.leave_management.dto.LeaveResponseDto;
import com.uday.leave_management.service.LeaveRequestService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/employees")
public class LeaveRequestController {

    private final LeaveRequestService leaveRequestService;
    public LeaveRequestController(LeaveRequestService leaveRequestService){
        this.leaveRequestService=leaveRequestService;
    }

    @PostMapping("/{employeeId}/leave")
    @ResponseStatus(HttpStatus.CREATED)
    public LeaveResponseDto applyLeave(@PathVariable Long employeeId, @Valid @RequestBody LeaveRequestDto leaveRequestDto){
        System.out.println(leaveRequestDto.getStartDate());
        System.out.println(leaveRequestDto.getEndDate());
        System.out.println(leaveRequestDto.getReason());
        return leaveRequestService.applyLeave(employeeId, leaveRequestDto);
    }
    @PutMapping("/leave/{leaveRequestId}/approve")
    public LeaveResponseDto approveLeave(@PathVariable Long leaveRequestId){
        return leaveRequestService.approveLeave(leaveRequestId);
    }

}
