package com.sounhalazoun.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sounhalazoun.entities.AppUser;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.web.bind.annotation.CrossOrigin;


public interface AppUserRepository extends JpaRepository<AppUser, Long> {
public AppUser findByUsername(String username);
}
