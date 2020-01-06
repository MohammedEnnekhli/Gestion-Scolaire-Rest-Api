package com.sounhalazoun.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.web.bind.annotation.CrossOrigin;


import com.sounhalazoun.entities.Matiere;

@RepositoryRestResource
@CrossOrigin("*")
public interface MatiereRepository extends JpaRepository<Matiere, Long>{

}
