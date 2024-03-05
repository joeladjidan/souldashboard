package com.sanctityofthelord.souldashboard.services;
import com.sanctityofthelord.souldashboard.dto.AdresseDto;

import java.util.List;

public interface AdresseService {

  AdresseDto enregistrer(AdresseDto dto);

  AdresseDto findById(Integer id);

  List<AdresseDto> findAll();

  void supprimer(Integer id);
}
