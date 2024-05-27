package org.example.softlabtest.service.impl.dictionary;

import lombok.RequiredArgsConstructor;
import org.example.softlabtest.entity.Education;
import org.example.softlabtest.repository.EducationRepository;
import org.example.softlabtest.service.api.dictionary.EducationService;
import org.springframework.stereotype.Service;

import java.util.Set;
import java.util.stream.Collectors;

/**
 * Реализация сервиса для управления данными об образовании.
 */
@Service
@RequiredArgsConstructor
public class EducationServiceImpl implements EducationService {
    private final EducationRepository educationRepository;

    /**
     * Получает все уникальные названия университетов.
     *
     * @return Набор уникальных названий университетов.
     */
    @Override
    public Set<String> getUniversities() {
        return educationRepository.findAll().stream()
                .map(Education::getUniversity)
                .collect(Collectors.toSet());
    }

    /**
     * Получает все уникальные названия университетов, которые начинаются с заданного поискового запроса.
     *
     * @param searchQuery Поисковый запрос для поиска университетов.
     * @return Набор уникальных названий университетов, соответствующих поисковому запросу.
     */
    @Override
    public Set<String> getUniversities(String searchQuery) {
        return educationRepository.findAllByInstitutionName(searchQuery);
    }
}
