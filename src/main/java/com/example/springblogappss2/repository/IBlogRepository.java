package com.example.springblogappss2.repository;

import com.example.springblogappss2.model.Blog;
import com.example.springblogappss2.model.Categories;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IBlogRepository extends JpaRepository<Blog, Long> {
    // Tìm kiếm blog theo tiêu đề chứa từ khóa
    Page<Blog> findAllByTitleContaining(String title, Pageable pageable);
    
    // Tìm kiếm blog theo nội dung chứa từ khóa
    Page<Blog> findAllByContentContaining(String content, Pageable pageable);
    
    // Tìm kiếm blog theo tiêu đề hoặc nội dung chứa từ khóa
    Page<Blog> findAllByTitleContainingOrContentContaining(String title, String content, Pageable pageable);
    
    // Tìm kiếm blog theo danh mục
    Page<Blog> findAllByCategories(Categories categories, Pageable pageable);
    
    // Tìm kiếm blog theo danh mục và tiêu đề
    Page<Blog> findAllByCategoriesAndTitleContaining(Categories categories, String title, Pageable pageable);
}
