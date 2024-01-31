package com.employee.controller;

import com.employee.model.Employee;
import com.employee.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api")
public class EmployeeController {

    @Autowired
    private EmployeeRepository employeeRepository;

    @PostMapping("/employees")
    public String createNewEmployee(@RequestBody Employee employee) {
        employeeRepository.save(employee);
        return "New Employee is created in database. ";
    }

    @GetMapping("/employees")
    public ResponseEntity<List<Employee>> getAllEmployees() {
        List<Employee> employeeList = new ArrayList<>();
        List<Employee> allEmployee = employeeRepository.findAll();
        employeeList.addAll(allEmployee);
        return new ResponseEntity<List<Employee>>(employeeList, HttpStatus.OK);
    }

    @GetMapping("/employees/{id}")
    public ResponseEntity<Employee> getEmployeesById(@PathVariable long id) {
        Optional<Employee> emp = employeeRepository.findById(id);
        if (!emp.isEmpty()) {
            return new ResponseEntity<Employee>(emp.get(), HttpStatus.OK);
        } else {
            return new ResponseEntity<Employee>(HttpStatus.NOT_FOUND);
        }

    }
    @GetMapping("/employees/city/{city}")
    public ResponseEntity<List<Employee>> getEmployeesByCity(@PathVariable("city") String emp_city) {
        List<Employee>  emp = employeeRepository.findByEmpCity(emp_city);
        if(!emp.isEmpty())
            return new ResponseEntity<>(emp,HttpStatus.OK);
        else
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @GetMapping("/employees/age/{age}")
    public ResponseEntity<List<Employee>> getEmployeesGreaterThanAge(@PathVariable("age") int emp_age) {
        List<Employee>  emp = employeeRepository.findByEmpAgeGreaterThanEqual(emp_age);
        if(!emp.isEmpty())
            return new ResponseEntity<>(emp,HttpStatus.OK);
        else
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @PutMapping("/employees/{id}")
    public String updateEmployeeById(@PathVariable long id, @RequestBody Employee employee) {
        var emp = employeeRepository.findById(id);
        if(emp.isPresent()) {
            Employee exitEmp = emp.get();
            exitEmp.setEmpName(employee.getEmpName());
            exitEmp.setEmpAge(employee.getEmpAge());
            exitEmp.setEmpCity(employee.getEmpCity());
            exitEmp.setEmpSalary(employee.getEmpSalary());
            employeeRepository.save(exitEmp);

            return "Employee Details against Id = "+id+ " Updated.";
        }
        else {
            return "Employee Details does not exist fro Id = "+id;
        }
    }

    @DeleteMapping("/employees/{id}")
    public String deleteEmployeeByID(@PathVariable long id) {
        employeeRepository.deleteById(id);
        return "Employee with Id = "+id+ " Deleted Successfully";

    }

    @DeleteMapping("/employees")
    public String deleteAllEmployee() {
        employeeRepository.deleteAll();
        return "All Employee data is Deleted Successfully.";
    }

}
