package com.micro.pe.iac.controller;

import com.micro.pe.iac.dto.RentRulesDTO;
import com.micro.pe.iac.dto.ResponseRentRulesDTO;
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
    public ResponseEntity<ResponseRentRulesDTO> saveRules(@RequestBody RentRulesDTO rulesDTO) {
        ResponseRentRulesDTO createdResponseRRDTO = rulesService.createRentRules(rulesDTO);
        return new ResponseEntity<>(createdResponseRRDTO, HttpStatus.CREATED);
    }

    @GetMapping("/getAll-rules")
    public ResponseEntity<List<ResponseRentRulesDTO>> getRules() {
        List<ResponseRentRulesDTO> responseRentRulesDTO = rulesService.findAllRentRules();
        return new ResponseEntity<>(responseRentRulesDTO, HttpStatus.OK);
    }

    @GetMapping("/getRule/{id}")
    public ResponseEntity<ResponseRentRulesDTO> getRuleById(@PathVariable("id") int id) {
        ResponseRentRulesDTO responserentRulesDTO = rulesService.findRulesByID(id);
        return new ResponseEntity<>(responserentRulesDTO, HttpStatus.OK);
    }

    @PutMapping("/updateRule/{id}")
    public ResponseEntity<ResponseRentRulesDTO> updateRule(@PathVariable("id") int id, @RequestBody RentRulesDTO rulesDTO) {
        ResponseRentRulesDTO updatedRulesDTO = rulesService.updateRentRules(id, rulesDTO);
        return new ResponseEntity<>(updatedRulesDTO, HttpStatus.OK);
    }

    @DeleteMapping("/deleteRule/{id}")
    public ResponseEntity<RentRules> deleteRule(@PathVariable("id") int id) {
        rulesService.deleteRentRules(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

}
