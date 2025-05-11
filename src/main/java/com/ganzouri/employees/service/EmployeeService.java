package com.ganzouri.employees.service;

import com.ganzouri.employees.entity.Employee;
import com.ganzouri.employees.request.EmployeeRequest;

import java.util.List;

public interface EmployeeService {
    Employee findById(long id);
    List<Employee> findAll();
    void save(Long id, EmployeeRequest employeeRequest);
    void delete(long id);
}
