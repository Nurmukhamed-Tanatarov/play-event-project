package com.micro.pe.iac.controller;

import com.micro.pe.iac.entity.Manager;
import com.micro.pe.iac.service.ManagerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("api/s2/manager")
public class ManagerController {

    @Autowired
    private ManagerService managerService;

    @PostMapping("/create")
    public ResponseEntity<Manager> createManager(@RequestBody Manager manager){
        Manager createdManager = managerService.createManager(manager);
        return new ResponseEntity<>(createdManager, HttpStatus.CREATED);
    }

    @GetMapping("/getAll")
    public ResponseEntity<List<Manager>> getAllManager(){
        List<Manager> managers = managerService.getAllManagers();
        return new ResponseEntity<>(managers, HttpStatus.OK);
    }

    @GetMapping("/get/{id}")
    public ResponseEntity<Manager> getManagerById(@PathVariable("id") int id){
        Manager manager = managerService.getManagerById(id);
        return new ResponseEntity<>(manager, HttpStatus.OK);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<Manager> updateManager(@PathVariable("id") int id, @RequestBody Manager newManagerData) {
        Manager updatedManager = managerService.updateManager(id, newManagerData);
        return new ResponseEntity<>(updatedManager, HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Manager> deleteManager(@PathVariable("id") int id){
        managerService.deleteManager(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

}
