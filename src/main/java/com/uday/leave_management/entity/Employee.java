package com.uday.leave_management.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Setter
@Getter

@Entity
@Table(name = "employees")
public class Employee {
    @OneToMany(mappedBy = "employee",cascade = CascadeType.ALL)
    private List<LeaveRequest> leaveRequests;


    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;

    @Column(name="employee_code" , nullable = false, unique = true)
    private String employeeCode;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false, unique = true)
    private String email;

    @Column(nullable = false)
    private String department;

    @Column( name="leave_balance", nullable=false)
    private Integer leaveBalance;
}
