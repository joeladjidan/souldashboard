package com.sanctityofthelord.souldashboard.services.impl;

import com.sanctityofthelord.souldashboard.dto.CiviliteDto;
import com.sanctityofthelord.souldashboard.exception.EntityNotFoundException;
import com.sanctityofthelord.souldashboard.exception.ErrorCodes;
import com.sanctityofthelord.souldashboard.exception.InvalidEntityException;
import com.sanctityofthelord.souldashboard.repository.CiviliteRepository;
import com.sanctityofthelord.souldashboard.services.CiviliteService;
import com.sanctityofthelord.souldashboard.validator.CiviliteValidator;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;


@Service
@Slf4j
public class CiviliteServiceImpl implements CiviliteService {

  private CiviliteRepository civiliteRepository;

  @Autowired
  public CiviliteServiceImpl(CiviliteRepository civiliteRepository) {
    this.civiliteRepository = civiliteRepository;
  }

  @Override
  public CiviliteDto enregistrer(CiviliteDto dto) {
    List<String> errors = CiviliteValidator.validate(dto);
    if (!errors.isEmpty()) {
      log.error("Civilite is not valid {}", dto);
      throw new InvalidEntityException("L'emission n'est pas valide", ErrorCodes.UTILISATEUR_NOT_VALID, errors);
    }

    return CiviliteDto.fromEntity(
            civiliteRepository.save(
              CiviliteDto.toEntity(dto)
        )
    );
  }

  @Override
  public CiviliteDto findById(Integer id) {
    if (id == null) {
      log.error("Civilite ID is null");
      return null;
    }
    return civiliteRepository.findById(id);
  }

  @Override
  public List<CiviliteDto> findAll() {
    return civiliteRepository.findAll().stream()
        .map(CiviliteDto::fromEntity)
        .collect(Collectors.toList());
  }

  @Override
  public void supprimer(Integer id) {
    if (id == null) {
      log.error("Civilite ID is null");
      return;
    }
    civiliteRepository.supprimer(id);
  }
}
