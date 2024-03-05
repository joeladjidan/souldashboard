package com.sanctityofthelord.souldashboard.web.api;

import com.sanctityofthelord.souldashboard.dto.ContactDto;
import com.sanctityofthelord.souldashboard.utils.Constants;
import org.springframework.web.bind.annotation.*;

import java.util.List;

public interface ContactApi {

  @PostMapping(Constants.CONTACT_ENDPOINT + "/enregistrer")
  ContactDto enregistrer(@RequestBody ContactDto dto);

  @GetMapping(Constants.CONTACT_ENDPOINT)
  ContactDto findById(@RequestParam(value="id",required=false) Integer id);

  @GetMapping(Constants.CONTACT_ENDPOINT + "/tous")
  List<ContactDto> findAll();

  @DeleteMapping(Constants.CONTACT_ENDPOINT + "/supprimer")
  void supprimer(@RequestParam(value="id",required=false) Integer id);

}
