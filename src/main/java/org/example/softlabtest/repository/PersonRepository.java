package org.example.softlabtest.repository;

import org.example.softlabtest.entity.Person;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.UUID;

public interface PersonRepository extends JpaRepository<Person, UUID> {
    List<Person> findByNameContainingIgnoreCaseOrEmailContainingIgnoreCase(String name, String email);

    List<Person> findDistinctBySkills_NameIn(List<String> skillNames);
}