package com.sanctityofthelord.souldashboard.repository;

import com.sanctityofthelord.souldashboard.dto.CiviliteDto;
import com.sanctityofthelord.souldashboard.model.Civilite;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CiviliteRepository extends JpaRepository<Civilite, Integer> {
    CiviliteDto findById(Integer id);
    void supprimer(Integer id);
}
