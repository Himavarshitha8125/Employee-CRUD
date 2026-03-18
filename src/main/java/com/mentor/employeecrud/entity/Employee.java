package com.mentor.employeecrud.entity;


import jakarta.persistence.*;

@Entity // Marks this as a table
@Table(name = "employees") // Table name
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Auto PK
    private Long id;

    private String name;
    private String email;
    private String department;

    public Employee() {} // Default constructor for JPA

    public Employee(String name, String email, String department) {
        this.name = name;
        this.email = email;
        this.department = department;
    }
    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", department='" + department + '\'' +
                '}';
    }

    // Getters & Setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }
    public String getDepartment() { return department; }
    public void setDepartment(String department) { this.department = department; }
}
