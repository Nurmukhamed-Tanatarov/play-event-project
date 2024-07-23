package com.micro.pe.iac.repository;

import com.micro.pe.iac.entity.Translations;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TranslationRepository extends JpaRepository<Translations, Integer> {
}
