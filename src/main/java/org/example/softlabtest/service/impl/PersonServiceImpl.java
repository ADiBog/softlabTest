package org.example.softlabtest.service.impl;

import lombok.RequiredArgsConstructor;
import org.example.softlabtest.dto.PersonDTO;
import org.example.softlabtest.entity.Person;
import org.example.softlabtest.exception.NotFoundException;
import org.example.softlabtest.mapper.PersonMapper;
import org.example.softlabtest.repository.PersonRepository;
import org.example.softlabtest.service.api.PersonService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

/**
 * Реализация сервиса для управления данными о людях.
 */
@Service
@RequiredArgsConstructor
public class PersonServiceImpl implements PersonService {

    private final PersonRepository personRepository;
    private final PersonMapper personMapper;

    /**
     * Находит человека по его идентификатору.
     *
     * @param id Идентификатор человека.
     * @return Найденный человек.
     * @throws NotFoundException если человек с указанным идентификатором не найден.
     */
    @Override
    public PersonDTO findById(UUID id) {
        return personRepository.findById(id).map(personMapper::toDTO).orElseThrow(() -> new NotFoundException("Не найдено"));
    }

    /**
     * Удаляет человека по его идентификатору.
     *
     * @param id Идентификатор человека для удаления.
     */
    @Override
    public void deleteById(UUID id) {
        personRepository.deleteById(id);
    }

    /**
     * Обновляет данные о человеке на основе переданного DTO.
     *
     * @param personDTO DTO с данными для обновления.
     * @return Обновленный объект человека.
     */
    @Override
    public PersonDTO updatePerson(PersonDTO personDTO) {
        Person existingPerson = personRepository.findById(personDTO.getId()).orElse(null);
        if (existingPerson == null) {
            return personDTO;
        }
        return Optional.of(personDTO).map(personMapper::toEntity).map(personRepository::save).map(personMapper::toDTO).orElse(null);
    }

    /**
     * Создает нового человека на основе переданного DTO.
     *
     * @param personDTO DTO с данными для создания нового человека.
     * @return Созданный объект человека.
     */
    @Override
    public PersonDTO createPerson(PersonDTO personDTO) {
        Person person = personMapper.toEntity(personDTO);
        return personMapper.toDTO(personRepository.save(person));
    }

    /**
     * Возвращает список всех людей в виде DTO.
     *
     * @return Список всех людей в виде DTO.
     */
    @Override
    public List<PersonDTO> getAllPersons() {
        List<Person> persons = personRepository.findAll();
        return persons.stream()
                .map(personMapper::toDTO)
                .collect(Collectors.toList());
    }

    /**
     * Ищет людей по строке поиска (имя или email).
     *
     * @param searchString Строка поиска.
     * @return Список людей в виде DTO, соответствующих строке поиска.
     */
    @Override
    public List<PersonDTO> searchPersons(String searchString) {
        List<Person> persons = personRepository.findByNameContainingIgnoreCaseOrEmailContainingIgnoreCase(searchString, searchString);
        return persons.stream()
                .map(personMapper::toDTO)
                .collect(Collectors.toList());
    }
}
