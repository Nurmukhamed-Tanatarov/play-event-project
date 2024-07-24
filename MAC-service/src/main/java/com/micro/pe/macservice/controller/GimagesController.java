package com.micro.pe.macservice.controller;

import com.micro.pe.macservice.dto.GimagesDTO;
import com.micro.pe.macservice.entity.Gimages;
import com.micro.pe.macservice.service.GimagesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("api/s3/gimage")
public class GimagesController {

    @Autowired
    private GimagesService gimagesService;

    @PostMapping("/addImage")
    public ResponseEntity<String> addImage(@RequestParam("file") MultipartFile file, @RequestParam("game_id") int game_id) {
        try {
            GimagesDTO gimagesDTO = new GimagesDTO();
            gimagesDTO.setGame_id(game_id);
            gimagesService.createGimages(file, gimagesDTO);
            return new ResponseEntity<>("Image added", HttpStatus.OK);
        } catch (IOException e) {
            return new ResponseEntity<>("Failed to upload image", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/getAllImage")
    public ResponseEntity<List<Gimages>> getAllImages() {
        List<Gimages> mImages = gimagesService.getAllGImages();
        return new ResponseEntity<>(mImages, HttpStatus.OK);
    }

    @GetMapping("/getImageByID/{id}")
    public ResponseEntity<byte[]> getImage(@PathVariable int id) {
        Gimages mImages = gimagesService.getGimage(id);
        String mimeType = mImages.getType() != null ? mImages.getType() : "application/octet-stream";
        String filename = mImages.getImage_title() != null ? mImages.getImage_title() : "downloaded_image";
        return ResponseEntity.ok()
                .contentType(MediaType.parseMediaType(mimeType))
                .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + filename + "\"")
                .body(mImages.getData());
    }

    @PutMapping("/updateImage/{id}")
    public ResponseEntity<Gimages> updateImage(@PathVariable int id, @RequestParam("file") MultipartFile file, GimagesDTO gimagesDTO) {
        try {
            Gimages updatedGimages = gimagesService.updateGImages(id, file, gimagesDTO);
            return new ResponseEntity<>(updatedGimages, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @DeleteMapping("/deleteImage/{id}")
    public ResponseEntity<Gimages> deleteImage(@PathVariable("id") int id) {
        gimagesService.deleteGImages(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

}
