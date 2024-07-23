package com.micro.pe.macservice.repository;

import com.micro.pe.macservice.entity.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Integer> {
    @Override
    Optional<Category> findById(Integer id);
}
