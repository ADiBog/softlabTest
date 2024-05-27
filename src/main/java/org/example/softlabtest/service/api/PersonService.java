package org.example.softlabtest.service.api;

import org.example.softlabtest.dto.PersonDTO;

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
    PersonDTO findById(UUID id);

    /**
     * Удалить пользователя по идентификатору.
     *
     * @param id Идентификатор пользователя.
     */
    void deleteById(UUID id);

    /**
     * Обновить информацию о пользователе.
     *
     * @param personDTO DTO с обновленной информацией о пользователе.
     * @return Обновленный пользователь.
     */
    PersonDTO updatePerson(PersonDTO personDTO);

    /**
     * Создать нового пользователя.
     *
     * @param personDTO DTO с информацией о новом пользователе.
     * @return Созданный пользователь.
     */
    PersonDTO createPerson(PersonDTO personDTO);

    /**
     * Получить всех пользователей в виде DTO.
     *
     * @return Список всех пользователей в виде DTO.
     */
    List<PersonDTO> getAllPersons();

    /**
     * Поиск пользователей по строке и возврат их в виде DTO.
     *
     * @param searchString Строка для поиска (по имени или email).
     * @return Список найденных пользователей в виде DTO.
     */
    List<PersonDTO> searchPersons(String searchString);
}
