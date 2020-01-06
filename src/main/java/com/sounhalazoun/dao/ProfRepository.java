package com.sounhalazoun.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.web.bind.annotation.CrossOrigin;

import com.sounhalazoun.entities.Prof;

@RepositoryRestResource
@CrossOrigin("*")
public interface ProfRepository extends JpaRepository<Prof, Long>{
    Prof findByNom(@Param("nom") String nom);
    Prof findByEmail(@Param("email")String email);
    List<Prof> findByNomContains(@Param("mc") String mc);
}
