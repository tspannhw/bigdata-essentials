package com.needforcode.mongodb.controller;

import com.needforcode.mongodb.model.Employee;
import com.needforcode.mongodb.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class EmployeeController {

    @Autowired
    private EmployeeRepository repository;

    @RequestMapping(value = "/hello")
    public String hello() {
        return "Hello";
    }

    @RequestMapping(value = "/addEmployee", method = RequestMethod.POST)
    public Employee addEmployee(@ModelAttribute Employee employee) {
        return repository.save(employee);
    }

    @RequestMapping(value = "/employee/{name}")
    public List<Employee> findEmployeeByLastName(@PathVariable String name) {
        return repository.findByempName(name);
    }

    @RequestMapping("/employees")
    public List<Employee> getEmployees(){
        return repository.findAll();
    }

    @RequestMapping("/employees/{empId}")
    public Employee getEmployeesByempId(@PathVariable String id) {
        return repository.findByempId(id);
    }
}
