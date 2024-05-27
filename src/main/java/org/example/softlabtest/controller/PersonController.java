package org.example.softlabtest.controller;

import org.example.softlabtest.dto.PersonDTO;
import org.example.softlabtest.entity.Person;
import org.example.softlabtest.service.api.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

/**
 * Контроллер для управления данными о людях.
 */
@RestController
@RequestMapping("/api/persons")
public class PersonController {

    private final PersonService personService;

    /**
     * Конструктор с автозаполнением зависимостей.
     *
     * @param personService Сервис для управления данными о людях.
     */
    @Autowired
    public PersonController(PersonService personService) {
        this.personService = personService;
    }

    /**
     * Получает данные о человеке по его идентификатору.
     *
     * @param id Идентификатор человека.
     * @return Ответ с данными о человеке или статус 404, если человек не найден.
     */
    @GetMapping("/{id}")
    public ResponseEntity<PersonDTO> getPersonById(@PathVariable UUID id) {
        var person = personService.findById(id);
        if (person == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(person);
    }

    /**
     * Создает нового человека.
     *
     * @param personDTO DTO с данными для создания нового человека.
     * @return Ответ с данными о созданном человеке и статусом 201.
     */
    @PostMapping
    public ResponseEntity<PersonDTO> createPerson(@RequestBody PersonDTO personDTO) {
        var createdPerson = personService.createPerson(personDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdPerson);
    }

    /**
     * Обновляет данные о человеке.
     *
     * @param personDTO DTO с данными для обновления.
     * @return Ответ с обновленными данными о человеке или статус 404, если человек не найден.
     */
    @PutMapping("/{id}")
    public ResponseEntity<PersonDTO> updatePerson(@RequestBody PersonDTO personDTO) {
        var updatedPerson = personService.updatePerson(personDTO);
        if (updatedPerson == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(updatedPerson);
    }

    /**
     * Удаляет человека по его идентификатору.
     *
     * @param id Идентификатор человека для удаления.
     * @return Ответ с пустым телом и статусом 204.
     */
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletePerson(@PathVariable UUID id) {
        personService.deleteById(id);
        return ResponseEntity.noContent().build();
    }

    /**
     * Возвращает список всех людей.
     *
     * @return Ответ со списком всех людей.
     */
    @GetMapping
    public ResponseEntity<List<PersonDTO>> getAllPersons() {
        List<PersonDTO> personDTOs = personService.getAllPersons();
        return ResponseEntity.ok(personDTOs);
    }

    /**
     * Ищет людей по строке поиска и возвращает их в виде DTO.
     *
     * @param name имя для поиска.
     * @param email email для поиска.
     * @return Ответ со списком людей, соответствующих строке поиска.
     */
    @PostMapping("/search")
    public ResponseEntity<List<PersonDTO>> searchPersons(@RequestParam String name, @RequestParam String email) {
        List<PersonDTO> personDTOs = personService.searchPersons(name, email);
        return ResponseEntity.ok(personDTOs);
    }

    /**
     * Выполняет поиск и пагинацию сущностей {@link Person} с возможностью сортировки.
     *
     * @param page          номер страницы (начиная с 0).
     * @param size          количество элементов на странице.
     * @param sortField     поле, по которому будет осуществляться сортировка.
     * @param sortDirection направление сортировки (ASC или DESC).
     * @return страница с DTO объектов {@link PersonDTO}.
     */
    @GetMapping("/searchPage")
    public Page<PersonDTO> searchPersons(
            @RequestParam int page,
            @RequestParam int size,
            @RequestParam String sortField,
            @RequestParam String sortDirection) {
        return personService.searchPersons(page, size, sortField, sortDirection);
    }

}
