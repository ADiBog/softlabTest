package org.example.softlabtest.service.api.dictionary;

import java.util.Set;

/**
 * Интерфейс для сервиса получения информации об опыте работы.
 */
public interface ExperienceService {
    /**
     * Получить все доступные компании.
     *
     * @return Все найденные компаний.
     */
    Set<String> getCompanies();

    /**
     * Поиск компаний по строке запроса.
     *
     * @param searchQuery Строка для поиска компаний.
     * @return Все найденные компаний, соответствующие строке запроса.
     */
    Set<String> getCompanies(String searchQuery);
}
