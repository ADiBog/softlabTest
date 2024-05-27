package org.example.softlabtest.controller;

import org.example.softlabtest.dto.PersonDTO;
import org.example.softlabtest.service.api.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Контроллер для управления операциями, связанными с людьми.
 */
@RestController
@RequestMapping("/api/persons")
public class PersonController {

    private final PersonService personService;

    @Autowired
    public PersonController(PersonService personService) {
        this.personService = personService;
    }

    /**
     * Получает список всех людей.
     *
     * @return ResponseEntity со списком всех людей.
     */
    @GetMapping
    public ResponseEntity<List<PersonDTO>> getAllPersons() {
        List<PersonDTO> personDTOs = personService.getAllPersons();
        return ResponseEntity.ok(personDTOs);
    }

    /**
     * Ищет людей по строке поиска.
     *
     * @param searchString строка поиска.
     * @return ResponseEntity со списком найденных людей.
     */
    @PostMapping("/search")
    public ResponseEntity<List<PersonDTO>> searchPersons(@RequestBody String searchString) {
        List<PersonDTO> personDTOs = personService.searchPersons(searchString);
        return ResponseEntity.ok(personDTOs);
    }
}