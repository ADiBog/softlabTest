package org.example.softlabtest.service.impl;

import java.util.Set;
import java.util.stream.Collectors;

import lombok.RequiredArgsConstructor;
import org.example.softlabtest.repository.SkillRepository;
import org.example.softlabtest.service.api.SkillService;
import org.springframework.stereotype.Service;

//Хуяришь такой же сервис для интересов
@Service
@RequiredArgsConstructor
public class SkillServiceImpl implements SkillService {

  private final SkillRepository skillRepository;

  @Override
  public Set<String> getSkills() {
    return skillRepository.findAll().stream().map(it -> it.getName()).distinct().collect(Collectors.toSet());
  }
}
