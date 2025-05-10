package com.ganzouri.employees.service;

import com.ganzouri.employees.entity.Employee;
import com.ganzouri.employees.request.EmployeeRequest;
import jakarta.validation.Valid;

import java.util.List;

public interface EmployeeService {
    Employee findById(Long id);
    List<Employee> findAll();
    void save(EmployeeRequest employee);
    void update(long id, EmployeeRequest employeeRequest);
    void delete(Long id);
}
