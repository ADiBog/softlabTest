package org.example.softlabtest.dto;

import lombok.Builder;
import lombok.Value;

import java.util.List;
import java.util.UUID;

/**
 * Data Transfer Object для представления человека.
 */
@Value
@Builder
public class PersonDTO {
    /**
     * Уникальный идентификатор человека.
     */
    UUID id;

    /**
     * Имя человека.
     */
    String name;

    /**
     * Электронная почта человека.
     */
    String email;

    /**
     * Биография человека.
     */
    String bio;

    /**
     * Список навыков человека.
     */
    List<SkillDTO> skills;

    /**
     * Список опыта работы человека.
     */
    List<ExperienceDTO> experiences;

    /**
     * Список образования человека.
     */
    List<EducationDTO> education;
}