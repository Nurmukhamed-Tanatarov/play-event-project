package com.micro.pe.iac.service;

import com.micro.pe.iac.entity.Translations;
import com.micro.pe.iac.repository.TranslationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TranslationService {

    @Autowired
    private TranslationRepository translationRepository;

    public Translations createTranslation(Translations translation) {
        return translationRepository.save(translation);
    }

    public Translations findTranslationById(int id) {
        return translationRepository.findById(id).orElseThrow( () -> new RuntimeException("Could not find translation with id: " + id) );
    }

    public List<Translations> findAllTranslations() {
        return translationRepository.findAll();
    }

    public Translations updateTranslation(int id, Translations translation) {
        Translations oldTranslation = findTranslationById(id);
        oldTranslation.setEntity_id(translation.getEntity_id());
        oldTranslation.setEntity_type(translation.getEntity_type());
        oldTranslation.setLanguage_code(translation.getLanguage_code());
        oldTranslation.setTranslated_text(translation.getTranslated_text());
        return translationRepository.save(oldTranslation);
    }

    public void deleteTranslation(int id) {
        translationRepository.deleteById(id);
    }

}
