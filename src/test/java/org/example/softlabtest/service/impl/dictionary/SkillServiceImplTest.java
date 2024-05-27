package org.example.softlabtest.service.impl.dictionary;

import org.example.softlabtest.entity.Skill;
import org.example.softlabtest.repository.SkillRepository;
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

public class SkillServiceImplTest {

    @Mock
    private SkillRepository skillRepository;

    @InjectMocks
    private SkillServiceImpl skillService;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testGetSkills() {
        // GIVEN
        Skill skill1 = new Skill();
        skill1.setName("Java");
        Skill skill2 = new Skill();
        skill2.setName("Python");
        Skill skill3 = new Skill();
        skill3.setName("Java"); // Duplicate to test uniqueness

        List<Skill> skills = Arrays.asList(skill1, skill2, skill3);

        when(skillRepository.findAll()).thenReturn(skills);

        // WHEN
        Set<String> result = skillService.getSkills();

        // THEN
        Set<String> expected = new HashSet<>(Arrays.asList("Java", "Python"));
        assertEquals(expected, result);
    }

    @Test
    public void testGetSkillWithSearchQuery() {
        // GIVEN
        String searchQuery = "Java";
        Set<String> skills = new HashSet<>(Arrays.asList("Java Developer", "JavaScript"));

        when(skillRepository.findAllByName(searchQuery)).thenReturn(skills);

        // WHEN
        Set<String> result = skillService.getSkill(searchQuery);

        // THEN
        Set<String> expected = new HashSet<>(Arrays.asList("Java Developer", "JavaScript"));
        assertEquals(expected, result);
    }
}
