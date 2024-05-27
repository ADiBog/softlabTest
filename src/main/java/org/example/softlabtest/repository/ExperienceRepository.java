package org.example.softlabtest.repository;

import org.example.softlabtest.entity.Experience;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Set;
import java.util.UUID;

/**
 * Репозиторий для управления сущностями Experience.
 */
@Repository
public interface ExperienceRepository extends JpaRepository<Experience, UUID> {

    /**
     * Находит все уникальные названия компаний, которые содержат заданный поисковый запрос.
     *
     * @param searchQuery Поисковый запрос для поиска компаний.
     * @return Набор уникальных названий компаний.
     */
    @Query("SELECT DISTINCT e.company FROM Experience e WHERE UPPER(e.company) LIKE UPPER(CONCAT('%', :searchQuery, '%'))")
    Set<String> findAllByCompanyName(String searchQuery);
}
