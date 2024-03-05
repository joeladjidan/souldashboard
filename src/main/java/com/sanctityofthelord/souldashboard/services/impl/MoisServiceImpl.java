package com.sanctityofthelord.souldashboard.services.impl;

import com.sanctityofthelord.souldashboard.dto.MoisDto;
import com.sanctityofthelord.souldashboard.exception.EntityNotFoundException;
import com.sanctityofthelord.souldashboard.exception.ErrorCodes;
import com.sanctityofthelord.souldashboard.exception.InvalidEntityException;
import com.sanctityofthelord.souldashboard.repository.MoisRepository;
import com.sanctityofthelord.souldashboard.validator.MoisValidator;
import com.sanctityofthelord.souldashboard.services.MoisService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;


@Service
@Slf4j
public class MoisServiceImpl implements MoisService {

  private MoisRepository moisRepository;

  @Autowired
  public MoisServiceImpl(MoisRepository moisRepository) {
    this.moisRepository = moisRepository;
  }

  @Override
  public MoisDto enregistrer(MoisDto dto) {
    List<String> errors = MoisValidator.validate(dto);
    if (!errors.isEmpty()) {
      log.error("Ames is not valid {}", dto);
      throw new InvalidEntityException("L'emission n'est pas valide", ErrorCodes.UTILISATEUR_NOT_VALID, errors);
    }

    return MoisDto.fromEntity(
            moisRepository.save(
              MoisDto.toEntity(dto)
        )
    );
  }

  @Override
  public MoisDto findById(Integer id) {
    if (id == null) {
      log.error("Mois ID is null");
      return null;
    }
    return moisRepository.findById(id);
  }

  @Override
  public List<MoisDto> findAll() {
    return moisRepository.findAll().stream()
        .map(MoisDto::fromEntity)
        .collect(Collectors.toList());
  }

  @Override
  public void supprimer(Integer id) {
    if (id == null) {
      log.error("Mois ID is null");
      return;
    }
    moisRepository.supprimer(id);
  }
}
