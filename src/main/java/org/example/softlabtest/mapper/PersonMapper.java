package org.example.softlabtest.mapper;

import org.example.softlabtest.dto.PersonDTO;
import org.example.softlabtest.entity.Person;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

/**
 * Интерфейс маппера для преобразования между сущностью Person и DTO PersonDTO.
 */
@Mapper(componentModel = "spring")
public interface PersonMapper {

    /**
     * Преобразует объект PersonDTO в объект Person.
     *
     * @param personDTO Объект PersonDTO для преобразования.
     * @return Преобразованный объект Person.
     */
    Person toEntity(PersonDTO personDTO);

    /**
     * Преобразует объект Person в объект PersonDTO.
     *
     * @param person Объект Person для преобразования.
     * @return Преобразованный объект PersonDTO.
     */
    PersonDTO toDTO(Person person);

    List<PersonDTO> toListDTO(List<Person> persons);
}
