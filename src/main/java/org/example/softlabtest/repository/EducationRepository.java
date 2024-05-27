package org.example.softlabtest.repository;

import org.example.softlabtest.entity.Education;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Set;
import java.util.UUID;

@Repository
public interface EducationRepository extends JpaRepository<Education, UUID> {
    @Query("SELECT DISTINCT e.university FROM Education e WHERE UPPER(e.university) LIKE UPPER(CONCAT(:searchQuery,'%'))")
    Set<String> findAllByInstitutionName(String searchQuery);
}
