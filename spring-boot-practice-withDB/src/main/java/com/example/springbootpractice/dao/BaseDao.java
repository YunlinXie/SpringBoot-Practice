package com.example.springbootpractice.dao;

import java.util.List;
import java.util.Optional;

public interface BaseDao<T> {

    T get(int id);

    List<T> getAll();

    void save(T t);

    void delete(int id);
}
