package com.ganzouri.employees.service;

import com.ganzouri.employees.dao.EmployeeRepository;
import com.ganzouri.employees.entity.Employee;
import com.ganzouri.employees.request.EmployeeRequest;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeServiceImpl implements EmployeeService{

    private final EmployeeRepository employeeRepository;

    @Autowired
    public EmployeeServiceImpl(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    @Override
    public Employee findById(long id) {
        return employeeRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Employee not found with id: " + id));
    }

    @Override
    public List<Employee> findAll() {
        return employeeRepository.findAll();
    }

    @Override
    @Transactional
    public void save(Long id, EmployeeRequest employeeRequest) {
        employeeRepository.save(ConvertToEntity(id, employeeRequest));
    }

    @Override
    @Transactional
    public void delete(long id) {
        employeeRepository.deleteById(id);
    }

    public static Employee ConvertToEntity(long id, EmployeeRequest employeeRequest) {
        return new Employee(id,
                employeeRequest.getFirstName(),
                employeeRequest.getLastName(),
                employeeRequest.getEmail());
    }
}
