package com.sanctityofthelord.souldashboard.web;

import com.sanctityofthelord.souldashboard.dto.MoisDto;
import com.sanctityofthelord.souldashboard.services.MoisService;
import com.sanctityofthelord.souldashboard.web.api.MoisApi;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@Slf4j
public class MoisController implements MoisApi {

  private MoisService moisService;

  @Autowired
  public MoisController(MoisService moisService) {
    this.moisService = moisService;
  }

  @Override
  public MoisDto enregistrer(MoisDto dto) {
    return moisService.enregistrer(dto);
  }

  @Override
  public MoisDto findById(Integer id) {
    return moisService.findById(id);
  }

  @Override
  public List<MoisDto> findAll() {
    return moisService.findAll();
  }

  @Override
  public void supprimer(Integer id) {
    moisService.supprimer(id);
  }
}
