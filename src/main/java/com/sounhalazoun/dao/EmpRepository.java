package com.sounhalazoun.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.web.bind.annotation.CrossOrigin;

import com.sounhalazoun.entities.Emp;

@RepositoryRestResource
@CrossOrigin("*")

public interface EmpRepository extends JpaRepository<Emp, Long>{

}
