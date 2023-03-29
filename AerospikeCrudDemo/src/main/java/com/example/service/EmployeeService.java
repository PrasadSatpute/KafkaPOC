package com.example.service;

import java.util.List;
import java.util.Optional;

import com.example.model.Employee;

public interface EmployeeService {

	List<Employee> getAllEmployees();

    Optional<Employee> getById(int id);

    void addEmp(Employee emp);

    Employee updateEmp(Employee emp);

    void deleteById(int id);
	
}
