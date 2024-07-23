package com.micro.pe.iac.service;

import com.micro.pe.iac.dto.RentRulesDTO;
import com.micro.pe.iac.dto.ResponseRentRulesDTO;
import com.micro.pe.iac.entity.RentRules;
import com.micro.pe.iac.repository.RRulesRepository;
import jakarta.ws.rs.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class RRulesService {

    @Autowired
    private RRulesRepository rRulesRepository;

    public ResponseRentRulesDTO createRentRules(RentRulesDTO rentRulesDTO) {
        RentRules rentRules = new RentRules();
        rentRules.setDescription(rentRulesDTO.getDescription());
        RentRules savedRentRules = rRulesRepository.save(rentRules);
        return new ResponseRentRulesDTO(savedRentRules.getId(), savedRentRules.getDescription());
    }

    public ResponseRentRulesDTO findRulesByID(int id) {
        RentRules rentRules = rRulesRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("RentRules not found"));
        return new ResponseRentRulesDTO(rentRules.getId(), rentRules.getDescription());
    }

    public List<ResponseRentRulesDTO> findAllRentRules() {
        List<RentRules> rentRules = rRulesRepository.findAll();
        return rentRules.stream()
                .map(rentRules1 -> new ResponseRentRulesDTO(rentRules1.getId(), rentRules1.getDescription()))
                .collect(Collectors.toList());
    }

    public ResponseRentRulesDTO updateRentRules(int id, RentRulesDTO rentRulesDTO) {
        RentRules existingRR = rRulesRepository.findById(id).orElseThrow(() -> new NotFoundException("RentRules not found"));
        existingRR.setDescription(rentRulesDTO.getDescription());
        RentRules updatedRR = rRulesRepository.save(existingRR);
        return new ResponseRentRulesDTO(updatedRR.getId(), updatedRR.getDescription());
    }

    public void deleteRentRules(int id) {
        try {
            rRulesRepository.deleteById(id);
        } catch (Exception e) {
            throw new NotFoundException("RentRules not found");
        }
    }
}
