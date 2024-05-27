package org.example.softlabtest.controller;

import org.example.softlabtest.service.api.dictionary.EducationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Set;

@RestController
@RequestMapping("/api/educations")
public class EducationController {

    private final EducationService educationService;

    @Autowired
    public EducationController(EducationService educationService) {
        this.educationService = educationService;
    }

    @GetMapping("/universities")
    public ResponseEntity<Set<String>> getUniversities() {
        Set<String> universities = educationService.getUniversities();
        return ResponseEntity.ok(universities);
    }

    @PostMapping("/universities/search")
    public ResponseEntity<Set<String>> getUniversities(@RequestParam String searchQuery) {
        Set<String> universities = educationService.getUniversities(searchQuery);
        return ResponseEntity.ok(universities);
    }
}
