package org.example.softlabtest.repository;

import org.example.softlabtest.entity.Experience;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Set;
import java.util.UUID;

@Repository
public interface ExperienceRepository extends JpaRepository<Experience, UUID> {

    @Query("SELECT DISTINCT e.company FROM Experience e WHERE UPPER(e.company) LIKE UPPER(CONCAT('%', :searchQuery, '%'))")
    Set<String> findAllByCompanyName(String searchQuery);
}
