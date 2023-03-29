package com.example.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import com.example.model.Employee;
import com.example.repo.EmployeeRepo;

import jakarta.inject.Inject;

public class EmployeeServiceImpl implements EmployeeService{
	
	@Inject
	@Autowired
    EmployeeRepo repo;

	@Override
	public List<Employee> getAllEmployees() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Optional<Employee> getById(int id) {
		// TODO Auto-generated method stub
		return Optional.empty();
	}

	@Override
	public void addEmp(Employee emp) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Employee updateEmp(Employee emp) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void deleteById(int id) {
		// TODO Auto-generated method stub
		
	}

}
