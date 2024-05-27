package org.example.softlabtest.controller;

import org.example.softlabtest.service.api.dictionary.ExperienceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Set;

@RestController
@RequestMapping("/api/experiences")
public class ExperienceController {


    private final ExperienceService experienceService;

    @Autowired
    public ExperienceController(ExperienceService experienceService) {
        this.experienceService = experienceService;
    }

    @GetMapping("/companies")
    public ResponseEntity<Set<String>> getCompanies() {
        Set<String> companies = experienceService.getCompanies();
        return ResponseEntity.ok(companies);
    }

    @PostMapping("/companies/search")
    public ResponseEntity<Set<String>> getCompanies(@RequestParam String searchQuery) {
        Set<String> companies = experienceService.getCompanies(searchQuery);
        return ResponseEntity.ok(companies);
    }
}
