package com.sounhalazoun.entities;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@EqualsAndHashCode(callSuper=false)
@DiscriminatorValue( "Eleve" )
public class Eleve extends Personne {

    private String lieuNaissance;
    private String nomResp;
    private String prenomResp;
    private String telResp;
    private Boolean isTransp;

    @ManyToOne(cascade= {CascadeType.REFRESH,CascadeType.PERSIST})
    @JoinColumn(name="groupe_id")
    private Groupe groupe;

    public Eleve( Long id, String nom, String prenom, String adresse, String sexe, String tel, String email,
            Date dateNaissance, Date dateAffiliation, String lieuNaissance, String nomResp, String prenomResp,
            String telResp, Boolean isTransp, Groupe groupe ) {
        super( id, nom, prenom, adresse, sexe, tel, email, dateNaissance, dateAffiliation );
        this.lieuNaissance = lieuNaissance;
        this.nomResp = nomResp;
        this.prenomResp = prenomResp;
        this.telResp = telResp;
        this.isTransp = isTransp;
        this.groupe=groupe;
    }
    public Eleve( Long id, String nom, String prenom, String adresse, String sexe, String tel, String email,
            Date dateNaissance, Date dateAffiliation, String lieuNaissance, String nomResp, String prenomResp,
            String telResp, Boolean isTransp) {
        super( id, nom, prenom, adresse, sexe, tel, email, dateNaissance, dateAffiliation );
        this.lieuNaissance = lieuNaissance;
        this.nomResp = nomResp;
        this.prenomResp = prenomResp;
        this.telResp = telResp;
        this.isTransp = isTransp;
    }
    
    

}
