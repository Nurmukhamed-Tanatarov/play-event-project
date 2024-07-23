package com.micro.pe.macservice.service;

import com.micro.pe.macservice.dto.GimagesDTO;
import com.micro.pe.macservice.dto.ResponseGimagesDTO;
import com.micro.pe.macservice.entity.Gimages;
import com.micro.pe.macservice.repository.GimagesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class GimagesService {

    @Autowired
    private GimagesRepository gimagesRepository;

//    public ResponseGimagesDTO createGimages(GimagesDTO gimagesDTO) {
//        Gimages gimages = new Gimages();
//        gimages.setGame_id(gimagesDTO.getGame_id());
//        gimages.setImage_title(gimagesDTO.getImage_title());
//        gimages.setImage_url(gimagesDTO.getImage_url());
//        Gimages savedGimages = gimagesRepository.save(gimages);
//        return new ResponseGimagesDTO(
//                savedGimages.getId(),
//                savedGimages.getGame_id(),
//                savedGimages.getImage_title(),
//                savedGimages.getImage_url()
//        );
//
////        return ResponseEntity.status(HttpStatus.OK).body(savedGimagesDTO);
//    }

    public ResponseGimagesDTO createGimages(GimagesDTO gimagesDTO) {
        Gimages gimages = new Gimages();
        gimages.setGame_id(gimagesDTO.getGame_id());
        gimages.setImage_title(gimagesDTO.getImage_title());
        gimages.setImage_url(gimagesDTO.getImage_url());
        Gimages savedGimages = gimagesRepository.save(gimages);
        return new ResponseGimagesDTO(
                savedGimages.getId(),
                savedGimages.getGame_id(),
                savedGimages.getImage_title(),
                savedGimages.getImage_url()
        );
    }
}
