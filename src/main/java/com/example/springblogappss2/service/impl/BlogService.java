package com.example.springblogappss2.service.impl;

import com.example.springblogappss2.model.Blog;
import com.example.springblogappss2.model.Categories;
import com.example.springblogappss2.repository.IBlogRepository;
import com.example.springblogappss2.service.IBlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class BlogService implements IBlogService {
    @Autowired
    private IBlogRepository iBlogRepository;

    @Override
    public Iterable<Blog> findAll() {
        return iBlogRepository.findAll();
    }

    @Override
    public Optional<Blog> findById(Long id) {
        return iBlogRepository.findById(id);
    }

    @Override
    public void save(Blog blog) {
        iBlogRepository.save(blog);
    }

    @Override
    public void remove(Long id) {
        iBlogRepository.deleteById(id);
    }

    @Override
    public Page<Blog> findAll(Pageable pageable) {
        return iBlogRepository.findAll(pageable);
    }

    @Override
    public Page<Blog> findAllByTitleContaining(String title, Pageable pageable) {
        return iBlogRepository.findAllByTitleContaining(title, pageable);
    }

    @Override
    public Page<Blog> findAllByContentContaining(String content, Pageable pageable) {
        return iBlogRepository.findAllByContentContaining(content, pageable);
    }

    @Override
    public Page<Blog> findAllByTitleContainingOrContentContaining(String keyword, Pageable pageable) {
        return iBlogRepository.findAllByTitleContainingOrContentContaining(keyword, keyword, pageable);
    }

    @Override
    public Page<Blog> findAllByCategories(Categories categories, Pageable pageable) {
        return iBlogRepository.findAllByCategories(categories, pageable);
    }

    @Override
    public Page<Blog> findAllByCategoriesAndTitleContaining(Categories categories, String title, Pageable pageable) {
        return iBlogRepository.findAllByCategoriesAndTitleContaining(categories, title, pageable);
    }
}
