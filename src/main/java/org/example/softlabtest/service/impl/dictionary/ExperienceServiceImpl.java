package org.example.softlabtest.service.impl.dictionary;

import lombok.RequiredArgsConstructor;
import org.example.softlabtest.entity.Experience;
import org.example.softlabtest.repository.ExperienceRepository;
import org.example.softlabtest.service.api.dictionary.ExperienceService;
import org.springframework.stereotype.Service;

import java.util.Set;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ExperienceServiceImpl implements ExperienceService {
    private final ExperienceRepository experienceRepository;

    @Override
    public Set<String> getCompanies() {
        return experienceRepository.findAll().stream()
                .map(Experience::getCompany)
                .collect(Collectors.toSet());
    }

    @Override
    public Set<String> getCompanies(String searchQuery) {
        return experienceRepository.findAllByCompanyName(searchQuery);
    }
}
