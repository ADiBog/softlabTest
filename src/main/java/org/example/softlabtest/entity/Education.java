package org.example.softlabtest.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.UUID;

/**
 * Класс-сущность для представления данных об образовании.
 */
@Entity
@Data
@NoArgsConstructor
public class Education {

    /**
     * Уникальный идентификатор образования.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;

    /**
     * Дата окончания обучения.
     */
    private LocalDate finishedAt;

    /**
     * Название университета.
     */
    private String university;

    /**
     * Степень (бакалавр, магистр и т.д.).
     */
    private String degree;

    /**
     * Название степени.
     */
    private String degreeName;

    /**
     * Связь с сущностью Person.
     */
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "person_id")
    @JsonBackReference
    private Person person;
}