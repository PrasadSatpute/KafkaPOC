package com.example.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.model.Employee;
import com.example.service.EmployeeService;

import jakarta.inject.Inject;
import lombok.AllArgsConstructor;

@RestController
@AllArgsConstructor
@RequestMapping("/api")
public class EmployeeController {
//	@Inject
	@Autowired
    private EmployeeService service;

    @GetMapping("emp")
    public List<Employee> getAllEmployees()
    {
        return service.getAllEmployees();
    }

    @GetMapping("emp/{id}")
    public Optional<Employee> getById(@PathVariable int id)
    {
        return service.getById(id);
    }

    @PostMapping("emp")
    public String addEmp(@RequestBody Employee emp)
    {
        service.addEmp(emp);
        return "Employee added successfully!";
    }

    @PutMapping("emp")
    public Employee updateEmp(@RequestBody Employee emp)
    {
        return service.updateEmp(emp);
    }

    @DeleteMapping("emp/{id}")
    public String deleteById(@PathVariable int id)
    {
        service.deleteById(id);
        return "Employee info deleted successfully!";
    }
}
