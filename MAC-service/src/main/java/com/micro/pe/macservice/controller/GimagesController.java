package com.micro.pe.macservice.controller;

import com.micro.pe.macservice.dto.GimagesDTO;
import com.micro.pe.macservice.dto.ResponseGimagesDTO;
import com.micro.pe.macservice.service.GimagesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/s3/gimage")
public class GimagesController {

    @Autowired
    private GimagesService gimagesService;

//    @PostMapping("/createGimage")
//    public ResponseEntity<GimagesDTO> createGimages(@RequestBody GimagesDTO gimagesDTO) {
//        GimagesDTO createdGimagesDTO = gimagesService.createGimages(gimagesDTO);
//        return ResponseEntity.status(HttpStatus.CREATED).body(createdGimagesDTO);
//    }


    @PostMapping("/createGimage")
    public ResponseEntity<ResponseGimagesDTO> createGimages(@RequestBody GimagesDTO gimagesDTO) {
        ResponseGimagesDTO createdResponseGimagesDTO = gimagesService.createGimages(gimagesDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdResponseGimagesDTO);
    }

}
