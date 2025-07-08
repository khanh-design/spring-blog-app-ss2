package com.example.springblogappss2.service.impl;

import com.example.springblogappss2.model.Categories;
import com.example.springblogappss2.repository.ICategoryRepository;
import com.example.springblogappss2.service.ICategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CategoriesService implements ICategoryService {
    @Autowired
    private ICategoryRepository categoryRepository;


    @Override
    public Iterable<Categories> findAll() {
        return categoryRepository.findAll();
    }

    @Override
    public Optional<Categories> findById(Long id) {
        return categoryRepository.findById(id);
    }

    @Override
    public void save(Categories categories) {
        categoryRepository.save(categories);
    }

    @Override
    public void remove(Long id) {
        categoryRepository.deleteById(id);
    }
}
