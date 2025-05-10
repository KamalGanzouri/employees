package com.ganzouri.employees.controller;

import com.ganzouri.employees.entity.Employee;
import com.ganzouri.employees.request.EmployeeRequest;
import com.ganzouri.employees.service.EmployeeService;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Min;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/employee")
public class EmployeeController {

    private final EmployeeService employeeService;

    @Autowired
    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }
    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Employee getEmployee(@Min(value = 1) @PathVariable long id) {
        return employeeService.findById(id);
    }
    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<Employee> getAllEmployees() {
        return employeeService.findAll();
    }
    @PostMapping
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void addEmployee(@Valid @RequestBody EmployeeRequest employeeRequest) {
        employeeService.save(employeeRequest);
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void updateEmployee(@Min(value = 1) @PathVariable long id,@Valid @RequestBody EmployeeRequest employeeRequest) {
        employeeService.update(id, employeeRequest);
    }
    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteEmployee(@Min(value = 1) @PathVariable long id) {
        employeeService.delete(id);
    }
}
