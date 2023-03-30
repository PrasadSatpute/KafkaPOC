package com.example.AerospikeCrudDemo.repository;

import java.util.Optional;

import org.springframework.data.aerospike.repository.AerospikeRepository;

import com.example.AerospikeCrudDemo.model.Employee;

public interface AerospikeEmployeeRepository extends AerospikeRepository<Employee, Integer>{

	Optional<Employee> findById(int id);

	void save(Employee emp);

	void deleteById(int id);

}
