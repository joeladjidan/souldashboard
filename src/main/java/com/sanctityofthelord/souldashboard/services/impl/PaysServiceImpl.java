package com.sanctityofthelord.souldashboard.services.impl;

import com.sanctityofthelord.souldashboard.dto.PaysDto;
import com.sanctityofthelord.souldashboard.exception.EntityNotFoundException;
import com.sanctityofthelord.souldashboard.exception.ErrorCodes;
import com.sanctityofthelord.souldashboard.exception.InvalidEntityException;
import com.sanctityofthelord.souldashboard.repository.PaysRepository;
import com.sanctityofthelord.souldashboard.services.PaysService;
import com.sanctityofthelord.souldashboard.validator.PaysValidator;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;


@Service
@Slf4j
public class PaysServiceImpl implements PaysService {

  private PaysRepository paysRepository;

  @Autowired
  public PaysServiceImpl(PaysRepository paysRepository) {
    this.paysRepository = paysRepository;
  }

  @Override
  public PaysDto enregistrer(PaysDto dto) {
    List<String> errors = PaysValidator.validate(dto);
    if (!errors.isEmpty()) {
      log.error("Ames is not valid {}", dto);
      throw new InvalidEntityException("L'emission n'est pas valide", ErrorCodes.UTILISATEUR_NOT_VALID, errors);
    }

    return PaysDto.fromEntity(
            paysRepository.save(
              PaysDto.toEntity(dto)
        )
    );
  }

  @Override
  public PaysDto findById(Integer id) {
    if (id == null) {
       log.error("Pays ID is null");
       return null;
    }
    return paysRepository.findById(id);
  }

  @Override
  public List<PaysDto> findAll() {
    return paysRepository.findAll().stream()
        .map(PaysDto::fromEntity)
        .collect(Collectors.toList());
  }

  @Override
  public void supprimer(Integer id) {
    if (id == null) {
      log.error("Pays ID is null");
      return;
    }
    paysRepository.supprimer(id);
  }
}
