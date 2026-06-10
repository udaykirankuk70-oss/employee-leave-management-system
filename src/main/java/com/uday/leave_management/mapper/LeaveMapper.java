package com.uday.leave_management.mapper;

import com.uday.leave_management.dto.LeaveRequestDto;
import com.uday.leave_management.dto.LeaveResponseDto;
import com.uday.leave_management.entity.LeaveRequest;
import org.springframework.stereotype.Component;

@Component
public class LeaveMapper {
    public LeaveRequest toEntity(LeaveRequestDto dto){
        LeaveRequest leaveRequest =new LeaveRequest();
        leaveRequest.setStartDate(dto.getStartDate());
        leaveRequest.setEndDate(dto.getEndDate());
        leaveRequest.setReason(dto.getReason());
        return leaveRequest;
    }
    public LeaveResponseDto toResponse(LeaveRequest leaveRequest){
        LeaveResponseDto dto=new LeaveResponseDto();
        dto.setId(leaveRequest.getId());
        dto.setStartDate(leaveRequest.getStartDate());
        dto.setEndDate(leaveRequest.getEndDate());
        dto.setReason(leaveRequest.getReason());
        dto.setTotalDays(leaveRequest.getTotalDays());
        dto.setStatus(leaveRequest.getStatus());
        return dto;
    }
}
