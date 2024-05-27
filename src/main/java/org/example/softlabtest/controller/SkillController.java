package org.example.softlabtest.controller;

import org.example.softlabtest.service.api.dictionary.SkillService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Set;

@RestController
@RequestMapping("/api/skills")
public class SkillController {

    private final SkillService skillService;

    @Autowired
    public SkillController(SkillService skillService) {
        this.skillService = skillService;
    }

    @GetMapping
    public ResponseEntity<Set<String>> getSkills() {
        Set<String> skills = skillService.getSkills();
        return ResponseEntity.ok(skills);
    }

    @GetMapping("/search")
    public ResponseEntity<Set<String>> getSkills(@RequestParam String searchQuery) {
        Set<String> skills = skillService.getSkill(searchQuery);
        return ResponseEntity.ok(skills);
    }
}
