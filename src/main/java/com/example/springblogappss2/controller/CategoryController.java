package com.example.springblogappss2.controller;

import com.example.springblogappss2.model.Categories;
import com.example.springblogappss2.service.impl.CategoriesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@Controller
@RequestMapping("/categories")
public class CategoryController {
    @Autowired
    private CategoriesService categoriesService;

    @GetMapping("")
    public String index(Model model) {
        model.addAttribute("categories", categoriesService.findAll());
        return "/category/index";
    }

    @GetMapping("/create")
    public String create(Model model) {
        model.addAttribute("categories", new Categories());
        return "/category/create";
    }

    @PostMapping("/create")
    public String create(@ModelAttribute("categories") Categories categories) {
        categoriesService.save(categories);
        return "redirect:/categories";
    }

    @GetMapping("/edit/{id}")
    public String edit(@PathVariable("id") Long id, Model model) {
        Optional<Categories> categories = categoriesService.findById(id);
        model.addAttribute("categories", categories.get());
        return "/category/edit";
    }

    @PostMapping("/edit")
    public String edit(@ModelAttribute("categories") Categories categories) {
        categoriesService.save(categories);
        return "redirect:/categories";
    }

    @RequestMapping("/delete/{id}")
    public String delete(@PathVariable Long id) {
        categoriesService.remove(id);
        return "redirect:/categories";
    }
}
