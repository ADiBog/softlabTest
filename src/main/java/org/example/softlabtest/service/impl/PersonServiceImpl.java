package org.example.softlabtest.service.impl;

import lombok.RequiredArgsConstructor;
import org.example.softlabtest.model.Person;
import org.example.softlabtest.repository.PersonRepository;
import org.example.softlabtest.service.api.PersonService;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class PersonServiceImpl implements PersonService {
    private final PersonRepository personRepository;

    public Person findById(Long id) {
        return personRepository.findById(id).orElse(null);
    }

    public Person save(Person person) {
        return personRepository.save(person);
    }

    public void deleteById(Long id) {
        personRepository.deleteById(id);
    }
}

