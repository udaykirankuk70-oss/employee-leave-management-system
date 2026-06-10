package com.uday.leave_management.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class LeaveRequestDto {
    @NotBlank(message = "start date is required")
    private LocalDate startDate;
    @NotBlank(message = "end date is required")
    private LocalDate endDate;
    @NotBlank(message = "reason is required")
    private String reason;

}
