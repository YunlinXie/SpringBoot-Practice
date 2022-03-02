package com.example.springbootpractice.service;


import com.example.springbootpractice.dao.EmployeeDao;
import com.example.springbootpractice.entity.Employee;
import org.springframework.web.client.RestTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class EmployeeService {
    @Autowired
    RestTemplate restTemplate;
    @Autowired
    EmployeeDao employeeDao;


    public Employee getAll() {
        String uri = "http://dummy.restapiexample.com/api/v1/employees";
        Employee result  = restTemplate.getForObject(uri, Employee.class);
        return result ;

    }

    public Employee getById(int id) {
        String uri = "http://dummy.restapiexample.com/api/v1/employees/"+id;
        Employee em= restTemplate.getForObject(uri, Employee.class);
        return em;
    }

    public List<Employee> getByAge(int age) {
        String uri = "http://dummy.restapiexample.com/api/v1/employees";
        List<Employee> result  = (List<Employee>) restTemplate.getForObject(uri, Employee.class);
        return result.stream().filter(c->c.getEmployee_age()>age).collect(Collectors.toList());
    }

    public void addEmployee(Employee employee) {
        employeeDao.save(employee);
    }

    public void deleteEmployee(int id) {
        String uri = "http://dummy.restapiexample.com/api/v1/employees/"+id;
        Employee em= restTemplate.getForObject(uri, Employee.class);

    }

    public void save(Employee employees) {
        employeeDao.save (employees);
    }
}
