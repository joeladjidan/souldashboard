package com.sanctityofthelord.souldashboard.services.impl;

import com.sanctityofthelord.souldashboard.dto.VilleDto;
import com.sanctityofthelord.souldashboard.exception.EntityNotFoundException;
import com.sanctityofthelord.souldashboard.exception.ErrorCodes;
import com.sanctityofthelord.souldashboard.exception.InvalidEntityException;
import com.sanctityofthelord.souldashboard.repository.VilleRepository;
import com.sanctityofthelord.souldashboard.services.VilleService;
import com.sanctityofthelord.souldashboard.validator.VilleValidator;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;


@Service
@Slf4j
public class VilleServiceImpl implements VilleService {

  private VilleRepository villeRepository;

  @Autowired
  public VilleServiceImpl(VilleRepository villeRepository) {
    this.villeRepository = villeRepository;
  }

  @Override
  public VilleDto enregistrer(VilleDto dto) {
    List<String> errors = VilleValidator.validate(dto);
    if (!errors.isEmpty()) {
      log.error("Ames is not valid {}", dto);
      throw new InvalidEntityException("L'emission n'est pas valide", ErrorCodes.UTILISATEUR_NOT_VALID, errors);
    }

    return VilleDto.fromEntity(
            villeRepository.save(
                    VilleDto.toEntity(dto)
        )
    );
  }

  @Override
  public VilleDto findById(Integer id) {
    if (id == null) {
       log.error("Ville ID is null");
       return null;
    }
    return villeRepository.findById(id);
  }

  @Override
  public List<VilleDto> findAll() {
    return villeRepository.findAll().stream()
        .map(VilleDto::fromEntity)
        .collect(Collectors.toList());
  }

  @Override
  public void supprimer(Integer id) {
    if (id == null) {
      log.error("Pays ID is null");
      return;
    }
    villeRepository.supprimer(id);
  }
}
