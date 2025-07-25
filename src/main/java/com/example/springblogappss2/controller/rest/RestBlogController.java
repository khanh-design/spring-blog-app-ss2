package com.example.springblogappss2.controller.rest;

import com.example.springblogappss2.model.Blog;
import com.example.springblogappss2.model.Categories;
import com.example.springblogappss2.service.IBlogService;
import com.example.springblogappss2.service.ICategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping("/api/blogs")
public class RestBlogController {
    @Autowired
    private IBlogService blogService;
    
    @Autowired
    private ICategoryService categoryService;

    @GetMapping("/search")
    public ResponseEntity<Map<String, Object>> searchBlogs(
            @RequestParam(value = "keyword", required = false) String keyword,
            @RequestParam(value = "categoryId", required = false) Long categoryId,
            @RequestParam(value = "page", defaultValue = "0") int page,
            @RequestParam(value = "size", defaultValue = "2") int size) {
        
        try {
            Pageable pageable = PageRequest.of(page, size);
            Page<Blog> blogs;
            
            if (keyword != null && !keyword.trim().isEmpty()) {
                if (categoryId != null) {
                    // Tìm kiếm theo từ khóa và danh mục
                    Optional<Categories> categoryOpt = categoryService.findById(categoryId);
                    if (categoryOpt.isPresent()) {
                        blogs = blogService.findAllByCategoriesAndTitleContaining(categoryOpt.get(), keyword, pageable);
                    } else {
                        blogs = blogService.findAllByTitleContainingOrContentContaining(keyword, pageable);
                    }
                } else {
                    // Tìm kiếm chỉ theo từ khóa
                    blogs = blogService.findAllByTitleContainingOrContentContaining(keyword, pageable);
                }
            } else if (categoryId != null) {
                // Tìm kiếm chỉ theo danh mục
                Optional<Categories> categoryOpt = categoryService.findById(categoryId);
                if (categoryOpt.isPresent()) {
                    blogs = blogService.findAllByCategories(categoryOpt.get(), pageable);
                } else {
                    blogs = blogService.findAll(pageable);
                }
            } else {
                // Hiển thị tất cả
                blogs = blogService.findAll(pageable);
            }
            
            Map<String, Object> response = new HashMap<>();
            response.put("blogs", blogs.getContent());
            response.put("currentPage", blogs.getNumber());
            response.put("totalPages", blogs.getTotalPages());
            response.put("totalElements", blogs.getTotalElements());
            response.put("hasNext", blogs.hasNext());
            response.put("hasPrevious", blogs.hasPrevious());
            response.put("keyword", keyword);
            response.put("categoryId", categoryId);
            
            return new ResponseEntity<>(response, HttpStatus.OK);
            
        } catch (Exception e) {
            Map<String, Object> errorResponse = new HashMap<>();
            errorResponse.put("error", "Có lỗi xảy ra: " + e.getMessage());
            return new ResponseEntity<>(errorResponse, HttpStatus.BAD_REQUEST);
        }
    }
    
    @GetMapping("/categories")
    public ResponseEntity<Iterable<Categories>> getAllCategories() {
        try {
            Iterable<Categories> categories = categoryService.findAll();
            return new ResponseEntity<>(categories, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }
    
    @GetMapping("/{id}")
    public ResponseEntity<Blog> getBlogById(@PathVariable Long id) {
        try {
            Optional<Blog> blog = blogService.findById(id);
            if (blog.isPresent()) {
                return new ResponseEntity<>(blog.get(), HttpStatus.OK);
            } else {
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            }
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }
}
