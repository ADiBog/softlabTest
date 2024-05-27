package org.example.softlabtest.service.impl.dictionary;

import lombok.RequiredArgsConstructor;
import org.example.softlabtest.entity.Skill;
import org.example.softlabtest.repository.SkillRepository;
import org.example.softlabtest.service.api.dictionary.SkillService;
import org.springframework.stereotype.Service;

import java.util.Set;
import java.util.stream.Collectors;

/**
 * Реализация сервиса для управления данными о навыках.
 */
@Service
@RequiredArgsConstructor
public class SkillServiceImpl implements SkillService {
    private final SkillRepository skillRepository;

    /**
     * Получает все уникальные названия навыков.
     *
     * @return Набор уникальных названий навыков.
     */
    @Override
    public Set<String> getSkills() {
        return skillRepository.findAll().stream()
                .map(Skill::getName)
                .collect(Collectors.toSet());
    }

    /**
     * Получает все уникальные названия навыков, которые содержат заданный поисковый запрос.
     *
     * @param searchQuery Поисковый запрос для поиска навыков.
     * @return Набор уникальных названий навыков, соответствующих поисковому запросу.
     */
    @Override
    public Set<String> getSkill(String searchQuery) {
        return skillRepository.findAllByName(searchQuery);
    }
}
