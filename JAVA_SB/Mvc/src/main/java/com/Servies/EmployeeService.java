package com.Servies;

import com.Dto.Employee;
import com.Repository.EmployeeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class EmployeeService {


    @Autowired
    private EmployeeRepository repository;

    public Employee saveEmployee(Employee e){
        return repository.save(e);
    }

    public List<Employee> getAllEmployees() {
        return repository.findAll();
    }

    public Optional<Employee> getEmployeeById(String id) {
        return repository.findById(id);
    }

    public Employee updateEmployee(String id, Employee employee){
        if (repository.existsById(id)) {
            employee.setId(id);
            return repository.save(employee);
        } else {
            throw new RuntimeException("Employee not found with id: " + id);
        }
    }

    public void deleteEmployee(String id){
        repository.deleteById(id);
    }
}
