package com.sounhalazoun.entities;

import java.io.Serializable;
import java.util.Collection;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;

import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
public class Filiere implements Serializable {
    @Id @GeneratedValue(strategy=GenerationType.IDENTITY)
   private Long id;
   private String nomF;
  @ManyToMany(cascade= {CascadeType.REFRESH,CascadeType.PERSIST})
  @JoinTable( name = "Fil_Mat", joinColumns = {@JoinColumn(name="fil_id") }, inverseJoinColumns = { @JoinColumn( name = "mat_id" ) } )
   private Collection<Matiere> matieres;
  @ManyToMany(cascade= {CascadeType.REFRESH,CascadeType.PERSIST})
  @JoinTable( name = "Fil_Niveau", joinColumns = {@JoinColumn(name="fil_id") }, inverseJoinColumns = { @JoinColumn( name = "niveau_id" ) } )
   private Collection<Niveau> niveaux;
  @OneToMany(mappedBy="filiere",cascade=CascadeType.ALL)
  private Collection<Groupe> groupes;
 
public Filiere( String nomF ) {
    super();
    this.nomF = nomF;
}
  

   
}
