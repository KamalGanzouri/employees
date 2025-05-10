package com.ganzouri.employees.dao;

import com.ganzouri.employees.entity.Employee;
import com.ganzouri.employees.request.EmployeeRequest;

import java.util.List;

public interface EmployeeDAO {
    Employee findById(Long id);
    List<Employee> findAll();
    void save(Employee employee);
    void update(Employee employee);
    void delete(Long id);
}
