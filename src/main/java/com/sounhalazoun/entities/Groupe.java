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
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Groupe implements Serializable {
    
    @Id @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id;
    private String nomG;
    
    @OneToMany(mappedBy="groupe",cascade= {CascadeType.REFRESH,CascadeType.PERSIST})
    private Collection<Eleve> eleves;

    @ManyToMany(mappedBy="groupe",cascade= {CascadeType.REFRESH,CascadeType.PERSIST})
    private Collection<Prof> profs;
    
    @ManyToOne( cascade= {CascadeType.REFRESH,CascadeType.PERSIST})
    private Filiere filiere;
    
    @ManyToOne( cascade= {CascadeType.REFRESH,CascadeType.PERSIST},fetch = FetchType.EAGER)
    private Niveau niveau;
    
    public Groupe( String nomG, Filiere filiere,Niveau niveau ) {
        this.nomG=nomG;
        this.filiere=filiere;
        this.niveau=niveau;
        
    }
}
