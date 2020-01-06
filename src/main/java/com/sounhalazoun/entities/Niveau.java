package com.sounhalazoun.entities;

import java.io.Serializable;
import java.util.Collection;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Niveau implements Serializable{
    @Id @GeneratedValue(strategy=GenerationType.IDENTITY)
    private long id;
    private String nomN;
    @ManyToMany(mappedBy="niveaux",cascade= {CascadeType.REFRESH,CascadeType.PERSIST})
    private Collection<Filiere> filieres;
    @OneToMany(mappedBy="niveau",cascade=CascadeType.ALL,fetch=FetchType.LAZY )
    private Collection<Groupe> groupe;
    public Niveau( String nomN ) {
        super();
        this.nomN = nomN;
    }
    
}
