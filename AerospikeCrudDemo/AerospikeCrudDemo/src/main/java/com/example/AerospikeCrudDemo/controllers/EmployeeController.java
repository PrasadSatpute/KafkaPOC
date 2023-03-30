package com.example.AerospikeCrudDemo.controllers;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.AerospikeCrudDemo.model.Employee;
import com.example.AerospikeCrudDemo.service.EmployeeService;

import lombok.AllArgsConstructor;

@RestController
@AllArgsConstructor
public class EmployeeController {

	@Autowired
	EmployeeService employeeService;
	
	@GetMapping("/emp/{id}")
    public Optional<Employee> readEmployeeById(@PathVariable("id") Integer id) {
        return employeeService.readEmployeeById(id);
    }
    @PostMapping("/emp")
    public void addEmployee(@RequestBody Employee emp) {
    	employeeService.addEmployee(emp);
    }
    @DeleteMapping("/emp/{id}")
    public void deleteEmployeeById(@PathVariable("id") Integer id) {
    	employeeService.removeEmployeeById(id);
    }
	
}
