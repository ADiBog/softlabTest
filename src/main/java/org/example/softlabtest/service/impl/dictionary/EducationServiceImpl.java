package org.example.softlabtest.service.impl.dictionary;

import lombok.RequiredArgsConstructor;
import org.example.softlabtest.entity.Education;
import org.example.softlabtest.repository.EducationRepository;
import org.example.softlabtest.service.api.dictionary.EducationService;
import org.springframework.stereotype.Service;

import java.util.Set;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class EducationServiceImpl implements EducationService {
    private final EducationRepository educationRepository;

    @Override
    public Set<String> getUniversities() {
        return educationRepository.findAll().stream()
                .map(Education::getUniversity)
                .collect(Collectors.toSet());
    }

    @Override
    public Set<String> getUniversities(String searchQuery) {
        return educationRepository.findAllByInstitutionName(searchQuery);
    }
}
