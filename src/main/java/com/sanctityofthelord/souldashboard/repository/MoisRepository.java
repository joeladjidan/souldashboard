package com.sanctityofthelord.souldashboard.repository;

import com.sanctityofthelord.souldashboard.dto.MoisDto;
import com.sanctityofthelord.souldashboard.model.Mois;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MoisRepository extends JpaRepository<Mois, Integer> {

    MoisDto findById(Integer id);

    void supprimer(Integer id);

}
