package org.example.softlabtest.mapper;

import org.example.softlabtest.dto.EducationDTO;
import org.example.softlabtest.entity.Education;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface EducationMapper {
    EducationMapper INSTANCE = Mappers.getMapper(EducationMapper.class);

    Education toEntity(EducationDTO educationDTO);
    EducationDTO toDTO(Education education);
}
