package org.example.softlabtest.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

/**
 * Класс-сущность для представления данных о навыках.
 */
@Entity
@Data
@NoArgsConstructor
public class Skill {

    /**
     * Уникальный идентификатор навыка.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;

    /**
     * Название навыка.
     */
    private String name;

    /**
     * Описание навыка.
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