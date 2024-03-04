package com.prof.sprongboot.crudEmployee.services;

import com.prof.sprongboot.crudEmployee.entity.Employee;

import java.util.List;

public interface EmployeeService {
    List<Employee> findAll();

    Employee findById(int theId);

    Employee save(Employee theEmployee);

    void deleteById(int theId);
}
