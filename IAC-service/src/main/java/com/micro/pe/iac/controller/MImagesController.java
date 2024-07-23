package com.micro.pe.iac.controller;

import com.micro.pe.iac.entity.MImages;
import com.micro.pe.iac.service.MImagesService;
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
@RequestMapping("api/s2/MImage")
public class MImagesController {

    @Autowired
    private MImagesService mImagesService;

    @PostMapping("/addImage")
    public ResponseEntity<String> addImage(@RequestParam("file") MultipartFile file) {
        try {
            mImagesService.addMImages(file);
            return new ResponseEntity<>("Image added", HttpStatus.OK);
        } catch (IOException e) {
            return new ResponseEntity<>("Failed to upload image", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/getAllImage")
    public ResponseEntity<List<MImages>> getAllImages() {
        List<MImages> mImages = mImagesService.getAllMImages();
        return new ResponseEntity<>(mImages, HttpStatus.OK);
    }

    @GetMapping("/getImageByID/{id}")
    public ResponseEntity<byte[]> getImage(@PathVariable int id) {
        MImages mImages = mImagesService.getMImagesById(id);
        String mimeType = mImages.getType() != null ? mImages.getType() : "application/octet-stream";
        String filename = mImages.getTitle() != null ? mImages.getTitle() : "downloaded_image";
        return ResponseEntity.ok()
                .contentType(MediaType.parseMediaType(mimeType))
                .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + filename + "\"")
                .body(mImages.getData());
    }

    @PutMapping("/updateMImage/{id}")
    public ResponseEntity<MImages> updateImage(@PathVariable("id") int id, @RequestBody MImages image) {
        MImages mImages = mImagesService.updateMImages(id, image);
        return new ResponseEntity<>(mImages, HttpStatus.OK);
    }

    @DeleteMapping("/deleteMImage/{id}")
    public ResponseEntity<MImages> deleteImage(@PathVariable("id") int id) {
        mImagesService.deleteMImages(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

}
