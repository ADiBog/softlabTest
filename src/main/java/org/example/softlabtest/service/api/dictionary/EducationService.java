package org.example.softlabtest.service.api.dictionary;

import java.util.Set;

public interface EducationService {
    Set<String> getUniversities();
    Set<String> getUniversities(String searchQuery);
}
