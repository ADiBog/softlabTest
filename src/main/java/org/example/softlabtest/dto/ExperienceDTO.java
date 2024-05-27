package org.example.softlabtest.dto;

import lombok.Builder;
import lombok.Value;

import java.time.LocalDate;
import java.util.UUID;

/**
 * Data Transfer Object для представления опыта работы.
 */
@Value
@Builder
public class ExperienceDTO {
    /**
     * Уникальный идентификатор человека.
     */
    UUID id;

    /**
     * Дата начала работы.
     */
    LocalDate fromDate;

    /**
     * Дата окончания работы.
     */
    LocalDate toDate;

    /**
     * Название компании.
     */
    String company;

    /**
     * Должность в компании.
     */
    String position;
}