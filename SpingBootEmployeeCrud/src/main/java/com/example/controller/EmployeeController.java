package com.example.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.entity.Employee;
import com.example.service.EmployeeService;

import lombok.AllArgsConstructor;

@RestController
@AllArgsConstructor
@RequestMapping("/api/emp")
public class EmployeeController {
	
	@Autowired
	private EmployeeService employeeService;
	
	// build create Employee REST API
    @PostMapping
    public ResponseEntity<Employee> createEmployee(@RequestBody Employee Employee){
        Employee savedEmployee = employeeService.createEmployee(Employee);
        return new ResponseEntity<>(savedEmployee, HttpStatus.CREATED);
    }

    // build get Employee by id REST API
    // http://localhost:8080/api/Employees/1
    @GetMapping("{id}")
    public ResponseEntity<Employee> getEmployeeById(@PathVariable("id") Long EmployeeId){
        Employee Employee = employeeService.getEmployeeByID(EmployeeId);
        return new ResponseEntity<>(Employee, HttpStatus.OK);
    }

    // Build Get All Employees REST API
    // http://localhost:8080/api/Employees
    @GetMapping
    public ResponseEntity<List<Employee>> getAllEmployees(){
        List<Employee> Employees = employeeService.getAllEmployee();
        return new ResponseEntity<>(Employees, HttpStatus.OK);
    }

    // Build Update Employee REST API
    @PutMapping("{id}")
    // http://localhost:8080/api/Employees/1
    public ResponseEntity<Employee> updateEmployee(@PathVariable("id") Long EmployeeId,
                                           @RequestBody Employee Employee){
        Employee.setId(EmployeeId);
        Employee updatedEmployee = employeeService.updateEmployee(Employee);
        return new ResponseEntity<>(updatedEmployee, HttpStatus.OK);
    }

    // Build Delete Employee REST API
    @DeleteMapping("{id}")
    public ResponseEntity<String> deleteEmployee(@PathVariable("id") Long EmployeeId){
        employeeService.deleteEmployee(EmployeeId);
        return new ResponseEntity<>("Employee successfully deleted!", HttpStatus.OK);
    }
	
}
