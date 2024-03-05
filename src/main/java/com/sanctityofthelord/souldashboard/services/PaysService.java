package com.sanctityofthelord.souldashboard.services;

import com.sanctityofthelord.souldashboard.dto.PaysDto;

import java.util.List;

public interface PaysService {

  PaysDto enregistrer(PaysDto dto);

  PaysDto findById(Integer id);

  List<PaysDto> findAll();

  void supprimer(Integer id);
}
