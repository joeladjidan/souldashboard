package com.sanctityofthelord.souldashboard.web.api;

import com.sanctityofthelord.souldashboard.dto.PaysDto;
import com.sanctityofthelord.souldashboard.utils.Constants;
import org.springframework.web.bind.annotation.*;

import java.util.List;


public interface PaysApi {

  @PostMapping(Constants.PAYS_ENDPOINT + "/enregistrer")
  PaysDto enregistrer(@RequestBody PaysDto dto);

  @GetMapping(Constants.PAYS_ENDPOINT + "/{id}")
  PaysDto findById(@PathVariable("id") Integer id);

  @GetMapping(value = Constants.PAYS_ENDPOINT + "/tous", produces="application/json")
  List<PaysDto> findAll();

  @DeleteMapping(Constants.PAYS_ENDPOINT + "/supprimer/{id}")
  void supprimer(@PathVariable("id") Integer id);

}
