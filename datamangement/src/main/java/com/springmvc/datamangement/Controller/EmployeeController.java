package com.springmvc.datamangement.Controller;

import com.springmvc.datamangement.Dto.Employee;
import com.springmvc.datamangement.Servies.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class EmployeeController {

    @Autowired
    private EmployeeService service;

    @PostMapping
    public Employee SaveEmp(@RequestBody Employee  employee){
        return service.saveEmployee(employee);
    }

    @GetMapping("/displayAll")
    public List<Employee>getAllEmployees(){
        return service.getAllEmployees();
    }

    @GetMapping("/display/{id}")
    public Optional<Employee> getEmployeeById(@PathVariable String id) {
        return service.getEmployeeById(id);
    }

    @PutMapping("/update/{id}")
    public Employee updateEmployee(@PathVariable String id,@RequestBody Employee employee){
        return service.updateEmployee(id,employee);
    }

    @DeleteMapping("/delete/{id}")
    public String deleteEmployee(@PathVariable String id) {
        service.deleteEmployee(id);
        return "Employee deleted successfully";
    }


}
