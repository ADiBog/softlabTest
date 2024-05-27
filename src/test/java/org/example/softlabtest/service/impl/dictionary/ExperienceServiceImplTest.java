package org.example.softlabtest.service.impl.dictionary;

import org.example.softlabtest.entity.Experience;
import org.example.softlabtest.repository.ExperienceRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.*;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

public class ExperienceServiceImplTest {

    @Mock
    private ExperienceRepository experienceRepository;

    @InjectMocks
    private ExperienceServiceImpl experienceService;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testGetCompanies() {
        // GIVEN
        Experience exp1 = new Experience();
        exp1.setCompany("Company1");

        Experience exp2 = new Experience();
        exp2.setCompany("Company2");

        Experience exp3 = new Experience();
        exp3.setCompany("Company1");

        List<Experience> experiences = Arrays.asList(exp1, exp2, exp3);

        when(experienceRepository.findAll()).thenReturn(experiences);

        // WHEN
        Set<String> companies = experienceService.getCompanies();

        // THEN
        assertEquals(new HashSet<>(Arrays.asList("Company1", "Company2")), companies);
    }

    @Test
    public void testGetCompaniesWithSearchQuery() {
        // GIVEN
        String searchQuery = "Company";
        Set<String> expectedCompanies = new HashSet<>(Arrays.asList("Company1", "Company2"));

        when(experienceRepository.findAllByCompanyName(searchQuery)).thenReturn(expectedCompanies);

        // WHEN
        Set<String> companies = experienceService.getCompanies(searchQuery);

        // THEN
        assertEquals(expectedCompanies, companies);
    }
}
