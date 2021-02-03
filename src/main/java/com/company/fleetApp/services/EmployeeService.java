package com.company.fleetApp.services;

import java.util.List;
import java.util.Optional;

import com.company.fleetApp.models.User;
import com.company.fleetApp.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.company.fleetApp.models.Employee;
import com.company.fleetApp.repositories.EmployeeRepository;

@Service
public class EmployeeService {
		
	@Autowired
	private EmployeeRepository employeeRepository;

	@Autowired
	private UserRepository userRepository;
	
	//Get All Employees
	public List<Employee> findAll(){
		return employeeRepository.findAll();
	}	
	
	//Get Employee By Id
	public Optional<Employee> findById(int id) {
		return employeeRepository.findById(id);
	}	
	
	//Delete Employee
	public void delete(int id) {
		employeeRepository.deleteById(id);
	}
	
	//Update Employee
	public void save( Employee employee) {
		employeeRepository.save(employee);
	}
	
	//Get Employee by username
	public Employee findByUsername(String un) {
		return employeeRepository.findByUsername(un);
	}

	public void assignUsername(int id){
		Employee employee = employeeRepository.findById(id).orElse(null);
		User user = userRepository.findByFirstnameAndLastname(
				employee.getFirstname(),
				employee.getLastname());
		employee.setUsername(user.getUsername());
		employeeRepository.save(employee);

	}
}
