package com.ganzouri.employees.service;

import com.ganzouri.employees.dao.EmployeeDAO;
import com.ganzouri.employees.entity.Employee;
import com.ganzouri.employees.request.EmployeeRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeServiceImpl implements EmployeeService{

    private final EmployeeDAO employeeDAO;

    @Autowired
    public EmployeeServiceImpl(EmployeeDAO employeeDAO) {
        this.employeeDAO = employeeDAO;
    }

    @Override
    public Employee findById(Long id) {
        return employeeDAO.findById(id);
    }

    @Override
    public List<Employee> findAll() {
        return employeeDAO.findAll();
    }

    @Override
    public void save(EmployeeRequest employeeRequest) {
        employeeDAO.save(ConvertToEntity(null, employeeRequest));
    }

    @Override
    public void update(long id, EmployeeRequest employeeRequest) {
        employeeDAO.update(ConvertToEntity(id, employeeRequest));
    }

    @Override
    public void delete(Long id) {
        employeeDAO.delete(id);
    }

    public static Employee ConvertToEntity(Long id, EmployeeRequest employeeRequest) {
        return new Employee(id,
                employeeRequest.getFirstName(),
                employeeRequest.getLastName(),
                employeeRequest.getEmail());
    }
}
