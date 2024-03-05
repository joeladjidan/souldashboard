package com.sanctityofthelord.souldashboard.services;

import com.sanctityofthelord.souldashboard.dto.ContactDto;

import java.util.List;

public interface ContactService {

  ContactDto enregistrer(ContactDto dto);

  ContactDto modifier(Integer id, ContactDto dto);

  ContactDto findById(Integer id);

  List<ContactDto> findAll();

  void supprimer(Integer id);
}
