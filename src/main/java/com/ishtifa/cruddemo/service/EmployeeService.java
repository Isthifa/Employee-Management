package com.ishtifa.cruddemo.service;

import com.ishtifa.cruddemo.dao.EmployeeRepository;
import com.ishtifa.cruddemo.entity.Employee;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeService implements EmployeeServiceDAO{
    private EmployeeRepository employeeRepository;
    @Autowired
    public EmployeeService(EmployeeRepository theemployeeRepository)
    {
        employeeRepository=theemployeeRepository;
    }
    @Override
    public List<Employee> findAll() {
        return employeeRepository.findAll();
    }

    @Override
    public Employee findbyid(int id) {
        Optional<Employee> result = employeeRepository.findById(id);
        Employee theEmployee=null;
        if(result.isPresent()) {
            theEmployee = result.get();
        }
        else {
            throw new RuntimeException("not found id "+id);
        }
        return theEmployee;
    }

    @Override
    public Employee save(Employee theEmployee) {
        return employeeRepository.save(theEmployee);
    }

    @Override
    public void deletebyid(int id) {
        employeeRepository.deleteById(id);

    }
}
