package org.example.softlabtest.dto;

import lombok.Data;

import java.time.LocalDate;
import java.util.UUID;

@Data
public class EducationDTO {
    private UUID id;
    private LocalDate finishedAt; // Можно использовать LocalDate для дат
    private String university;
    private String degree;
    private String degreeName;
}