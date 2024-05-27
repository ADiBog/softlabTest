package org.example.softlabtest.service.api.dictionary;

import java.util.Set;

public interface SkillService {
    Set<String> getSkills();
    Set<String> getSkill(String searchQuery);
}
