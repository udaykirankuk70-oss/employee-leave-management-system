package com.uday.leave_management.dto;

import com.uday.leave_management.entity.LeaveStatus;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class LeaveResponseDto {
    private Long id;
    private LocalDate startDate;
    private LocalDate endDate;
    private String reason;
    private Integer totalDays;
    private LeaveStatus status;
    }
