package com.example.service;

import java.util.List;

import com.example.entity.Employee;

public interface EmployeeService {
	
	Employee createEmployee(Employee employee);
	
	Employee getEmployeeByID(Long employeeId);
	
	List<Employee> getAllEmployee();

    Employee updateEmployee(Employee employee);

    void deleteEmployee(Long employeeId);

}
