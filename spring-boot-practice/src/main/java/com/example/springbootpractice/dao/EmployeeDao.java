package com.example.springbootpractice.dao;

import com.example.springbootpractice.entity.Employee;
import org.springframework.stereotype.Repository;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Repository
public class EmployeeDao implements BaseDao<Employee> {
    private List<Employee> em= new ArrayList<>();

    @Override
    public Employee get(int id) {
        return  em.get(id);
    }

    public List<Employee> getAll() {
        return em;
    }

    public void save(Employee employee) {
        em.add(employee);
    }

    @Override
    public void delete(int id) {
        em.remove(id);

    }
}
