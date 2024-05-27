package org.example.softlabtest.service.impl.dictionary;

import org.example.softlabtest.entity.Education;
import org.example.softlabtest.repository.EducationRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

public class EducationServiceImplTest {

    @Mock
    private EducationRepository educationRepository;

    @InjectMocks
    private EducationServiceImpl educationService;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testGetUniversities() {
        // GIVEN
        Education edu1 = new Education();
        edu1.setUniversity("University1");

        Education edu2 = new Education();
        edu2.setUniversity("University2");

        Education edu3 = new Education();
        edu3.setUniversity("University1");

        List<Education> educations = Arrays.asList(edu1, edu2, edu3);

        when(educationRepository.findAll()).thenReturn(educations);

        // WHEN
        Set<String> universities = educationService.getUniversities();

        // THEN
        assertEquals(new HashSet<>(Arrays.asList("University1", "University2")), universities);
    }

    @Test
    public void testGetUniversitiesWithSearchQuery() {
        // GIVEN
        String searchQuery = "Uni";
        Set<String> expectedUniversities = new HashSet<>(Arrays.asList("University1", "University2"));

        when(educationRepository.findAllByInstitutionName(searchQuery)).thenReturn(expectedUniversities);

        // WHEN
        Set<String> universities = educationService.getUniversities(searchQuery);

        // THEN
        assertEquals(expectedUniversities, universities);
    }
}
