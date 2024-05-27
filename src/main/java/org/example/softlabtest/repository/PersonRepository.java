package org.example.softlabtest.repository;

import org.example.softlabtest.entity.Person;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.UUID;

/**
 * Репозиторий для управления сущностями Person.
 */
public interface PersonRepository extends JpaRepository<Person, UUID> {

    /**
     * Находит всех людей, чьи имена или электронные почты содержат заданный поисковый запрос (без учета регистра).
     *
     * @param name  Поисковый запрос для имени.
     * @param email Поисковый запрос для электронной почты.
     * @return Список людей, удовлетворяющих критериям поиска.
     */
    List<Person> findByNameContainingIgnoreCaseOrEmailContainingIgnoreCase(String name, String email);
}
