package com.micro.pe.macservice.controller;

import com.micro.pe.macservice.dto.CategoryDTO;
import com.micro.pe.macservice.dto.ResponseCategoryDTO;
import com.micro.pe.macservice.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("api/s3/category")
public class CategoryController {

    @Autowired
    private CategoryService categoryService;

    @PostMapping("/create-category")
    public ResponseEntity<ResponseCategoryDTO> addCategory(@RequestBody CategoryDTO categoryDTO) {
        ResponseCategoryDTO createdCategory = categoryService.createCategory(categoryDTO);
        return new ResponseEntity<>(createdCategory, HttpStatus.CREATED);
    }

    @GetMapping("/getAllCategory")
    public ResponseEntity<List<ResponseCategoryDTO>> getAllCategory() {
        List<ResponseCategoryDTO> categories = categoryService.getAllCategories();
        return new ResponseEntity<>(categories, HttpStatus.OK);
    }

    @GetMapping("/getCategoryByID/{id}")
    public ResponseEntity<ResponseCategoryDTO> getCategoryByID(@PathVariable("id") int id) {
        ResponseCategoryDTO category = categoryService.getCategoryById(id);
        return new ResponseEntity<>(category, HttpStatus.OK);
    }

    @PutMapping("/updateCategory/{id}")
    public ResponseEntity<ResponseCategoryDTO> updateCategory(@PathVariable("id") int id, @RequestBody CategoryDTO categoryDTO) {
        ResponseCategoryDTO updatedCategory = categoryService.updateCategory(id, categoryDTO);
        return new ResponseEntity<>(updatedCategory, HttpStatus.OK);
    }

    @DeleteMapping("/deleteCategory/{id}")
    public ResponseEntity<Void> deleteCategory(@PathVariable("id") int id) {
        categoryService.deleteCategoryById(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
