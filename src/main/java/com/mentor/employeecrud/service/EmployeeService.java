package com.mentor.employeecrud.service;

import com.mentor.employeecrud.entity.Employee;
import com.mentor.employeecrud.repository.EmployeeRepository;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class EmployeeService {

    private final EmployeeRepository repository;

    public EmployeeService(EmployeeRepository repository) {
        this.repository = repository;
    }

    public Employee saveEmployee(Employee employee) { return repository.save(employee); }

    public List<Employee> getAllEmployees() { return repository.findAll(); }

    public Optional<Employee> getEmployeeById(Long id) { return repository.findById(id); }

    public Employee updateEmployee(Employee employee) { return repository.save(employee); }

    public void deleteEmployee(Long id) { repository.deleteById(id); }
    
    
    
}
