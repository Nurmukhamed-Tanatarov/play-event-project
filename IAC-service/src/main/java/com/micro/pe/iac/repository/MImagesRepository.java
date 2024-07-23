package com.micro.pe.iac.repository;

import com.micro.pe.iac.entity.MImages;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface MImagesRepository extends JpaRepository<MImages, Integer> {
    Optional<MImages> findById(Integer id);
}
