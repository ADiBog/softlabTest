package org.example.softlabtest.service.api.dictionary;

import java.util.Set;

/**
 * Интерфейс для сервиса получения информации о навыках.
 */
public interface SkillService {

    /**
     * Получить все доступные навыки.
     *
     * @return Набор всех доступных навыков.
     */
    Set<String> getSkills();

    /**
     * Поиск навыков по строке запроса.
     *
     * @param searchQuery Строка для поиска навыков.
     * @return Набор найденных навыков, соответствующих строке запроса.
     */
    Set<String> getSkill(String searchQuery);
}
