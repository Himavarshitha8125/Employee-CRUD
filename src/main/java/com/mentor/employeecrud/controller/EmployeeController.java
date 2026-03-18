package com.mentor.employeecrud.controller;

import com.mentor.employeecrud.entity.Employee;
import com.mentor.employeecrud.service.EmployeeService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/employees")
public class EmployeeController {

    private final EmployeeService service;

    public EmployeeController(EmployeeService service) { this.service = service; }

    @PostMapping
    public Employee createEmployee(@RequestBody Employee employee) { return service.saveEmployee(employee); }

    @GetMapping
    public List<Employee> getAllEmployees() { return service.getAllEmployees(); }

    @GetMapping("/{id}")
    public ResponseEntity<Employee> getEmployeeById(@PathVariable Long id) {
        return service.getEmployeeById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PutMapping("/{id}")
    public ResponseEntity<Employee> updateEmployee(@PathVariable Long id, @RequestBody Employee employee) {
        return service.getEmployeeById(id)
                .map(existing -> {
                    existing.setName(employee.getName());
                    existing.setEmail(employee.getEmail());
                    existing.setDepartment(employee.getDepartment());
                    return ResponseEntity.ok(service.updateEmployee(existing));
                })
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteEmployee(@PathVariable Long id) {
        if(service.getEmployeeById(id).isPresent()) {
            service.deleteEmployee(id);
            return ResponseEntity.ok().build();
        }
        return ResponseEntity.notFound().build();
    }
 
    
}
