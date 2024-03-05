package com.sanctityofthelord.souldashboard.services.impl;

import com.sanctityofthelord.souldashboard.dto.AdresseDto;
import com.sanctityofthelord.souldashboard.exception.EntityNotFoundException;
import com.sanctityofthelord.souldashboard.exception.ErrorCodes;
import com.sanctityofthelord.souldashboard.exception.InvalidEntityException;
import com.sanctityofthelord.souldashboard.repository.AdresseRepository;
import com.sanctityofthelord.souldashboard.services.AdresseService;
import com.sanctityofthelord.souldashboard.validator.AdresseValidator;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;


@Service
@Slf4j
public class AdresseServiceImpl implements AdresseService {

  private AdresseRepository adresseRepository;

  @Autowired
  public AdresseServiceImpl(AdresseRepository adresseRepository) {
    this.adresseRepository = adresseRepository;
  }

  @Override
  public AdresseDto enregistrer(AdresseDto dto) {
    List<String> errors = AdresseValidator.validate(dto);
    if (!errors.isEmpty()) {
      log.error("Ames is not valid {}", dto);
      throw new InvalidEntityException("L'emission n'est pas valide", ErrorCodes.UTILISATEUR_NOT_VALID, errors);
    }

    return AdresseDto.fromEntity(
            adresseRepository.save(
                  AdresseDto.toEntity(dto)
        )
    );
  }

  @Override
  public AdresseDto findById(Integer id) {
    if (id == null) {
      log.error("Adresse ID is null");
      return null;
    }
    return adresseRepository.findById(id);
  }

  @Override
  public List<AdresseDto> findAll() {
    return adresseRepository.findAll()
        .stream()
        .map(AdresseDto::fromEntity)
        .collect(Collectors.toList());
  }

  @Override
  public void supprimer(Integer id) {
    if (id == null) {
      log.error("Ames ID is null");
      return;
    }
    adresseRepository.deleteById(id);
  }
}
