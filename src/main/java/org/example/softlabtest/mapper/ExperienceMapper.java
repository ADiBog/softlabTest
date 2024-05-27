package org.example.softlabtest.mapper;

import org.example.softlabtest.dto.ExperienceDTO;
import org.example.softlabtest.entity.Experience;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface ExperienceMapper {
    ExperienceMapper INSTANCE = Mappers.getMapper(ExperienceMapper.class);

    Experience toEntity(ExperienceDTO experienceDTO);
    ExperienceDTO toDTO(Experience experience);
}
