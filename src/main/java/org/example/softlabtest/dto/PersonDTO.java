package org.example.softlabtest.dto;

import lombok.Data;

import java.util.List;
import java.util.UUID;

@Data
public class PersonDTO {
    private UUID id;
    private String name;
    private String email;
    private String bio;
    private List<SkillDTO> skills;
    private List<ExperienceDTO> experiences;
    private List<EducationDTO> education;
}