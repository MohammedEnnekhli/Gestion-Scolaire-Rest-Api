package com.sounhalazoun.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sounhalazoun.entities.AppRole;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.web.bind.annotation.CrossOrigin;

@RepositoryRestResource
@CrossOrigin("*")
public interface AppRoleRepository extends JpaRepository<AppRole,Long>{
public AppRole findByRole(String role);
}
