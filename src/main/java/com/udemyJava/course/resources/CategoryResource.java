package com.udemyJava.course.resources;

import com.udemyJava.course.entities.Category;
import com.udemyJava.course.services.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/categories")
public class CategoryResource {
    @Autowired
    private final CategoryService categoryService;

    public CategoryResource(CategoryService categoryService) {
        this.categoryService = categoryService;
    }

    @GetMapping
    public ResponseEntity<List<Category>> findAll(){
        List<Category> list = categoryService.getAllCategories();
        return ResponseEntity.ok().body(list);
    }
    @GetMapping("/{id}")
    public ResponseEntity<Category> findById(@PathVariable Long id){
        Category obj = categoryService.getCategoryById(id);
        return ResponseEntity.ok().body(obj);
    }

    @PostMapping
    public ResponseEntity<Category> saveCategory(@RequestBody Category category){
        Category obj = categoryService.saveCategory(category);
        return ResponseEntity.ok().body(obj);
    }
}
