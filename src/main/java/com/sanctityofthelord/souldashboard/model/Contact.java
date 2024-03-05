package com.sanctityofthelord.souldashboard.model;

        import lombok.AllArgsConstructor;
        import lombok.Data;
        import lombok.EqualsAndHashCode;
        import lombok.NoArgsConstructor;
        import lombok.extern.jackson.Jacksonized;

        import javax.persistence.*;

@Jacksonized //missing
@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
@Entity
@Table(name = "sanctity_contact")
public class Contact extends AbstractEntity {

    /**
     *
     */
    private static final long serialVersionUID = 1L;

    @Column(name = "nom")
    private String nom;

    @Column(name = "prenom")
    private String prenom;

    @Column(name = "sujet_de_priere")
    private String message;

    @Column(name = "email")
    private String email;

    @Column(name = "telephone")
    private String telephone;

    @ManyToOne
    @JoinColumn(name = "sanctity_code_postale")
    private CodePostale codePostale;

    @ManyToOne
    @JoinColumn(name = "sanctity_pays")
    private Pays pays;

    @ManyToOne
    @JoinColumn(name = "sanctity_ville")
    private Ville ville;
}
