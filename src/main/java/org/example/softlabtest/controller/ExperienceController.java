package org.example.softlabtest.controller;

import lombok.RequiredArgsConstructor;
import org.example.softlabtest.service.api.dictionary.ExperienceService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Set;

/**
 * Контроллер для работы с данными об опыте работы.
 */
@RestController
@RequiredArgsConstructor
@RequestMapping("/api/experiences")
public class ExperienceController {

    private final ExperienceService experienceService;

    /**
     * Получить список всех компаний.
     *
     * @return список компаний
     */
    @GetMapping("/companies")
    public ResponseEntity<Set<String>> getCompanies() {
        Set<String> companies = experienceService.getCompanies();
        return ResponseEntity.ok(companies);
    }

    /**
     * Получить список компаний по поисковому запросу.
     *
     * @param searchQuery поисковый запрос
     * @return список компаний, соответствующих поисковому запросу
     */
    @PostMapping("/companies/search")
    public ResponseEntity<Set<String>> getCompanies(@RequestParam String searchQuery) {
        Set<String> companies = experienceService.getCompanies(searchQuery);
        return ResponseEntity.ok(companies);
    }
}