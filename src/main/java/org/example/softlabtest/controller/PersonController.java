package org.example.softlabtest.controller;

import org.example.softlabtest.dto.PersonDTO;
import org.example.softlabtest.mapper.PersonMapper;
import org.example.softlabtest.model.Person;
import org.example.softlabtest.service.api.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/persons")
public class PersonController {

    @Autowired
    private PersonService personService;

    @GetMapping("/{id}")
    public ResponseEntity<PersonDTO> getPersonById(@PathVariable Long id) {
        Person person = personService.findById(id);
        if (person == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(PersonMapper.toDTO(person));
    }

    @PostMapping
    public ResponseEntity<PersonDTO> createPerson(@RequestBody PersonDTO personDTO) {
        Person person = PersonMapper.toEntity(personDTO);
        Person createdPerson = personService.save(person);
        return ResponseEntity.status(HttpStatus.CREATED).body(PersonMapper.toDTO(createdPerson));
    }

    @PutMapping("/{id}")
    public ResponseEntity<PersonDTO> updatePerson(@PathVariable Long id, @RequestBody PersonDTO personDTO) {
        Person existingPerson = personService.findById(id);
        if (existingPerson == null) {
            return ResponseEntity.notFound().build();
        }
        existingPerson.setName(personDTO.getName());
        existingPerson.setEmail(personDTO.getEmail());
        existingPerson.setBio(personDTO.getBio());
        Person updatedPerson = personService.save(existingPerson);
        return ResponseEntity.ok(PersonMapper.toDTO(updatedPerson));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletePerson(@PathVariable Long id) {
        personService.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}

