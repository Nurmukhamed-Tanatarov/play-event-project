package com.micro.pe.iac.repository;

import com.micro.pe.iac.entity.RentRules;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RRulesRepository extends JpaRepository<RentRules, Integer> {

}
