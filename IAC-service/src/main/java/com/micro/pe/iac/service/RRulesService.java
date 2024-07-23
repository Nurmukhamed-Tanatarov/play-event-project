package com.micro.pe.iac.service;

import com.micro.pe.iac.entity.RentRules;
import com.micro.pe.iac.repository.RRulesRepository;
import jakarta.ws.rs.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class RRulesService {

    @Autowired
    private RRulesRepository rRulesRepository;

    public RentRules createRentRules(RentRules rentRules) {
        return rRulesRepository.save(rentRules);
    }

    public RentRules findRulesByID(int id) {
        return rRulesRepository.findById(id).orElseThrow(() -> new NotFoundException("RentRules not found"));
    }

    public List<RentRules> findAllRentRules() {
        return rRulesRepository.findAll();
    }

    public RentRules updateRentRules(int id, RentRules rentRules) {
        RentRules rules = rRulesRepository.findById(id).orElseThrow(() -> new NotFoundException("Rent Rules Not Found"));
        rules.setDescription(rentRules.getDescription());
        return rRulesRepository.save(rules);
    }

    public void deleteRentRules(int id) {
        rRulesRepository.deleteById(id);
    }
}
