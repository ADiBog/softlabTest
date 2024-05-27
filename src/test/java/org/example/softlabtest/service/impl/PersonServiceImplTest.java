package org.example.softlabtest.service.impl;

import org.example.softlabtest.dto.PersonDTO;
import org.example.softlabtest.entity.Person;
import org.example.softlabtest.exception.NotFoundException;
import org.example.softlabtest.mapper.PersonMapper;
import org.example.softlabtest.repository.PersonRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

public class PersonServiceImplTest {

    @Mock
    private PersonRepository personRepository;

    @Mock
    private PersonMapper personMapper;

    @InjectMocks
    private PersonServiceImpl personService;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testFindById_Success() {
        // GIVEN
        UUID id = UUID.fromString("9734b87e-f674-4aaf-9d54-53ed6ebf30eb");
        Person person = new Person();
        person.setId(id);
        PersonDTO personDTO = PersonDTO.builder().id(UUID.fromString("9734b87e-f674-4aaf-9d54-53ed6ebf30eb")).build();

        when(personRepository.findById(id)).thenReturn(Optional.of(person));
        when(personMapper.toDTO(person)).thenReturn(personDTO);

        // WHEN
        PersonDTO result = personService.findById(id);

        // THEN
        assertNotNull(result);
        assertEquals(personDTO.getId(), result.getId());
    }

    @Test
    public void testFindById_NotFound() {
        // GIVEN
        UUID id = UUID.randomUUID();

        when(personRepository.findById(id)).thenReturn(Optional.empty());

        // WHEN|THEN
        assertThrows(NotFoundException.class, () -> personService.findById(id));
    }

    @Test
    public void testDeleteById() {
        // GIVEN
        UUID id = UUID.randomUUID();

        doNothing().when(personRepository).deleteById(id);

        // WHEN
        personService.deleteById(id);

        // THEN
        verify(personRepository, times(1)).deleteById(id);
    }

    @Test
    public void testUpdatePerson() {
        // GIVEN
        PersonDTO personDTO = PersonDTO.builder().build();
        Person person = new Person();

        when(personRepository.findById(personDTO.getId())).thenReturn(Optional.of(person));
        when(personMapper.toEntity(personDTO)).thenReturn(person);
        when(personRepository.save(person)).thenReturn(person);
        when(personMapper.toDTO(person)).thenReturn(personDTO);

        // WHEN
        PersonDTO result = personService.updatePerson(personDTO);

        // THEN
        assertNotNull(result);
        assertEquals(personDTO.getId(), result.getId());
    }

    @Test
    public void testCreatePerson() {
        // GIVEN
        PersonDTO personDTO = PersonDTO.builder().build();
        Person person = new Person();

        when(personMapper.toEntity(personDTO)).thenReturn(person);
        when(personRepository.save(person)).thenReturn(person);
        when(personMapper.toDTO(person)).thenReturn(personDTO);

        // WHEN
        PersonDTO result = personService.createPerson(personDTO);

        // THEN
        assertNotNull(result);
        assertEquals(personDTO.getId(), result.getId());
    }

    @Test
    public void testGetAllPersons() {
        // GIVEN
        List<Person> persons = Arrays.asList(new Person(), new Person());

        when(personRepository.findAll()).thenReturn(persons);
        when(personMapper.toDTO(any(Person.class))).thenReturn(PersonDTO.builder().build());

        // WHEN
        List<PersonDTO> result = personService.getAllPersons();

        // THEN
        assertNotNull(result);
        assertEquals(2, result.size());
    }

    @Test
    public void testSearchPersons_ByNameOrEmail() {
        // GIVEN
        String name = "John";
        String email = "john@example.com";
        List<Person> persons = Arrays.asList(new Person(), new Person());

        when(personRepository.findByNameContainingIgnoreCaseOrEmailContainingIgnoreCase(name, email)).thenReturn(persons);
        when(personMapper.toDTO(any(Person.class))).thenReturn(PersonDTO.builder().build());

        // WHEN
        List<PersonDTO> result = personService.searchPersons(name, email);

        // THEN
        assertNotNull(result);
        assertEquals(2, result.size());
    }

    @Test
    public void testSearchPersons_WithPaginationAndSorting() {
        // GIVEN
        int page = 0;
        int size = 10;
        String sortField = "name";
        String sortDirection = "ASC";

        Pageable pageable = PageRequest.of(page, size);

        List<Person> persons = Arrays.asList(new Person(), new Person());

        Page<Person> personPage = new PageImpl<>(persons, pageable, persons.size());

        when(personRepository.findAll(any(Pageable.class))).thenReturn(personPage);

        // WHEN
        Page<PersonDTO> resultPage = personService.searchPersons(page, size, sortField, sortDirection);

        // THEN
        assertNotNull(resultPage);
        assertEquals(2, resultPage.getTotalElements());

    }
}