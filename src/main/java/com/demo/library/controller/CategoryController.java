package com.demo.library.controller;

import com.demo.library.entity.Category;
import com.demo.library.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/categories")
public class CategoryController {

    @Autowired
    private CategoryRepository categoryRepository;

    @PostMapping()
    public Category create(@RequestBody Category zipcode) {
        return categoryRepository.save(zipcode);
    }

    @GetMapping()
    public List<Category> getAll(){
        Iterable<Category> all = categoryRepository.findAll();
        List<Category> result = new ArrayList<>();
        all.iterator().forEachRemaining(result::add);
        return result;
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        Optional<Category> byId = categoryRepository.findById(id);
        categoryRepository.delete(byId.get());
    }
}