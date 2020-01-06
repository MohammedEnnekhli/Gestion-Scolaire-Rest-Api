package com.sounhalazoun.service;

import com.sounhalazoun.entities.AppRole;
import com.sounhalazoun.entities.AppUser;

public interface AccountService {
public AppUser saveUser(AppUser u);
public AppRole saveRole(AppRole r);
public AppUser findUserByUsername(String username);
public void addRoleToUser(String username,String role);
}