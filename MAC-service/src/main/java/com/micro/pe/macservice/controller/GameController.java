package com.micro.pe.macservice.controller;

import com.micro.pe.macservice.dto.GameDTO;
import com.micro.pe.macservice.dto.ResponseGameDTO;
import com.micro.pe.macservice.service.GameService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/s3/game")
public class GameController {

    @Autowired
    private GameService gameService;

    @PostMapping("/create-game")
    public ResponseEntity<ResponseGameDTO> createGame(@RequestBody GameDTO gameDTO) {
        ResponseGameDTO responseGameDTO = gameService.createGame(gameDTO);
        return new ResponseEntity<>(responseGameDTO, HttpStatus.CREATED);
    }

    @GetMapping("/getGame/{id}")
    public ResponseEntity<ResponseGameDTO> getGame(@PathVariable Integer id) {
        ResponseGameDTO game = gameService.getGameById(id);
        return new ResponseEntity<>(game, HttpStatus.OK);
    }

    @GetMapping("/getAllGames")
    public ResponseEntity<List<ResponseGameDTO>> getAllGames() {
        List<ResponseGameDTO> games = gameService.getAllGames();
        return new ResponseEntity<>(games, HttpStatus.OK);
    }

    @PutMapping("/updateGame/{id}")
    public ResponseEntity<ResponseGameDTO> updateGame(@PathVariable Integer id, @RequestBody GameDTO gameDTO) {
        ResponseGameDTO responseGameDTO = gameService.updateGame(id, gameDTO);
        return new ResponseEntity<>(responseGameDTO, HttpStatus.OK);
    }

    @DeleteMapping("/deleteGame/{id}")
    public ResponseEntity<ResponseGameDTO> deleteGame(@PathVariable Integer id) {
        gameService.deleteGame(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
