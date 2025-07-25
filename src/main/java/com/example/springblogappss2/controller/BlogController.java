package com.example.springblogappss2.controller;

import com.example.springblogappss2.model.Blog;
import com.example.springblogappss2.model.Categories;
import com.example.springblogappss2.service.IBlogService;
import com.example.springblogappss2.service.ICategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.Optional;

@Controller
@RequestMapping("/blogs")
public class BlogController {
    @Autowired
    private IBlogService blogService;

    @Autowired
    private ICategoryService categoryService;

    @ModelAttribute("categories")
    public Iterable<Categories> listProvinces() {
        return categoryService.findAll();
    }

    // Trang chủ với AJAX
    @GetMapping("")
    public String home(Model model) {
        // Load categories để hiển thị trong dropdown
        model.addAttribute("categories", categoryService.findAll());
        return "/blog/home";
    }

    @GetMapping("/create")
    public ModelAndView create() {
        ModelAndView mav = new ModelAndView("/blog/create");
        mav.addObject("blog", new Blog());
        return mav;
    }

    @PostMapping("/create")
    public String create(@ModelAttribute Blog blog) {
        blogService.save(blog);
        return "redirect:/blogs";
    }

    @GetMapping("/edit/{id}")
    public String edit(@PathVariable Long id, Model model) {
        Optional<Blog> BlogOptional = blogService.findById(id);
        if (BlogOptional.isPresent()) {
            model.addAttribute("blogsList", BlogOptional.get());
            return "/blog/edit";
        }
        return "/error_404";
    }

    @PostMapping("/edit")
    public String edit(@ModelAttribute Blog blog) {
        blogService.save(blog);
        return "redirect:/blogs";
    }

    @RequestMapping("/delete/{id}")
    public String delete(@PathVariable Long id) {
        blogService.remove(id);
        return "redirect:/blogs";
    }

    @GetMapping("/view/{id}")
    public String view(@PathVariable Long id, Model model) {
        Optional<Blog> BlogOptional = blogService.findById(id);
        if (BlogOptional.isPresent()) {
            model.addAttribute("blog", BlogOptional.get());
            return "/blog/view";
        }
        return "/error_404";
    }
}
