package org.example.softlabtest.repository;

import org.example.softlabtest.entity.Skill;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Set;
import java.util.UUID;

@Repository
public interface SkillRepository extends JpaRepository<Skill, UUID> {
    @Query("SELECT DISTINCT sk.name FROM Skill sk WHERE UPPER(sk.name) LIKE UPPER(CONCAT(:searchQuery,'%'))")
    Set<String> findAllByName(String searchQuery);
}
