package org.example.softlabtest.controller;

import lombok.RequiredArgsConstructor;
import org.example.softlabtest.service.api.dictionary.EducationService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Set;

/**
 * Контроллер для работы с данными об образовании.
 */
@RestController
@RequiredArgsConstructor
@RequestMapping("/api/educations")
public class EducationController {

    private final EducationService educationService;

    /**
     * Получить список всех университетов.
     *
     * @return список университетов
     */
    @GetMapping("/universities")
    public Set<String> getUniversities() {
        return educationService.getUniversities();
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