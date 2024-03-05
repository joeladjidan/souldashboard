package com.sanctityofthelord.souldashboard.repository;

import com.sanctityofthelord.souldashboard.dto.AdresseDto;
import com.sanctityofthelord.souldashboard.model.Adresse;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;

public interface AdresseRepository extends JpaRepository<Adresse, Integer> {
    Optional<Adresse> findByAdresse1(String adresse1);
    void deleteById(Integer id);
    AdresseDto findById(Integer id);
}
