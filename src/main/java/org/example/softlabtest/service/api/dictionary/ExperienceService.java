package org.example.softlabtest.service.api.dictionary;

import java.util.Set;

public interface ExperienceService {
    Set<String> getCompanies();

    Set<String> getCompanies(String searchQuery);
}
