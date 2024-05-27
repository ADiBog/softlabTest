package org.example.softlabtest.dto;

import lombok.Builder;
import lombok.Value;

import java.util.UUID;

/**
 * Data Transfer Object для представления навыка.
 */
@Value
@Builder
public class SkillDTO {
    /**
     * Уникальный идентификатор человека.
     */
    UUID id;

    /**
     * Название навыка.
     */
    String name;

    /**
     * Описание навыка.
     */
    String description;
}