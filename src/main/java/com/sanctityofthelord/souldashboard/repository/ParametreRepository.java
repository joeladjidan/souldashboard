package com.sanctityofthelord.souldashboard.repository;

import com.sanctityofthelord.souldashboard.model.Parametre;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ParametreRepository extends JpaRepository<Parametre, Integer> {
    Optional<Parametre> findByChemin(String chemin);
}
