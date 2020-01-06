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

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data

@NoArgsConstructor
public class Matiere implements Serializable {
    @Id @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id;
    private String nomM;
    @ManyToMany(mappedBy="matieres",cascade= {CascadeType.REFRESH,CascadeType.PERSIST})
    private Collection<Filiere> filieres;
    @OneToMany(mappedBy="matiere",cascade= {CascadeType.REFRESH,CascadeType.PERSIST})
    private Collection<Prof> profs;
    public Matiere( String nomM ) {
        super();
        this.nomM = nomM;
    }
    

}
