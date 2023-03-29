package com.ishtifa.cruddemo.service;

import com.ishtifa.cruddemo.entity.Employee;

import java.util.List;

public interface EmployeeServiceDAO {
    List<Employee> findAll();
    Employee findbyid(int id);
    Employee save(Employee theEmployee);
    void deletebyid(int id);
}
