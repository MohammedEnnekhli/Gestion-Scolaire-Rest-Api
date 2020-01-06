package com.sounhalazoun.entities;

import java.util.Date;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@DiscriminatorValue("Emp")
@Data
@NoArgsConstructor
@EqualsAndHashCode(callSuper=false)
@Entity
public class Emp extends Personne{
    private String fonction;
    private double salaire;
    public Emp( Long id, String nom, String prenom, String adresse, String sexe, String tel, String email,
            Date dateNaissance, Date dateAffiliation, String fonction, double salaire ) {
        super( id, nom, prenom, adresse, sexe, tel, email, dateNaissance, dateAffiliation );
        this.fonction = fonction;
        this.salaire = salaire;
    }
    

}
