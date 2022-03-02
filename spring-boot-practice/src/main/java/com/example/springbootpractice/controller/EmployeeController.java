package com.example.springbootpractice.controller;

//    IOC: dependency injection(DI) is the way we implement the IOC in spring
//three ways to fulfill DI: field/method injection , constructor injection (create a bean before doing injection, so we avoid all null pointer injection), property injection
// constructor injection concern?
//    secret dependency ? concept, con of using constructor dependency, how to solve
//circular reference? solve via @Lazy or @PostConstructor
// dao-> service-> dto(data transfer object, wrapped up with optional class) -> controller
//aop : exception


import com.example.springbootpractice.entity.Employee;
import com.example.springbootpractice.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@RestController
public class EmployeeController  {

    private EmployeeService employeeService;
    private RestTemplate restTemplate;

    @Autowired
    public EmployeeController(EmployeeService employeeService, RestTemplate restTemplate ){
        this.employeeService=employeeService;
        this.restTemplate= restTemplate;

    }


    @GetMapping("/employees/{id}")
    public ResponseEntity<Employee> getEmployeeById(@PathVariable(value ="id")int id) {
        return new ResponseEntity<Employee>(employeeService.getById(id), HttpStatus.OK);

    }

    @GetMapping("/employees")
    public ResponseEntity<Employee> getEmployees() {

        return new ResponseEntity<Employee>(employeeService.getAll(), HttpStatus.OK );

    }
    @GetMapping("/employees/{age}")
    public ResponseEntity<List<Employee>> getByAge(@PathVariable(value="age") int age ){
        return  new ResponseEntity<List<Employee>>(employeeService.getByAge(age), HttpStatus.OK);
    }

    @DeleteMapping("/employees/{id}")
    public ResponseEntity deleteById(@PathVariable(value= "id") int id){
        employeeService.deleteEmployee(id);
        return ResponseEntity.ok().build();
    }

    @PostMapping("/emlpoyees")
    public ResponseEntity<Employee> createEmployee (@PathVariable (value ="id") int id, @RequestBody Employee employeeDetails){
        Employee e= employeeService.getById(id);
        e.setEmployee_age(employeeDetails.getEmployee_age());
        e.setEmployee_name(employeeDetails.getEmployee_name());
        e.setEmployee_salary(employeeDetails.getEmployee_salary());
        e.setId(employeeDetails.getId());
        employeeService.save(e);
        return ResponseEntity.ok().body(e);

    }






}

