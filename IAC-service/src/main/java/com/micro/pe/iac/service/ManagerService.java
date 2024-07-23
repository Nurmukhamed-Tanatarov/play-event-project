package com.micro.pe.iac.service;

import com.micro.pe.iac.entity.Manager;
import com.micro.pe.iac.repository.ManagerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@Service
public class ManagerService {

    @Autowired
    private ManagerRepository managerRepository;

    public Manager createManager(Manager manager){
        return managerRepository.save(manager);
    }

    public List<Manager> getAllManagers(){
        return managerRepository.findAll();
    }

    public Manager getManagerById(int id){
        return managerRepository.findById(id).orElseThrow( () -> new RuntimeException("Manager not found"));
    }

    public Manager updateManager(int id, Manager newManagerData) {
        Manager existingManager = managerRepository.findById(id).orElseThrow(() -> new NoSuchElementException("Manager with id " + id + " not found"));
        existingManager.setFirst_name(newManagerData.getFirst_name());
        existingManager.setLast_name(newManagerData.getLast_name());
        existingManager.setPatronymic(newManagerData.getPatronymic());
        return managerRepository.save(existingManager);
    }


    public void deleteManager(int id){
        try {
            managerRepository.deleteById(id);
        }
        catch (Exception e){
            throw new IllegalArgumentException("Manager with id " + id + " does not exist");
        }
    }

}
