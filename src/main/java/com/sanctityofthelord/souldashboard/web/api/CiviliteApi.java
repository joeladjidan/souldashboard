package com.sanctityofthelord.souldashboard.web.api;

import com.sanctityofthelord.souldashboard.dto.CiviliteDto;
import com.sanctityofthelord.souldashboard.utils.Constants;
import org.springframework.web.bind.annotation.*;

import java.util.List;

public interface CiviliteApi {

  @PostMapping(Constants.CIVILITE_ENDPOINT + "/enregistrer")
  CiviliteDto enregistrer(@RequestBody CiviliteDto dto);

  @GetMapping(Constants.CIVILITE_ENDPOINT)
  CiviliteDto findById(@RequestParam(value="id",required=false) Integer id);

  @GetMapping(Constants.CIVILITE_ENDPOINT + "/tous")
  List<CiviliteDto> findAll();

  @DeleteMapping(Constants.CIVILITE_ENDPOINT + "/supprimer")
  void supprimer(@RequestParam(value="id",required=false) Integer id);

}
