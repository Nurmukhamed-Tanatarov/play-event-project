package com.micro.pe.macservice.service;

import com.micro.pe.macservice.dto.GimagesDTO;
import com.micro.pe.macservice.entity.Gimages;
import com.micro.pe.macservice.repository.GimagesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import java.io.IOException;
import java.time.LocalDateTime;
import java.util.List;

@Service
public class GimagesService {

    @Autowired
    private GimagesRepository gimagesRepository;

    public Gimages createGimages(MultipartFile file, GimagesDTO gimagesDTO) throws IOException {
        Gimages gimages = new Gimages();
        gimages.setImage_title(file.getOriginalFilename());
        gimages.setData(file.getBytes());
        gimages.setUpload_time(LocalDateTime.now());
        gimages.setType(file.getContentType());
        gimages.setGame_id(gimagesDTO.getGame_id());
        return gimagesRepository.save(gimages);
    }

    public Gimages getGimage(int id) {
        return gimagesRepository.findById(id).orElseThrow(() -> new RuntimeException("No image found with id: " + id));
    }

    public List<Gimages> getAllGImages() {
        return gimagesRepository.findAll();
    }

    public Gimages updateGImages(int id, MultipartFile file, GimagesDTO gimagesDTO) throws IOException {
        Gimages existingimages = gimagesRepository.findById(id).orElseThrow(() -> new RuntimeException("No image found with id: " + id));
        existingimages.setImage_title(file.getOriginalFilename());
        existingimages.setData(file.getBytes());
        existingimages.setType(file.getContentType());
        existingimages.setUpload_time(LocalDateTime.now());
        existingimages.setGame_id(gimagesDTO.getGame_id());
        return gimagesRepository.save(existingimages);
    }

    public void deleteGImages(int id) {
        try {
            gimagesRepository.deleteById(id);
        } catch (Exception e) {
            throw new RuntimeException("No image found with id: " + id);
        }
    }
}
