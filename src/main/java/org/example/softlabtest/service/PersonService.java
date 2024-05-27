package org.example.softlabtest.service;

import org.example.softlabtest.model.Person;
import org.example.softlabtest.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Здесь должны быть доки номральные.
 */
public interface PersonService {

    Person findById(Long id);

    Person save(Person person);

    void deleteById(Long id);
}

