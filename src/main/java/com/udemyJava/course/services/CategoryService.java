package com.udemyJava.course.services;

import com.udemyJava.course.entities.Category;
import com.udemyJava.course.repositories.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryService {
    @Autowired
    private final CategoryRepository categoryRepository;

    public CategoryService(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    public List<Category> getAllCategories(){
        return categoryRepository.findAll();
    }
    public Category getCategoryById(Long id){
        return categoryRepository.findById(id).get();
    }
    public Category saveCategory(Category category){
        return categoryRepository.save(category);
    }
    public void deleteCategory(Long id){
         categoryRepository.deleteById(id);
    }
}
