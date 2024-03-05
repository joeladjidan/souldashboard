package com.sanctityofthelord.souldashboard.validator;

import com.sanctityofthelord.souldashboard.dto.MoisDto;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.List;


public class MoisValidator {

  public static List<String> validate(MoisDto moisDto) {
    List<String> errors = new ArrayList<>();

    if (moisDto == null) {
      errors.add("Veuillez renseigner le nom d'utilisateur");
      errors.add("Veuillez renseigner le prenom d'utilisateur");
      return errors;
    }

    if (!StringUtils.hasLength(moisDto.getIntitule())) {
      errors.add("Veuillez renseigner l'intitule");
    }
    return errors;
  }

}
