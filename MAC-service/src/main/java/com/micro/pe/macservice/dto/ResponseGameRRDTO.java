package com.micro.pe.macservice.dto;

import lombok.Data;

@Data
public class ResponseGameRRDTO {
    private int id;
    private int gameId;
    private int rentRulesId;
    private String description;

    public ResponseGameRRDTO(int id,int gameId, int rentRulesId, String description) {
        this.id = id;
        this.gameId = gameId;
        this.rentRulesId = rentRulesId;
        this.description = description;
    }
}
