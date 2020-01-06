package com.sounhalazoun.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.sounhalazoun.dao.GroupeRepository;
import com.sounhalazoun.entities.Groupe;

@RestController
@CrossOrigin("*")
public class GroupeRestService {
    @Autowired
    private GroupeRepository groupeRepository;
    
 /*   @DeleteMapping(value="/groupes/{id}")
    public void deleteGroupe(@PathVariable Long id) {
        groupeRepository.deleteById( id );;
    }*/

     
     /*
     @RequestMapping(value="/chercher")
     public Long getGroupe(String nom) {
         return groupeRepository.findByNomG( nom );
     }
     */
}
