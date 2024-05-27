package org.example.softlabtest.service.api;

import org.example.softlabtest.dto.PersonDTO;
import org.example.softlabtest.entity.Person;
import org.springframework.data.domain.Page;

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
     * @param name  имя для поиска.
     * @param email email для поиска.
     * @return Список найденных пользователей в виде DTO.
     */
    List<PersonDTO> searchPersons(String name, String email);

    /**
     * Выполняет поиск и пагинацию сущностей {@link Person} с возможностью сортировки.
     *
     * @param page          номер страницы (начиная с 0).
     * @param size          количество элементов на странице.
     * @param sortField     поле, по которому будет осуществляться сортировка.
     * @param sortDirection направление сортировки (ASC или DESC).
     * @return страница с DTO объектов {@link PersonDTO}.
     * @throws IllegalArgumentException если переданы некорректные параметры сортировки.
     */
    Page<PersonDTO> searchPersons(int page, int size, String sortField, String sortDirection);
}
