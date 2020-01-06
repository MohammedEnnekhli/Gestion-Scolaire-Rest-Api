package com.sounhalazoun.entities;


import java.util.Collection;
import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Entity
@DiscriminatorValue( "Prof" )
@Data
@NoArgsConstructor
@EqualsAndHashCode(callSuper=false)
public class Prof extends Personne{
    @ManyToOne
    @JoinColumn(name="matiere_id")
    private Matiere matiere;
    @ManyToMany(cascade= {CascadeType.REFRESH,CascadeType.PERSIST})
    @JoinTable( name = "Prof_Groupe", joinColumns = {@JoinColumn(name="prof_id") }, inverseJoinColumns = { @JoinColumn( name = "groupe_id" ) } )
    private Collection<Groupe> groupe;



    public Prof( Long id, String nom, String prenom, String adresse, String sexe, String tel, String email,
            Date dateNaissance, Date dateAffiliation, Matiere matiere ) {
        super( id, nom, prenom, adresse, sexe, tel, email, dateNaissance, dateAffiliation );
        this.matiere = matiere;
    }

   
    
    

}
