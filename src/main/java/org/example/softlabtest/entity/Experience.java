package org.example.softlabtest.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.UUID;

/**
 * Класс-сущность для представления данных об опыте работы.
 */
@Entity
@Data
@NoArgsConstructor
public class Experience {

    /**
     * Уникальный идентификатор опыта работы.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;

    /**
     * Дата начала работы.
     */
    private LocalDate fromDate;

    /**
     * Дата окончания работы.
     */
    private LocalDate toDate;

    /**
     * Название компании.
     */
    private String company;

    /**
     * Должность.
     */
    private String position;

    /**
     * Описание обязанностей и достижений на данной должности.
     */
    private String description;

    /**
     * Связь с сущностью Person.
     */
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "person_id")
    @JsonBackReference
    private Person person;
}