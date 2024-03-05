package com.sanctityofthelord.souldashboard.services.impl;

import com.sanctityofthelord.souldashboard.dto.ContactDto;
import com.sanctityofthelord.souldashboard.exception.EntityNotFoundException;
import com.sanctityofthelord.souldashboard.exception.ErrorCodes;
import com.sanctityofthelord.souldashboard.exception.InvalidEntityException;
import com.sanctityofthelord.souldashboard.repository.ContactRepository;
import com.sanctityofthelord.souldashboard.services.ContactService;
import com.sanctityofthelord.souldashboard.validator.ContactValidator;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;


@Service
@Slf4j
public class ContactServiceImpl implements ContactService {

  private ContactRepository contactRepository;

  @Autowired
  public ContactServiceImpl(ContactRepository contactRepository) {
    this.contactRepository = contactRepository;
  }

  @Override
  public ContactDto enregistrer(ContactDto dto) {
    List<String> errors = ContactValidator.validate(dto);
    if (!errors.isEmpty()) {
      log.error("Contact is not valid {}", dto);
      throw new InvalidEntityException("Le contact n'est pas valide", ErrorCodes.UTILISATEUR_NOT_VALID, errors);
    }

    return ContactDto.fromEntity(
            contactRepository.save(
                ContactDto.toEntity(dto)
        )
    );
  }

  @Override
  public ContactDto modifier(Integer id, ContactDto dto) {
      List<String> errors = ContactValidator.validate(dto);
      if (!errors.isEmpty()) {
          log.error("Contact is not valid {}", dto);
          throw new InvalidEntityException("Le contact n'est pas valide", ErrorCodes.UTILISATEUR_NOT_VALID, errors);
      }

      if (id == null) {
          log.error("Contact ID is null");
          return null;
      }
      ContactDto dtoUpdate = findById(id);

      if (dtoUpdate != null)
      {
          dtoUpdate.setNom(dto.getNom());
          dtoUpdate.setEmail(dto.getEmail());
          dtoUpdate.setPrenom(dto.getPrenom());
          dtoUpdate.setMessage(dto.getMessage());
          dtoUpdate.setTelephone(dto.getTelephone());
      }
    return ContactDto.fromEntity(
            contactRepository.save(
                ContactDto.toEntity(dtoUpdate)
        )
    );
  }

  @Override
  public ContactDto findById(Integer id) {
    if (id == null) {
      log.error("Contact ID is null");
      return null;
    }
    return contactRepository.findById(id);
  }

  @Override
  public List<ContactDto> findAll() {
    return contactRepository.findAll().stream()
        .map(ContactDto::fromEntity)
        .collect(Collectors.toList());
  }

  @Override
  public void supprimer(Integer id) {
    if (id == null) {
      log.error("Emission ID is null");
      return;
    }
    contactRepository.deleteById(id);
  }
}
