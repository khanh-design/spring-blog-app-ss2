package com.example.springblogappss2.controller.rest;

import com.example.springblogappss2.model.Categories;
import com.example.springblogappss2.service.ICategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/categories")
public class RestCategoryController {
    @Autowired
    private ICategoryService iCategoryService;

    @GetMapping("")
    public ResponseEntity<Iterable<Categories>> findAllCustomer() {
        List<Categories> categories = (List<Categories>) iCategoryService.findAll();

        if (categories.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(categories, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Categories> findById(@PathVariable Long id) {
        Optional<Categories> categories = iCategoryService.findById(id);
        if (!categories.isPresent()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(categories.get(), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Categories> save(@RequestBody Categories categories) {
        iCategoryService.save(categories);
        return new ResponseEntity<>(categories, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Categories> update(@PathVariable Long id, @RequestBody Categories categories) {
        Optional<Categories> categoriesOptional = iCategoryService.findById(id);
        if (!categoriesOptional.isPresent()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        categories.setId(categoriesOptional.get().getId());
        iCategoryService.save(categories);
        return new ResponseEntity<>(categories, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Categories> delete(@PathVariable Long id) {
        Optional<Categories> categoriesOptional = iCategoryService.findById(id);
        if (!categoriesOptional.isPresent()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        iCategoryService.remove(id);
        return new ResponseEntity<>(categoriesOptional.get(), HttpStatus.OK);
    }
}
