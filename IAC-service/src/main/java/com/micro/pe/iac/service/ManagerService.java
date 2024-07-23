package com.micro.pe.iac.service;

import com.micro.pe.iac.dto.ManagerDTO;
import com.micro.pe.iac.dto.ResponseManagerDTO;
import com.micro.pe.iac.entity.Manager;
import com.micro.pe.iac.repository.ManagerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.stream.Collectors;

@Service
public class ManagerService {

    @Autowired
    private ManagerRepository managerRepository;

    public ResponseManagerDTO createManager(ManagerDTO managerDTO) {
        Manager manager = new Manager();
        manager.setFirst_name(managerDTO.getFirst_name());
        manager.setLast_name(managerDTO.getLast_name());
        manager.setPatronymic(managerDTO.getPatronymic());
        Manager savedManager = managerRepository.save(manager);
        return new ResponseManagerDTO(savedManager.getId(), savedManager.getFirst_name(), savedManager.getLast_name(), savedManager.getPatronymic());
    }

    public List<ResponseManagerDTO> getAllManagers() {
        List<Manager> managers = managerRepository.findAll();
        return managers.stream()
                .map(manager -> new ResponseManagerDTO(manager.getId(), manager.getFirst_name(), manager.getLast_name(), manager.getPatronymic()))
                .collect(Collectors.toList());
    }

    public ResponseManagerDTO getManagerById(int id) {
        Manager manager = managerRepository.findById(id)
                .orElseThrow(() -> new NoSuchElementException("Manager not found"));
        return new ResponseManagerDTO(manager.getId(), manager.getFirst_name(), manager.getLast_name(), manager.getPatronymic());
    }

    public ResponseManagerDTO updateManager(int id, ManagerDTO managerDTO) {
        Manager existingManager = managerRepository.findById(id)
                .orElseThrow(() -> new NoSuchElementException("Manager with id " + id + " not found"));
        existingManager.setFirst_name(managerDTO.getFirst_name());
        existingManager.setLast_name(managerDTO.getLast_name());
        existingManager.setPatronymic(managerDTO.getPatronymic());
        Manager updatedManager = managerRepository.save(existingManager);
        return new ResponseManagerDTO(updatedManager.getId(), updatedManager.getFirst_name(), updatedManager.getLast_name(), updatedManager.getPatronymic());
    }

    public void deleteManager(int id) {
        try {
            managerRepository.deleteById(id);
        } catch (Exception e) {
            throw new IllegalArgumentException("Manager with id " + id + " does not exist");
        }
    }
}
