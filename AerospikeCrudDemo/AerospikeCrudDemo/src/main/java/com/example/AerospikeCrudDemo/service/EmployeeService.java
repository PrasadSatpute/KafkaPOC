package com.example.AerospikeCrudDemo.service;

import java.util.Optional;

import org.springframework.stereotype.Service;

import com.example.AerospikeCrudDemo.model.Employee;
import com.example.AerospikeCrudDemo.repository.AerospikeEmployeeRepository;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class EmployeeService {
	AerospikeEmployeeRepository aerospikeEmployeeRepository;
	
	public Optional<Employee> readEmployeeById(int id)
	{
		return aerospikeEmployeeRepository.findById(id);
	}
	public void addEmployee(Employee emp) {
        aerospikeEmployeeRepository.save(emp);
    }
    public void removeEmployeeById(int id) {
        aerospikeEmployeeRepository.deleteById(id);
    }
	
}
