package com.prof.sprongboot.crudEmployee.rest;

//import com.prof.sprongboot.crudEmployee.DAO.EmployeeDAO;
import com.prof.sprongboot.crudEmployee.entity.Employee;
import com.prof.sprongboot.crudEmployee.services.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api")
public class EmployeeRestController {
//inject employee dao (use constructor injection)
    private EmployeeService employeeService;
    @Autowired
    public EmployeeRestController(EmployeeService employeeService){
        this.employeeService = employeeService;
    }
@GetMapping("/employee")
    public List<Employee> getAllEmployee(){
    return employeeService.findAll();
}

@GetMapping("/employee/{employeeId}")
    public Employee getEmployee(@PathVariable int employeeId){
        Employee theEmployee = employeeService.findById(employeeId);
        if (theEmployee == null){
            throw new RuntimeException(employeeId + " is not found ");
        }
        return theEmployee;

}

//insert employee
@PostMapping("/employee")
//@RequestBody to send object with JSON
    public Employee addEmployee(@RequestBody Employee theEmployee){
        //we should add id = 0 to make insert instead of update
        //to save new item
        theEmployee.setId(0);
         Employee dbEmployee = employeeService.save(theEmployee);
         return dbEmployee;
}
//update employee
 @PutMapping("/employee")
    public Employee updateEmployee(@RequestBody Employee theEmployee){
        Employee dbEmployee = employeeService.save(theEmployee);
        return dbEmployee;
 }
@DeleteMapping("/employee/{employeeId}")
    public String deleteEmployee(@PathVariable int employeeId){
    Employee theEmployee = employeeService.findById(employeeId);
    if(theEmployee == null){
        throw new RuntimeException("no employee found for ID--" + employeeId);
    }
    employeeService.deleteById(employeeId);
    return "Delete done successfully for ID-- " + employeeId;
}

}






















