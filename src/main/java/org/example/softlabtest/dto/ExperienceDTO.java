package org.example.softlabtest.dto;

import lombok.Data;

import java.time.LocalDate;

@Data
public class ExperienceDTO {
    private Long id;
    private LocalDate fromDate; // Можно использовать LocalDate для дат
    private LocalDate toDate;   // Можно использовать LocalDate для дат
    private String company;
    private String position;
    private String description;
}
