package com.sanctityofthelord.souldashboard.repository;

import com.sanctityofthelord.souldashboard.dto.PaysDto;
import com.sanctityofthelord.souldashboard.model.Pays;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface PaysRepository extends JpaRepository<Pays, Integer> {
    Optional<Pays> findByIntitule(String intitule);
    PaysDto findById(Integer id);
    void supprimer(Integer id);
}
