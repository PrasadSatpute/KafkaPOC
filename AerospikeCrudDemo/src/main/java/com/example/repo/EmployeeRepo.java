package com.example.repo;

import java.util.List;

import com.example.model.Employee;

public interface EmployeeRepo {
	List<Employee> getAllEmployees();

    List<Employee> getbyId(int id);

    void addEmp(Employee emp);

    Employee updateEmp(Employee emp);

    void deleteById(int id);
}
