package com.sounhalazoun.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.web.bind.annotation.CrossOrigin;

import com.sounhalazoun.entities.Groupe;

@RepositoryRestResource(collectionResourceRel="groupes",path="groupes")
@CrossOrigin("*")
public interface GroupeRepository extends JpaRepository<Groupe, Long>{
    
    @Query("select g from Groupe g where g.filiere.id=?1 and g.niveau.id=?2")
    List<Groupe> findByFiliereAndNiveau(@Param("filiere") Long f,@Param("niveau") Long n);
    
    /*@Query("select filiere.id from Groupe g where g.nomG=?1")
    Long findByNomG(String n);
    */
/*    @Query("delete from Groupe g where g.id=?1")
    void delete( @Param("id") Long id);*/

}
