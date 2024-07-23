package com.micro.pe.macservice.repository;

import com.micro.pe.macservice.entity.Gimages;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface GimagesRepository extends JpaRepository<Gimages, Integer> {

    @Override
    Optional<Gimages> findById(Integer id);
}
