package com.sanctityofthelord.souldashboard.web;

import com.sanctityofthelord.souldashboard.dto.CodePostaleDto;
import com.sanctityofthelord.souldashboard.services.CodePostaleService;
import com.sanctityofthelord.souldashboard.web.api.CodePostaleApi;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@Slf4j
public class CodePostaleController implements CodePostaleApi {

  private CodePostaleService codePostaleService;

  @Autowired
  public CodePostaleController(CodePostaleService codePostaleService) {
    this.codePostaleService = codePostaleService;
  }

  @Override
  public CodePostaleDto enregistrer(CodePostaleDto dto) {
    return codePostaleService.enregistrer(dto);
  }

  @Override
  public CodePostaleDto findById(Integer id) {
    return codePostaleService.findById(id);
  }

  @Override
  public List<CodePostaleDto> findAll() {
    return codePostaleService.findAll();
  }

  @Override
  public void supprimer(Integer id) {
    codePostaleService.supprimer(id);
  }
}
