package org.example.softlabtest.repository;

import org.example.softlabtest.entity.Skill;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Set;
import java.util.UUID;

/**
 * Репозиторий для управления сущностями Skill.
 */
@Repository
public interface SkillRepository extends JpaRepository<Skill, UUID> {

    /**
     * Находит все уникальные названия навыков, которые начинаются с заданного поискового запроса.
     *
     * @param searchQuery Поисковый запрос для поиска навыков.
     * @return Набор уникальных названий навыков.
     */
    @Query("SELECT DISTINCT sk.name FROM Skill sk WHERE UPPER(sk.name) LIKE UPPER(CONCAT(:searchQuery,'%'))")
    Set<String> findAllByName(String searchQuery);
}
