package org.example.softlabtest.repository;

import org.example.softlabtest.entity.Education;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Set;
import java.util.UUID;

/**
 * Репозиторий для управления сущностями Education.
 */
@Repository
public interface EducationRepository extends JpaRepository<Education, UUID> {

    /**
     * Находит все уникальные названия университетов, которые начинаются с заданного поискового запроса.
     *
     * @param searchQuery Поисковый запрос для поиска университетов.
     * @return Набор уникальных названий университетов.
     */
    @Query("SELECT DISTINCT e.university FROM Education e WHERE UPPER(e.university) LIKE UPPER(CONCAT(:searchQuery,'%'))")
    Set<String> findAllByInstitutionName(String searchQuery);
}
