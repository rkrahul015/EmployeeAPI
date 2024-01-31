package com.employee.repository;

import com.employee.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface EmployeeRepository extends JpaRepository<Employee,Long> {


    List<Employee> findByEmpCity(String emp_city);
    List<Employee> findByEmpAgeGreaterThanEqual(int emp_age);

}
