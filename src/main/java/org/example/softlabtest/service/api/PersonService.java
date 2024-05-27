package org.example.softlabtest.service.api;

import org.example.softlabtest.model.Person;

/**
 * Здесь должны быть доки номральные.
 */
public interface PersonService {

    Person findById(Long id);

    Person save(Person person);

    void deleteById(Long id);
}

