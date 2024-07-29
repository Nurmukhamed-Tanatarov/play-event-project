package com.micro.pe.macservice.service;

import com.micro.pe.macservice.dto.CategoryDTO;
import com.micro.pe.macservice.dto.ResponseCategoryDTO;
import com.micro.pe.macservice.entity.Category;
import com.micro.pe.macservice.entity.GameList;
import com.micro.pe.macservice.repository.CategoryRepository;
import com.micro.pe.macservice.repository.GameListRepository;
import com.micro.pe.macservice.repository.GameRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class CategoryService {

    @Autowired
    private CategoryRepository categoryRepository;

    @Autowired
    private GameListRepository gameListRepository;

    public ResponseCategoryDTO createCategory(CategoryDTO categoryDTO) {
        Category category = new Category();
        category.setCategory_title(categoryDTO.getCategory_title());
        category.setCategory_type(categoryDTO.getCategory_type());
        Category savedCategory = categoryRepository.save(category);

        GameList gameList = new GameList();
        gameList.setCategoryId(savedCategory.getId());
        gameListRepository.save(gameList);

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
