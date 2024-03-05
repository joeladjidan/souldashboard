package com.sanctityofthelord.souldashboard.services;

import com.sanctityofthelord.souldashboard.dto.CiviliteDto;

import java.util.List;

public interface CiviliteService {

  CiviliteDto enregistrer(CiviliteDto dto);

  CiviliteDto findById(Integer id);

  List<CiviliteDto> findAll();

  void supprimer(Integer id);
}
