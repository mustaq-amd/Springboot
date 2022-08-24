package com.example.service;

import com.example.entity.Employee;

public interface EmployeeService {
	
	public Employee createEmployee(Employee employee);
	public long countByEmployee();

}
