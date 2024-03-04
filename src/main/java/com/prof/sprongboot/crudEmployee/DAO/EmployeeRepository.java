package com.prof.sprongboot.crudEmployee.DAO;

import com.prof.sprongboot.crudEmployee.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository<Employee,Integer> {
    //no need to write code or create class to use this interface :D
}
