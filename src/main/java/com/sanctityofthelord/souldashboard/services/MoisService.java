package com.sanctityofthelord.souldashboard.services;

import com.sanctityofthelord.souldashboard.dto.MoisDto;

import java.util.List;

public interface MoisService {

  MoisDto enregistrer(MoisDto dto);

  MoisDto findById(Integer id);

  List<MoisDto> findAll();

  void supprimer(Integer id);
}
