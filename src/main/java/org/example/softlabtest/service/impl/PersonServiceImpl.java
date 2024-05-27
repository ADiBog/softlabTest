package org.example.softlabtest.service.impl;

import org.example.softlabtest.entity.Person;
import org.example.softlabtest.repository.PersonRepository;
import org.example.softlabtest.service.api.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class PersonServiceImpl implements PersonService {

    @Autowired
    private PersonRepository personRepository;

    @Override
    public Person findById(UUID id) {
        return personRepository.findById(id).orElse(null);
    }

    @Override
    public Person save(Person person) {
        return personRepository.save(person);
    }

    @Override
    public void deleteById(UUID id) {
        personRepository.deleteById(id);
    }

    @Override
    public List<Person> findAll() {
        return personRepository.findAll();
    }

    @Override
    public List<Person> searchByString(String searchString) {
        return personRepository.findByNameContainingIgnoreCaseOrEmailContainingIgnoreCase(searchString, searchString);
    }
}