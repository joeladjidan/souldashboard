package com.sanctityofthelord.souldashboard.services.impl;

import com.sanctityofthelord.souldashboard.exception.InvalidEntityException;
import com.sanctityofthelord.souldashboard.dto.CodePostaleDto;
import com.sanctityofthelord.souldashboard.exception.EntityNotFoundException;
import com.sanctityofthelord.souldashboard.exception.ErrorCodes;
import com.sanctityofthelord.souldashboard.repository.CodePostaleRepository;
import com.sanctityofthelord.souldashboard.services.CodePostaleService;
import com.sanctityofthelord.souldashboard.validator.CodePostaleValidator;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;


@Service
@Slf4j
public class CodePostaleServiceImpl implements CodePostaleService {

  private CodePostaleRepository codePostaleRepository;

  @Autowired
  public CodePostaleServiceImpl(CodePostaleRepository codePostaleRepository) {
    this.codePostaleRepository = codePostaleRepository;
  }

  @Override
  public CodePostaleDto enregistrer(CodePostaleDto dto) {
    List<String> errors = CodePostaleValidator.validate(dto);
    if (!errors.isEmpty()) {
      log.error("Ames is not valid {}", dto);
      throw new InvalidEntityException("L'emission n'est pas valide", ErrorCodes.UTILISATEUR_NOT_VALID, errors);
    }

    return CodePostaleDto.fromEntity(
            codePostaleRepository.save(
                    CodePostaleDto.toEntity(dto)
        )
    );
  }

  @Override
  public CodePostaleDto findById(Integer id) {
    if (id == null) {
      log.error("Annee ID is null");
      return null;
    }
    return codePostaleRepository.findById(id);
  }

  @Override
  public List<CodePostaleDto> findAll() {
    return codePostaleRepository.findAll().stream()
        .map(CodePostaleDto::fromEntity)
        .collect(Collectors.toList());
  }

  @Override
  public void supprimer(Integer id) {
    if (id == null) {
      log.error("Ames ID is null");
      return;
    }
    codePostaleRepository.supprimer(id);
  }
}
