package com.micro.pe.macservice.service;

import com.micro.pe.macservice.dto.GameRRDTO;
import com.micro.pe.macservice.dto.ResponseGameRRDTO;
import com.micro.pe.macservice.entity.GameRentRules;
import com.micro.pe.macservice.repository.GameRRRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class GameRRService {

    @Autowired
    private GameRRRepository gameRRRepository;

    public ResponseGameRRDTO createGameRR(GameRRDTO gameRRDTO) {
        GameRentRules gameRentRules = new GameRentRules();
        gameRentRules.setGameId(gameRRDTO.getGameId());
        gameRentRules.setRentRulesId(gameRRDTO.getRentRulesId());
        gameRentRules.setDescription(gameRRDTO.getDescription());
        GameRentRules savedGameRentRules = gameRRRepository.save(gameRentRules);
        return new ResponseGameRRDTO(savedGameRentRules.getId(),savedGameRentRules.getGameId(), savedGameRentRules.getRentRulesId(), savedGameRentRules.getDescription());
    }

    public ResponseGameRRDTO getGameRRByID(int id) {
        GameRentRules gameRentRules = gameRRRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Not found!"));
        return new ResponseGameRRDTO(
                gameRentRules.getId(),
                gameRentRules.getGameId(),
                gameRentRules.getRentRulesId(),
                gameRentRules.getDescription());
    }

    public List<ResponseGameRRDTO> getAll(){
        List<GameRentRules> gameRentRules = gameRRRepository.findAll();
        return gameRentRules.stream()
                .map(gameRR -> new ResponseGameRRDTO(
                        gameRR.getId(),
                        gameRR.getGameId(),
                        gameRR.getRentRulesId(),
                        gameRR.getDescription()
                ))
                .collect(Collectors.toList());
    }

    public ResponseGameRRDTO updateGameRR(int id, GameRRDTO gameRRDTO) {
        GameRentRules updatedGameRentRules = gameRRRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("Not found!"));
        updatedGameRentRules.setGameId(gameRRDTO.getGameId());
        updatedGameRentRules.setRentRulesId(gameRRDTO.getRentRulesId());
        updatedGameRentRules.setDescription(gameRRDTO.getDescription());
        GameRentRules savedGameRentRules = gameRRRepository.save(updatedGameRentRules);
        return new ResponseGameRRDTO(
                savedGameRentRules.getId(),
                savedGameRentRules.getGameId(),
                savedGameRentRules.getRentRulesId(),
                savedGameRentRules.getDescription()
        );
    }

    public void deleteGameRR(int id) {
        gameRRRepository.deleteById(id);
    }

}
