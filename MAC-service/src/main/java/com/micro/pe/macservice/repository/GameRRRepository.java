package com.micro.pe.macservice.repository;

import com.micro.pe.macservice.entity.GameRentRules;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GameRRRepository extends JpaRepository<GameRentRules, Integer> {

}
