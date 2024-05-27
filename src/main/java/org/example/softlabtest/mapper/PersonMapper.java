package org.example.softlabtest.mapper;

import org.example.softlabtest.dto.PersonDTO;
import org.example.softlabtest.model.Person;

public class PersonMapper {

    public static PersonDTO toDTO(Person person) {
        if (person == null) {
            return null;
        }
        PersonDTO dto = new PersonDTO();
        dto.setId(person.getId());
        dto.setName(person.getName());
        dto.setEmail(person.getEmail());
        dto.setBio(person.getBio());
        return dto;
    }

    public static Person toEntity(PersonDTO dto) {
        if (dto == null) {
            return null;
        }
        Person person = new Person();
        person.setId(dto.getId());
        person.setName(dto.getName());
        person.setEmail(dto.getEmail());
        person.setBio(dto.getBio());
        return person;
    }
}
