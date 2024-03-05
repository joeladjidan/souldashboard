package com.sanctityofthelord.souldashboard.web.api;

import com.sanctityofthelord.souldashboard.dto.CodePostaleDto;
import com.sanctityofthelord.souldashboard.utils.Constants;
import org.springframework.web.bind.annotation.*;

import java.util.List;


public interface CodePostaleApi {

  @PostMapping(Constants.CODE_POSTALE_ENDPOINT + "/enregistrer")
  CodePostaleDto enregistrer(@RequestBody CodePostaleDto dto);

  @GetMapping(Constants.CODE_POSTALE_ENDPOINT + "/{id}")
  CodePostaleDto findById(@PathVariable("id") Integer id);

  @GetMapping(Constants.CODE_POSTALE_ENDPOINT + "/tous")
  List<CodePostaleDto> findAll();

  @DeleteMapping(Constants.CODE_POSTALE_ENDPOINT + "/supprimer/{id}")
  void supprimer(@PathVariable("id") Integer id);

}
