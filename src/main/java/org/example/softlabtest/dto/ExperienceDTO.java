package org.example.softlabtest.dto;

import lombok.Data;

import java.time.LocalDate;
import java.util.UUID;

@Data
public class ExperienceDTO {
    private UUID id;
    private LocalDate fromDate; // Можно использовать LocalDate для дат
    private LocalDate toDate;   // Можно использовать LocalDate для дат
    private String company;
    private String position;
    private String description;
}
