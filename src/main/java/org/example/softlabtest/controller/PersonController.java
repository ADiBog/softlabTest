package org.example.softlabtest.controller;

import org.example.softlabtest.dto.PersonDTO;
import org.example.softlabtest.mapper.PersonMapper;
import org.example.softlabtest.entity.Person;
import org.example.softlabtest.service.api.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/persons")
public class PersonController {

    private final PersonService personService;

    @Autowired
    public PersonController(PersonService personService) {
        this.personService = personService;
    }

    @GetMapping("/{id}")
    public ResponseEntity<PersonDTO> getPersonById(@PathVariable UUID id) {
        Person person = personService.findById(id);
        if (person == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(PersonMapper.INSTANCE.toDTO(person));
    }

    @PostMapping
    public ResponseEntity<PersonDTO> createPerson(@RequestBody PersonDTO personDTO) {
        Person person = PersonMapper.INSTANCE.toEntity(personDTO);
        Person createdPerson = personService.save(person);
        return ResponseEntity.status(HttpStatus.CREATED).body(PersonMapper.INSTANCE.toDTO(createdPerson));
    }

    @PutMapping("/{id}")
    public ResponseEntity<PersonDTO> updatePerson(@PathVariable UUID id, @RequestBody PersonDTO personDTO) {
        Person existingPerson = personService.findById(id);
        if (existingPerson == null) {
            return ResponseEntity.notFound().build();
        }
        existingPerson.setName(personDTO.getName());
        existingPerson.setEmail(personDTO.getEmail());
        existingPerson.setBio(personDTO.getBio());
        Person updatedPerson = personService.save(existingPerson);
        return ResponseEntity.ok(PersonMapper.INSTANCE.toDTO(updatedPerson));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletePerson(@PathVariable UUID id) {
        personService.deleteById(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping
    public ResponseEntity<List<PersonDTO>> getAllPersons() {
        List<Person> persons = personService.findAll();
        List<PersonDTO> personDTOs = persons.stream()
                .map(PersonMapper.INSTANCE::toDTO)
                .collect(Collectors.toList());
        return ResponseEntity.ok(personDTOs);
    }

    @PostMapping("/search")
    public ResponseEntity<List<PersonDTO>> searchPersons(@RequestBody String searchString) {
        List<Person> persons = personService.searchByString(searchString);
        List<PersonDTO> personDTOs = persons.stream()
                .map(PersonMapper.INSTANCE::toDTO)
                .collect(Collectors.toList());
        return ResponseEntity.ok(personDTOs);
    }
}