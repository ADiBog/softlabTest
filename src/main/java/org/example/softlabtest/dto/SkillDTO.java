package org.example.softlabtest.dto;

import lombok.Data;

import java.util.UUID;

@Data
public class SkillDTO {
    private UUID id;
    private String name;
    private String description;
}