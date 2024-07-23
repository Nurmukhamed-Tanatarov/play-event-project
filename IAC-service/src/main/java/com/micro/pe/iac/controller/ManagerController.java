package com.micro.pe.iac.controller;

import com.micro.pe.iac.dto.ManagerDTO;
import com.micro.pe.iac.dto.ResponseManagerDTO;
import com.micro.pe.iac.service.ManagerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/s2/manager")
public class ManagerController {

    @Autowired
    private ManagerService managerService;

    @PostMapping("/create")
    public ResponseEntity<ResponseManagerDTO> createManager(@RequestBody ManagerDTO managerDTO) {
        ResponseManagerDTO createdManager = managerService.createManager(managerDTO);
        return new ResponseEntity<>(createdManager, HttpStatus.CREATED);
    }

    @GetMapping("/getAll")
    public ResponseEntity<List<ResponseManagerDTO>> getAllManager() {
        List<ResponseManagerDTO> managers = managerService.getAllManagers();
        return new ResponseEntity<>(managers, HttpStatus.OK);
    }

    @GetMapping("/get/{id}")
    public ResponseEntity<ResponseManagerDTO> getManagerById(@PathVariable("id") int id) {
        ResponseManagerDTO manager = managerService.getManagerById(id);
        return new ResponseEntity<>(manager, HttpStatus.OK);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<ResponseManagerDTO> updateManager(@PathVariable("id") int id, @RequestBody ManagerDTO managerDTO) {
        ResponseManagerDTO updatedManager = managerService.updateManager(id, managerDTO);
        return new ResponseEntity<>(updatedManager, HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> deleteManager(@PathVariable("id") int id) {
        managerService.deleteManager(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
