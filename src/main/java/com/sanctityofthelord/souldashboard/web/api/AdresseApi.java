package com.sanctityofthelord.souldashboard.web.api;


import com.sanctityofthelord.souldashboard.dto.AdresseDto;
import com.sanctityofthelord.souldashboard.utils.Constants;
import org.springframework.web.bind.annotation.*;

import java.util.List;

public interface AdresseApi {

  @PostMapping(Constants.ADRESSE_ENDPOINT + "/enregistrer")
  AdresseDto enregistrer(@RequestBody AdresseDto dto);

  @GetMapping(Constants.ADRESSE_ENDPOINT)
  AdresseDto findById(@RequestParam(value="id",required=false) Integer id);

  @GetMapping(Constants.ADRESSE_ENDPOINT + "/tous")
  List<AdresseDto> findAll();

  @DeleteMapping(Constants.ADRESSE_ENDPOINT + "/supprimer")
  void supprimer(@RequestParam(value="id",required=false) Integer id);

}
