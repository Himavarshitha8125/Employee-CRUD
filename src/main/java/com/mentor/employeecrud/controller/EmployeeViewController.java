package com.mentor.employeecrud.controller;



import com.mentor.employeecrud.entity.Employee;
import com.mentor.employeecrud.service.EmployeeService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class EmployeeViewController {

    private final EmployeeService service;

    public EmployeeViewController(EmployeeService service) { this.service = service; }

    @GetMapping("/")
    public String viewHomePage(Model model) {
        model.addAttribute("employees", service.getAllEmployees());
        return "index";
    }

    @GetMapping("/employees/add")
    public String addEmployeeForm(Model model) {
        model.addAttribute("employee", new Employee());
        return "add-employee";
    }

    @PostMapping("/employees/save")
    public String saveEmployee(@ModelAttribute("employee") Employee employee) {
        service.saveEmployee(employee);
        return "redirect:/";
    }

    @GetMapping("/employees/edit/{id}")
    public String editEmployeeForm(@PathVariable Long id, Model model) {
        Employee employee = service.getEmployeeById(id).orElseThrow();
        model.addAttribute("employee", employee);
        return "edit-employee";
    }

    @PostMapping("/employees/update/{id}")
    public String updateEmployee(@PathVariable Long id, @ModelAttribute("employee") Employee employee) {
        employee.setId(id);
        service.updateEmployee(employee);
        return "redirect:/";
    }

    @GetMapping("/employees/delete/{id}")
    public String deleteEmployee(@PathVariable Long id) {
        service.deleteEmployee(id);
        return "redirect:/";
    }
}