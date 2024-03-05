package com.sanctityofthelord.souldashboard.web.api;

import com.sanctityofthelord.souldashboard.dto.MoisDto;
import com.sanctityofthelord.souldashboard.utils.Constants;
import org.springframework.web.bind.annotation.*;

import java.util.List;


public interface MoisApi {

    @PostMapping(Constants.MOIS_ENDPOINT + "/enregistrer")
    MoisDto enregistrer(@RequestBody MoisDto dto);

    @GetMapping(Constants.MOIS_ENDPOINT)
    MoisDto findById(@RequestParam(value = "id", required = false) Integer id);

    @GetMapping(value = Constants.MOIS_ENDPOINT + "/tous", produces = "application/json")
    List<MoisDto> findAll();

    @DeleteMapping(Constants.MOIS_ENDPOINT + "/supprimer")
    void supprimer(@RequestParam(value="id",required=false) Integer id);

}
