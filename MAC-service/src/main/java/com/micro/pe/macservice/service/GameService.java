package com.micro.pe.macservice.service;

import com.micro.pe.macservice.dto.GameDTO;
import com.micro.pe.macservice.dto.ResponseGameDTO;
import com.micro.pe.macservice.entity.Game;
import com.micro.pe.macservice.repository.GameRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@Service
public class GameService {

    @Autowired
    private GameRepository gameRepository;

    public ResponseGameDTO createGame(GameDTO gameDTO) {
        Game game = new Game();
        game.setTitle(gameDTO.getTitle());
        game.setPrice(gameDTO.getPrice());
        game.setDescription(gameDTO.getDescription());
        game.setInfo(gameDTO.getInfo());
        game.setGame_list_id(gameDTO.getGameListId());
        Game savedGame = gameRepository.save(game);
        return new ResponseGameDTO(
                savedGame.getId(),
                savedGame.getTitle(),
                savedGame.getPrice(),
                savedGame.getDescription(),
                savedGame.getInfo(),
                savedGame.getGame_list_id());
    }

    public List<ResponseGameDTO> getAllGames(){
        List<Game> games = gameRepository.findAll();
        return games.stream()
                .map(game -> new ResponseGameDTO(
                        game.getId(),
                        game.getTitle(),
                        game.getPrice(),
                        game.getDescription(),
                        game.getInfo(),
                        game.getGame_list_id()))
                .collect(Collectors.toList());
    }

    public ResponseGameDTO getGameById(int id) {
        Game game = gameRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Not found"));
        return new ResponseGameDTO(
                game.getId(),
                game.getTitle(),
                game.getPrice(),
                game.getDescription(),
                game.getInfo(),
                game.getGame_list_id());
    }

    public ResponseGameDTO updateGame(int id, GameDTO gameDTO) {
        Game existingGame = gameRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Not found"));
        existingGame.setTitle(gameDTO.getTitle());
        existingGame.setPrice(gameDTO.getPrice());
        existingGame.setDescription(gameDTO.getDescription());
        existingGame.setInfo(gameDTO.getInfo());
        existingGame.setGame_list_id(gameDTO.getGameListId());
        log.info("Updating existing game: " + existingGame);
        Game updatedGame = gameRepository.save(existingGame);
        return new ResponseGameDTO(
                updatedGame.getId(),
                updatedGame.getTitle(),
                updatedGame.getPrice(),
                updatedGame.getDescription(),
                updatedGame.getInfo(),
                updatedGame.getGame_list_id()
        );
    }


    public void deleteGame(int id) {
        gameRepository.deleteById(id);
    }

}
