package com.sanctityofthelord.souldashboard.repository;

import com.sanctityofthelord.souldashboard.dto.VilleDto;
import com.sanctityofthelord.souldashboard.model.Ville;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface VilleRepository extends JpaRepository<Ville, Integer> {
    Optional<Ville> findByIntitule(String intitule);
    VilleDto findById(Integer id);
    void supprimer(Integer id);
}
