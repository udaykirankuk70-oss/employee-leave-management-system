package com.uday.leave_management.repository;

import com.uday.leave_management.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {
    Optional<Employee> findByEmail(String email);
    Optional<Employee> findByEmployeeCode(String employeeCode);
    Optional<Employee> getEmployeeById(Long id);
    Optional<Employee> findById(Long id);
    boolean existsByEmail(String email);
    boolean existsByEmployeeCode(String employeeCOde);
}
