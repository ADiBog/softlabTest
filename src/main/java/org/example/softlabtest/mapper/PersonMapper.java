package org.example.softlabtest.mapper;

import org.example.softlabtest.dto.PersonDTO;
import org.example.softlabtest.entity.Person;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface PersonMapper {
    PersonMapper INSTANCE = Mappers.getMapper(PersonMapper.class);

    Person toEntity(PersonDTO personDTO);
    PersonDTO toDTO(Person person);
}
