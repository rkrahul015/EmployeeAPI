package com.employee.repository;

import com.employee.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface EmployeeRepository extends JpaRepository<Employee,Long> {

    Optional<List<Employee>> findByEmpCity(String emp_city);
    Optional<List<Employee>> findByEmpageGreaterThan(int emp_age);

}
