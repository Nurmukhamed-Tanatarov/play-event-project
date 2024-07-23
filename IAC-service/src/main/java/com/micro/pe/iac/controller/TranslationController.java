package com.micro.pe.iac.controller;

import com.micro.pe.iac.dto.TranslationsDTO;
import com.micro.pe.iac.dto.ResponseTranslationsDTO;
import com.micro.pe.iac.service.TranslationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/s2/translation")
public class TranslationController {

    @Autowired
    private TranslationService translationService;

    @PostMapping("/add-translation")
    public ResponseEntity<ResponseTranslationsDTO> addTranslation(@RequestBody TranslationsDTO translationsDTO) {
        ResponseTranslationsDTO createdTranslation = translationService.createTranslation(translationsDTO);
        return new ResponseEntity<>(createdTranslation, HttpStatus.CREATED);
    }

    @GetMapping("/findTranslationByID/{id}")
    public ResponseEntity<ResponseTranslationsDTO> findTranslationByID(@PathVariable("id") Integer id) {
        ResponseTranslationsDTO translation = translationService.findTranslationById(id);
        return new ResponseEntity<>(translation, HttpStatus.OK);
    }

    @GetMapping("/findAllTranslations")
    public ResponseEntity<List<ResponseTranslationsDTO>> findAllTranslations() {
        List<ResponseTranslationsDTO> translations = translationService.findAllTranslations();
        return new ResponseEntity<>(translations, HttpStatus.OK);
    }

    @PutMapping("/updateTranslations/{id}")
    public ResponseEntity<ResponseTranslationsDTO> updateTranslation(@PathVariable("id") Integer id, @RequestBody TranslationsDTO translationsDTO) {
        ResponseTranslationsDTO updatedTranslation = translationService.updateTranslation(id, translationsDTO);
        return new ResponseEntity<>(updatedTranslation, HttpStatus.OK);
    }

    @DeleteMapping("/delete-translation/{id}")
    public ResponseEntity<Void> deleteTranslation(@PathVariable("id") Integer id) {
        translationService.deleteTranslation(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
