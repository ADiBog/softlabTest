package org.example.softlabtest.dto;

import lombok.Builder;
import lombok.Value;

import java.time.LocalDate;
import java.util.UUID;

/**
 * Data Transfer Object для представления образования.
 */
@Value
@Builder
public class EducationDTO {
    /**
     * Уникальный идентификатор человека.
     */
    UUID id;

    /**
     * Дата окончания обучения.
     */
    LocalDate finishedAt;

    /**
     * Название университета.
     */
    String university;

    /**
     * Степень полученная в университете (например, бакалавр, магистр).
     */
    String degree;

    /**
     * Название степени (например, Компьютерные науки).
     */
    String degreeName;
}