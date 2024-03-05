package com.sanctityofthelord.souldashboard.web;

import com.sanctityofthelord.souldashboard.dto.PaysDto;
import com.sanctityofthelord.souldashboard.services.PaysService;
import com.sanctityofthelord.souldashboard.web.api.PaysApi;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@Slf4j
public class PaysController implements PaysApi {

    private PaysService paysService;

    @Autowired
    public PaysController(PaysService paysService) {
        this.paysService = paysService;
    }

    @Override
    public PaysDto enregistrer(PaysDto dto) {
        return paysService.enregistrer(dto);
    }

    @Override
    public PaysDto findById(Integer id) {
        return paysService.findById(id);
    }

    @Override
    public List<PaysDto> findAll() {
        return paysService.findAll();
    }

    @Override
    public void supprimer(Integer id) {
        paysService.supprimer(id);
    }
}
