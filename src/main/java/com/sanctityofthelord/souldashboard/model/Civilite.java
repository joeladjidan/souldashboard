package com.sanctityofthelord.souldashboard.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
@Entity
@Table(name = "sanctity_civilite")
public class Civilite extends AbstractEntity {

  /**
	 *
	 */
	private static final long serialVersionUID = 1L;

  @Column(name = "intitule")
  private String intitule;


}
