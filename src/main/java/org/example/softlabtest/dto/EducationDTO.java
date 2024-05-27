package org.example.softlabtest.dto;

import lombok.Data;

import java.time.LocalDate;

@Data
public class EducationDTO {
    private Long id;
    private LocalDate finishedAt; // Можно использовать LocalDate для дат
    private LocalDate university;
    private String degree;
    private String degreeName;
}