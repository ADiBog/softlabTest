package org.example.softlabtest.service.api;

import org.example.softlabtest.entity.Person;

import java.util.List;
import java.util.UUID;

/**
 * Интерфейс для сервиса управления пользователями.
 */
public interface PersonService {

    /**
     * Найти пользователя по идентификатору.
     *
     * @param id Идентификатор пользователя.
     * @return Найденный пользователь или null, если пользователь не найден.
     */
    Person findById(UUID id);

    /**
     * Сохранить пользователя.
     *
     * @param person Пользователь для сохранения.
     * @return Сохраненный пользователь.
     */
    Person save(Person person);

    /**
     * Удалить пользователя по идентификатору.
     *
     * @param id Идентификатор пользователя.
     */
    void deleteById(UUID id);

    /**
     * Найти всех пользователей.
     *
     * @return Список всех пользователей.
     */
    List<Person> findAll();

    /**
     * Поиск пользователей по строке.
     *
     * @param searchString Строка для поиска (по имени или email).
     * @return Список найденных пользователей.
     */
    List<Person> searchByString(String searchString);
}
