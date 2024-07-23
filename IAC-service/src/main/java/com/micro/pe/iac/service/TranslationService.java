package com.micro.pe.iac.service;

import com.micro.pe.iac.dto.TranslationsDTO;
import com.micro.pe.iac.dto.ResponseTranslationsDTO;
import com.micro.pe.iac.entity.Translations;
import com.micro.pe.iac.repository.TranslationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class TranslationService {

    @Autowired
    private TranslationRepository translationRepository;

    public ResponseTranslationsDTO createTranslation(TranslationsDTO translationDTO) {
        Translations translation = new Translations();
        translation.setEntity_id(translationDTO.getEntity_id());
        translation.setEntity_type(translationDTO.getEntity_type());
        translation.setLanguage_code(translationDTO.getLanguage_code());
        translation.setTranslated_text(translationDTO.getTranslated_text());
        Translations savedTranslation = translationRepository.save(translation);
        return new ResponseTranslationsDTO(
                savedTranslation.getId(),
                savedTranslation.getEntity_id(),
                savedTranslation.getEntity_type(),
                savedTranslation.getLanguage_code(),
                savedTranslation.getTranslated_text()
        );
    }

    public ResponseTranslationsDTO findTranslationById(int id) {
        Translations translation = translationRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Could not find translation with id: " + id));
        return new ResponseTranslationsDTO(
                translation.getId(),
                translation.getEntity_id(),
                translation.getEntity_type(),
                translation.getLanguage_code(),
                translation.getTranslated_text()
        );
    }

    public List<ResponseTranslationsDTO> findAllTranslations() {
        List<Translations> translations = translationRepository.findAll();
        return translations.stream()
                .map(translation -> new ResponseTranslationsDTO(
                        translation.getId(),
                        translation.getEntity_id(),
                        translation.getEntity_type(),
                        translation.getLanguage_code(),
                        translation.getTranslated_text()
                ))
                .collect(Collectors.toList());
    }

    public ResponseTranslationsDTO updateTranslation(int id, TranslationsDTO translationDTO) {
        Translations existingTranslation = translationRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Could not find translation with id: " + id));
        existingTranslation.setEntity_id(translationDTO.getEntity_id());
        existingTranslation.setEntity_type(translationDTO.getEntity_type());
        existingTranslation.setLanguage_code(translationDTO.getLanguage_code());
        existingTranslation.setTranslated_text(translationDTO.getTranslated_text());
        Translations updatedTranslation = translationRepository.save(existingTranslation);
        return new ResponseTranslationsDTO(
                updatedTranslation.getId(),
                updatedTranslation.getEntity_id(),
                updatedTranslation.getEntity_type(),
                updatedTranslation.getLanguage_code(),
                updatedTranslation.getTranslated_text()
        );
    }

    public void deleteTranslation(int id) {
        translationRepository.deleteById(id);
    }
}
