package com.sanctityofthelord.souldashboard.web.api;

import com.sanctityofthelord.souldashboard.dto.VilleDto;
import com.sanctityofthelord.souldashboard.utils.Constants;
import org.springframework.web.bind.annotation.*;

import java.util.List;


  public interface VilleApi {

    @PostMapping(Constants.VILLE_ENDPOINT + "/enregistrer")
    VilleDto enregistrer(@RequestBody VilleDto dto);

    @GetMapping(Constants.VILLE_ENDPOINT)
    VilleDto findById(@RequestParam(value="id",required=false) Integer id);

    @GetMapping(Constants.VILLE_ENDPOINT + "/tous")
    List<VilleDto> findAll();

    @DeleteMapping(Constants.VILLE_ENDPOINT + "/supprimer")
    void supprimer(@RequestParam(value="id",required=false) Integer id);


}
