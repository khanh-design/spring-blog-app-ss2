package com.example.springblogappss2.repository;

import com.example.springblogappss2.model.Categories;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ICategoryRepository extends JpaRepository<Categories, Long> {
}
