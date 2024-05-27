package org.example.softlabtest.mapper;

import org.example.softlabtest.dto.SkillDTO;
import org.example.softlabtest.entity.Skill;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface SkillMapper {
    SkillMapper INSTANCE = Mappers.getMapper(SkillMapper.class);

    Skill toEntity(SkillDTO skillDTO);
    SkillDTO toDTO(Skill skill);
}
