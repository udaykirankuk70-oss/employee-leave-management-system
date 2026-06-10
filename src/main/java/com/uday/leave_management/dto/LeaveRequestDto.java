package com.uday.leave_management.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class LeaveRequestDto {
    @NotNull(message = "start date is required")
    private LocalDate startDate;
    @NotNull(message = "end date is required")
    private LocalDate endDate;
    @NotBlank(message = "reason is required")
    private String reason;

}
