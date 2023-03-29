package com.example.repo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.example.config.AeroMapperConfig;
import com.example.model.Employee;

import jakarta.inject.Inject;

public class EmployeeRepoImpl implements EmployeeRepo{
	
//	@Inject
	@Autowired
    AeroMapperConfig mapper;

	@Override
	public List<Employee> getAllEmployees() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Employee> getbyId(int id) {
		// TODO Auto-generated method stub
		return null;
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
