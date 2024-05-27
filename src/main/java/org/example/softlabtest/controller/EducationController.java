package org.example.softlabtest.controller;

import org.example.softlabtest.service.api.dictionary.EducationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Set;

/**
 * Контроллер для работы с данными об образовании.
 */
@RestController
@RequestMapping("/api/educations")
public class EducationController {

    private final EducationService educationService;

    /**
     * Конструктор с автоматическим внедрением зависимости EducationService.
     *
     * @param educationService сервис для работы с данными об образовании
     */
    @Autowired
    public EducationController(EducationService educationService) {
        this.educationService = educationService;
    }

    /**
     * Получить список всех университетов.
     *
     * @return список университетов
     */
    @GetMapping("/universities")
    public ResponseEntity<Set<String>> getUniversities() {
        Set<String> universities = educationService.getUniversities();
        return ResponseEntity.ok(universities);
    }

    /**
     * Получить список университетов по поисковому запросу.
     *
     * @param searchQuery поисковый запрос
     * @return список университетов, соответствующих поисковому запросу
     */
    @PostMapping("/universities/search")
    public ResponseEntity<Set<String>> getUniversities(@RequestParam String searchQuery) {
        Set<String> universities = educationService.getUniversities(searchQuery);
        return ResponseEntity.ok(universities);
    }
}