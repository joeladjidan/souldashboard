package com.sanctityofthelord.souldashboard.web;

import com.sanctityofthelord.souldashboard.dto.AdresseDto;
import com.sanctityofthelord.souldashboard.services.AdresseService;
import com.sanctityofthelord.souldashboard.web.api.AdresseApi;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@Slf4j
public class AdresseController implements AdresseApi {

  private AdresseService adresseService;

  @Autowired
  public AdresseController(AdresseService adresseService) {
    this.adresseService = adresseService;
  }

  @Override
  public AdresseDto enregistrer(AdresseDto dto) {
    return adresseService.enregistrer(dto);
  }

  @Override
  public AdresseDto findById(Integer id) {
    return adresseService.findById(id);
  }

  @Override
  public List<AdresseDto> findAll() {
    return adresseService.findAll();
  }

  @Override
  public void supprimer(Integer id) {
    adresseService.supprimer(id);
  }
}
