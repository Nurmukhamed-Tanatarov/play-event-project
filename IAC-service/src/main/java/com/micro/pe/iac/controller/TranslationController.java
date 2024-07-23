package com.micro.pe.iac.controller;

import com.micro.pe.iac.entity.Translations;
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
    public ResponseEntity<Translations> addTranslation(@RequestBody Translations translations) {
        Translations createdTranslation = translationService.createTranslation(translations);
        return new ResponseEntity<>(createdTranslation, HttpStatus.CREATED);
    }

    @GetMapping("/findTranslationByID/{id}")
    public ResponseEntity<Translations> findTranslationByID(@PathVariable("id") Integer id) {
        Translations translations = translationService.findTranslationById(id);
        return new ResponseEntity<>(translations, HttpStatus.OK);
    }

    @GetMapping("/findAllTranslations")
    public ResponseEntity<List<Translations>> findAllTranslations() {
        List<Translations> translations = translationService.findAllTranslations();
        return new ResponseEntity<>(translations, HttpStatus.OK);
    }

    @PutMapping("/updateTranslations/{id}")
    public ResponseEntity<Translations> updateTranslation(@PathVariable("id") Integer id, @RequestBody Translations translations) {
        Translations updatedTranslation = translationService.updateTranslation(id, translations);
        return new ResponseEntity<>(updatedTranslation, HttpStatus.OK);
    }

    @DeleteMapping("/delete-translation/{id}")
    public ResponseEntity<Translations> deleteTranslation(@PathVariable("id") Integer id) {
        translationService.deleteTranslation(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

}
