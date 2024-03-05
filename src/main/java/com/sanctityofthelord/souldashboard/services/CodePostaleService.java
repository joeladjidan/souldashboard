package com.sanctityofthelord.souldashboard.services;

import com.sanctityofthelord.souldashboard.dto.CodePostaleDto;

import java.util.List;

public interface CodePostaleService {

  CodePostaleDto enregistrer(CodePostaleDto dto);

  CodePostaleDto findById(Integer id);

  List<CodePostaleDto> findAll();

  void supprimer(Integer id);
}
