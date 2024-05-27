package org.example.softlabtest.service.impl.dictionary;

import lombok.RequiredArgsConstructor;
import org.example.softlabtest.entity.Experience;
import org.example.softlabtest.repository.ExperienceRepository;
import org.example.softlabtest.service.api.dictionary.ExperienceService;
import org.springframework.stereotype.Service;

import java.util.Set;
import java.util.stream.Collectors;

/**
 * Реализация сервиса для управления данными о профессиональном опыте.
 */
@Service
@RequiredArgsConstructor
public class ExperienceServiceImpl implements ExperienceService {
    private final ExperienceRepository experienceRepository;

    /**
     * Получает все уникальные названия компаний.
     *
     * @return Набор уникальных названий компаний.
     */
    @Override
    public Set<String> getCompanies() {
        return experienceRepository.findAll().stream()
                .map(Experience::getCompany)
                .collect(Collectors.toSet());
    }

    /**
     * Получает все уникальные названия компаний, которые содержат заданный поисковый запрос.
     *
     * @param searchQuery Поисковый запрос для поиска компаний.
     * @return Набор уникальных названий компаний, соответствующих поисковому запросу.
     */
    @Override
    public Set<String> getCompanies(String searchQuery) {
        return experienceRepository.findAllByCompanyName(searchQuery);
    }
}
