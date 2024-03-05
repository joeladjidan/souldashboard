package com.sanctityofthelord.souldashboard.services;

import com.sanctityofthelord.souldashboard.dto.VilleDto;

import java.util.List;

public interface VilleService {

  VilleDto enregistrer(VilleDto dto);

  VilleDto findById(Integer id);

  List<VilleDto> findAll();

  void supprimer(Integer id);
}
