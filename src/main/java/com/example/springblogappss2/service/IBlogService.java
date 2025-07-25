package com.example.springblogappss2.service;

import com.example.springblogappss2.model.Blog;
import com.example.springblogappss2.model.Categories;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface IBlogService extends IGeneralService<Blog> {
    // Tìm kiếm với phân trang
    Page<Blog> findAll(Pageable pageable);
    
    // Tìm kiếm theo tiêu đề
    Page<Blog> findAllByTitleContaining(String title, Pageable pageable);
    
    // Tìm kiếm theo nội dung
    Page<Blog> findAllByContentContaining(String content, Pageable pageable);
    
    // Tìm kiếm theo tiêu đề hoặc nội dung
    Page<Blog> findAllByTitleContainingOrContentContaining(String keyword, Pageable pageable);
    
    // Tìm kiếm theo danh mục
    Page<Blog> findAllByCategories(Categories categories, Pageable pageable);
    
    // Tìm kiếm theo danh mục và tiêu đề
    Page<Blog> findAllByCategoriesAndTitleContaining(Categories categories, String title, Pageable pageable);
}
