package com.example.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.entity.Employee;

@Repository
public interface EmployeeRepo extends JpaRepository<Employee, String>{
	
	@Query("select count(emp_id) from Employee")
	long countByEmployeeId();
	

}
