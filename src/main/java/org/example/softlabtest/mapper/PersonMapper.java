package org.example.softlabtest.mapper;

import org.example.softlabtest.dto.PersonDTO;
import org.example.softlabtest.entity.Person;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

/**
 * Интерфейс маппера для преобразования между сущностью Person и DTO PersonDTO.
 */
@Mapper(componentModel = "spring")
public interface PersonMapper {

    /**
     * Экземпляр маппера, предоставляемый MapStruct.
     */
    PersonMapper INSTANCE = Mappers.getMapper(PersonMapper.class);

    /**
     * Преобразует объект PersonDTO в объект Person.
     *
     * @param personDTO Объект PersonDTO для преобразования.
     * @return Преобразованный объект Person.
     */
    @Mapping(target = "id", source = "id")
    @Mapping(target = "name", source = "name")
    @Mapping(target = "email", source = "email")
    @Mapping(target = "bio", source = "bio")
    @Mapping(target = "skills", source = "skills")
    @Mapping(target = "experiences", source = "experiences")
    @Mapping(target = "education", source = "education")
    Person toEntity(PersonDTO personDTO);

    /**
     * Преобразует объект Person в объект PersonDTO.
     *
     * @param person Объект Person для преобразования.
     * @return Преобразованный объект PersonDTO.
     */
    @Mapping(target = "id", source = "id")
    @Mapping(target = "name", source = "name")
    @Mapping(target = "email", source = "email")
    @Mapping(target = "bio", source = "bio")
    @Mapping(target = "skills", source = "skills")
    @Mapping(target = "experiences", source = "experiences")
    @Mapping(target = "education", source = "education")
    PersonDTO toDTO(Person person);
}
