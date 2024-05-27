package org.example.softlabtest.service.impl.dictionary;

import lombok.RequiredArgsConstructor;
import org.example.softlabtest.entity.Skill;
import org.example.softlabtest.repository.SkillRepository;
import org.example.softlabtest.service.api.dictionary.SkillService;
import org.springframework.stereotype.Service;

import java.util.Set;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class SkillServiceImpl implements SkillService {
    private final SkillRepository skillRepository;

    @Override
    public Set<String> getSkills() {
        return skillRepository.findAll().stream().map(Skill::getName).collect(Collectors.toSet());
    }

    @Override
    public Set<String> getSkill(String searchQuery) {
        return skillRepository.findAllByName(searchQuery);
    }
}
