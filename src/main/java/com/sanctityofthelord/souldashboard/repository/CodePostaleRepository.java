package com.sanctityofthelord.souldashboard.repository;

import com.sanctityofthelord.souldashboard.dto.CodePostaleDto;
import com.sanctityofthelord.souldashboard.model.CodePostale;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface CodePostaleRepository extends JpaRepository<CodePostale, Integer> {
    Optional<CodePostale> findByCode(String code);
    CodePostaleDto findById(Integer id);
    void supprimer(Integer id);
}
