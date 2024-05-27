package org.example.softlabtest.repository;

import org.example.softlabtest.model.Person;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<Person, Long> {
}
