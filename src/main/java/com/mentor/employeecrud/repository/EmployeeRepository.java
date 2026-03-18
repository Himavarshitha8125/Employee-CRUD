package com.mentor.employeecrud.repository;


import com.mentor.employeecrud.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long> {
// Spring Data JPA auto-implements CRUD methods
	
	
	
}







