package com.micro.pe.iac.repository;

import com.micro.pe.iac.entity.Contacts;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ContactsRepository extends JpaRepository<Contacts, Integer> {

    @Override
    Optional<Contacts> findById(Integer id);

}
