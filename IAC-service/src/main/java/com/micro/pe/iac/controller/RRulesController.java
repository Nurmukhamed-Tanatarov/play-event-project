package com.micro.pe.iac.controller;

import com.micro.pe.iac.entity.RentRules;
import com.micro.pe.iac.service.RRulesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("api/s2/rentrules")
public class RRulesController {

    @Autowired
    private RRulesService rulesService;

    @PostMapping("/create-rule")
    public ResponseEntity<RentRules> saveRules(@RequestBody RentRules rules) {
        RentRules savedRules = rulesService.createRentRules(rules);
        return new ResponseEntity<>(savedRules, HttpStatus.CREATED);
    }

    @GetMapping("/getAll-rules")
    public ResponseEntity<List<RentRules>> getRules() {
        List<RentRules> rules = rulesService.findAllRentRules();
        return new ResponseEntity<>(rules, HttpStatus.OK);
    }

    @GetMapping("/getRule/{id}")
    public ResponseEntity<RentRules> getRuleById(@PathVariable("id") int id) {
        RentRules rentRules = rulesService.findRulesByID(id);
        return new ResponseEntity<>(rentRules, HttpStatus.OK);
    }

    @PutMapping("/updateRule/{id}")
    public ResponseEntity<RentRules> updateRule(@PathVariable("id") int id, @RequestBody RentRules rules) {
        RentRules updatedRules = rulesService.updateRentRules(id, rules);
        return new ResponseEntity<>(updatedRules, HttpStatus.OK);
    }

    @DeleteMapping("/deleteRule/{id}")
    public ResponseEntity<RentRules> deleteRule(@PathVariable("id") int id) {
        rulesService.deleteRentRules(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

}
