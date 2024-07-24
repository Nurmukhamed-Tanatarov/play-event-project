package com.micro.pe.macservice.controller;

import com.micro.pe.macservice.dto.GameRRDTO;
import com.micro.pe.macservice.dto.ResponseGameRRDTO;
import com.micro.pe.macservice.service.GameRRService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/s3/gameRR")
public class GameRRController {

    @Autowired
    private GameRRService gameRRService;

    @PostMapping("/create-gameRR")
    public ResponseEntity<ResponseGameRRDTO> createGameRR(@RequestBody GameRRDTO gameRRDTO) {
        ResponseGameRRDTO responseGameRRDTO = gameRRService.createGameRR(gameRRDTO);
        return new ResponseEntity<>(responseGameRRDTO, HttpStatus.CREATED);
    }

    @GetMapping("/getGameRR/{id}")
    public ResponseEntity<ResponseGameRRDTO> getGameRR(@PathVariable("id") int id) {
        ResponseGameRRDTO responseGameRRDTO = gameRRService.getGameRRByID(id);
        return new ResponseEntity<>(responseGameRRDTO, HttpStatus.OK);
    }

    @GetMapping("/getAllGameRR")
    public ResponseEntity<List<ResponseGameRRDTO>> getAllGameRR() {
        List<ResponseGameRRDTO> responseGameRRDTO = gameRRService.getAll();
        return new ResponseEntity<>(responseGameRRDTO, HttpStatus.OK);
    }

    @PutMapping("/updateGameRR/{id}")
    public ResponseEntity<ResponseGameRRDTO> updateGameRR(@PathVariable("id") int id, @RequestBody GameRRDTO gameRRDTO) {
        ResponseGameRRDTO responseGameRRDTO = gameRRService.updateGameRR(id, gameRRDTO);
        return new ResponseEntity<>(responseGameRRDTO, HttpStatus.OK);
    }

    @DeleteMapping("/deleteGameRR/{id}")
    public ResponseEntity<ResponseGameRRDTO> deleteGameRR(@PathVariable("id") int id) {
        gameRRService.deleteGameRR(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
