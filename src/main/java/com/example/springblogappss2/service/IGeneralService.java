package com.example.springblogappss2.service;

import com.example.springblogappss2.model.Categories;

import java.util.List;
import java.util.Optional;

public interface IGeneralService<T> {
    Iterable<T> findAll();

    Optional<T> findById(Long id);
    void save(T t);
    void remove(Long id);
}
