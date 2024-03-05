package com.sanctityofthelord.souldashboard.repository;

import com.sanctityofthelord.souldashboard.dto.ContactDto;
import com.sanctityofthelord.souldashboard.model.Contact;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ContactRepository extends JpaRepository<Contact, Integer> {
   void deleteById(Integer id);
   ContactDto findById(Integer id);

}
