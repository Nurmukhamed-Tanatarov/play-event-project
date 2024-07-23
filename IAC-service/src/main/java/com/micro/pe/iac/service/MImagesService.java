package com.micro.pe.iac.service;

import com.micro.pe.iac.entity.MImages;
import com.micro.pe.iac.repository.MImagesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import java.io.IOException;
import java.time.LocalDateTime;
import java.util.List;

@Service
public class MImagesService {

    @Autowired
    private MImagesRepository mImagesRepository;

    public MImages addMImages(MultipartFile file) throws IOException {
        MImages mImages = new MImages();
        mImages.setTitle(file.getOriginalFilename());
        mImages.setData(file.getBytes());
        mImages.setUpload_time(LocalDateTime.now());
        mImages.setType(file.getContentType());
        return mImagesRepository.save(mImages);
    }

    public MImages getMImagesById(int id) {
        return mImagesRepository.findById(id).orElseThrow(() -> new RuntimeException("No image found with id: " + id));
    }



    public List<MImages> getAllMImages() {
        return mImagesRepository.findAll();
    }

    public MImages updateMImages(int id, MImages mImages) {
        MImages existingimages = mImagesRepository.findById(id).orElseThrow( () -> new RuntimeException("No image found with id: " + id));
        existingimages.setImage_url(mImages.getImage_url());
        existingimages.setTitle(mImages.getTitle());
        existingimages.setManager_id(mImages.getManager_id());
        return mImagesRepository.save(existingimages);
    }

    public void deleteMImages(int id) {
        try {
            mImagesRepository.deleteById(id);
        } catch (Exception e) {
            throw new RuntimeException("No image found with id: " + id);
        }
    }
}
