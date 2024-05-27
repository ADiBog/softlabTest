package org.example.softlabtest.service.api.dictionary;

import java.util.Set;

/**
 * Интерфейс для сервиса получения информации об образовании.
 */
public interface EducationService {
    /**
     * Получить все доступные университеты.
     *
     * @return Все найденные университеты.
     */
    Set<String> getUniversities();

    /**
     * Поиск университетов по строке запроса.
     *
     * @param searchQuery Строка для поиска университетов.
     * @return Все найденные университеты, соответствующие строке запроса.
     */
    Set<String> getUniversities(String searchQuery);
}
