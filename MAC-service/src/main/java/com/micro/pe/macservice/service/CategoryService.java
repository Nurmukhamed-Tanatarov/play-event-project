package com.micro.pe.macservice.service;

import com.micro.pe.macservice.dto.CategoryDTO;
import com.micro.pe.macservice.dto.ResponseCategoryDTO;
import com.micro.pe.macservice.entity.Category;
import com.micro.pe.macservice.repository.CategoryRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class CategoryService {

    @Autowired
    private CategoryRepository categoryRepository;

    public ResponseCategoryDTO createCategory(CategoryDTO categoryDTO) {
        Category category = new Category();
        category.setCategory_title(categoryDTO.getCategory_title());
        category.setCategory_type(categoryDTO.getCategory_type());
        Category savedCategory = categoryRepository.save(category);
        return new ResponseCategoryDTO(savedCategory.getId(), savedCategory.getCategory_title(), savedCategory.getCategory_type());
    }

    public ResponseCategoryDTO getCategoryById(int id) {
        Category category = categoryRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Category not found"));
        return new ResponseCategoryDTO(category.getId(), category.getCategory_title(), category.getCategory_type());
    }

    public List<ResponseCategoryDTO> getAllCategories() {
        List<Category> categories = categoryRepository.findAll();
        return categories.stream()
                .map(category -> new ResponseCategoryDTO(category.getId(), category.getCategory_title(), category.getCategory_type()))
                .collect(Collectors.toList());
    }

    public ResponseCategoryDTO updateCategory(int id, CategoryDTO categoryDTO) {
        Category existingCategory = categoryRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Category not found"));
        existingCategory.setCategory_title(categoryDTO.getCategory_title());
        existingCategory.setCategory_type(categoryDTO.getCategory_type());
        Category updatedCategory = categoryRepository.save(existingCategory);
        return new ResponseCategoryDTO(updatedCategory.getId(), updatedCategory.getCategory_title(), updatedCategory.getCategory_type());
    }

    public void deleteCategoryById(int id) {
        categoryRepository.deleteById(id);
    }
}






//package com.micro.pe.macservice.service;
//
//import com.micro.pe.macservice.entity.Category;
//import com.micro.pe.macservice.repository.CategoryRepository;
//import jakarta.persistence.EntityNotFoundException;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//
//import java.util.List;
//
//@Service
//public class CategoryService {
//
//    @Autowired
//    private CategoryRepository categoryRepository;
//
//    public Category createCategory(Category category) {
//        return categoryRepository.save(category);
//    }
//
//    public Category getCategoryById(int id) {
//        return categoryRepository.findById(id).orElseThrow( () -> new EntityNotFoundException("Category not found") );
//    }
//
//    public List<Category> getAllCategories() {
//        return categoryRepository.findAll();
//    }
//
//    public Category updateCategory(int id, Category category) {
//        Category existingCategory = categoryRepository.findById(id).orElseThrow( () -> new EntityNotFoundException("Category not found") );
//        existingCategory.setCategory_title(category.getCategory_title());
//        existingCategory.setCategory_type(category.getCategory_type());
//        return categoryRepository.save(existingCategory);
//    }
//
//    public void deleteCategoryById(int id) {
//        categoryRepository.deleteById(id);
//    }
//}
