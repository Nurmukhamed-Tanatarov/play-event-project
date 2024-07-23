package com.micro.pe.macservice.service;

import com.micro.pe.macservice.entity.Category;
import com.micro.pe.macservice.repository.CategoryRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryService {

    @Autowired
    private CategoryRepository categoryRepository;

    public Category createCategory(Category category) {
        return categoryRepository.save(category);
    }

    public Category getCategoryById(int id) {
        return categoryRepository.findById(id).orElseThrow( () -> new EntityNotFoundException("Category not found") );
    }

    public List<Category> getAllCategories() {
        return categoryRepository.findAll();
    }

    public Category updateCategory(int id, Category category) {
        Category existingCategory = categoryRepository.findById(id).orElseThrow( () -> new EntityNotFoundException("Category not found") );
        existingCategory.setCategory_title(category.getCategory_title());
        existingCategory.setCategory_type(category.getCategory_type());
        return categoryRepository.save(existingCategory);
    }

    public void deleteCategoryById(int id) {
        categoryRepository.deleteById(id);
    }
}
