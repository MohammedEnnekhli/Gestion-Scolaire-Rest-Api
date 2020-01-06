package com.sounhalazoun.dao;

import java.util.List;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.web.bind.annotation.CrossOrigin;

import com.sounhalazoun.entities.Eleve;

@RepositoryRestResource
@CrossOrigin("*")
public interface EleveRepository extends JpaRepository<Eleve, Long>{
    Eleve findByNom(@Param("nom") String nom);
    Eleve findByEmail(@Param("email")String email);

}
