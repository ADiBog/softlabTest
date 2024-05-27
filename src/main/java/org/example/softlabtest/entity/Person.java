package org.example.softlabtest.entity;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.UUID;

/**
 * Класс-сущность для представления данных о человеке.
 */
@Entity
@Data
@NoArgsConstructor
public class Person {

    /**
     * Уникальный идентификатор человека.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;

    /**
     * Имя человека.
     */
    private String name;

    /**
     * Электронная почта человека.
     */
    private String email;

    /**
     * Биография человека.
     */
    private String bio;

    /**
     * Список навыков человека.
     */
    @OneToMany(mappedBy = "person", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JsonManagedReference
    private List<Skill> skills;

    /**
     * Список опыта работы человека.
     */
    @OneToMany(mappedBy = "person", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JsonManagedReference
    private List<Experience> experiences;

    /**
     * Список образований человека.
     */
    @OneToMany(mappedBy = "person", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JsonManagedReference
    private List<Education> education;
}