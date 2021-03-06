package com.sounhalazoun.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.sounhalazoun.entities.AppUser;
import com.sounhalazoun.service.AccountService;

@RestController
@CrossOrigin("*")
public class UserController {
    @Autowired
    private AccountService accountService;

    @PostMapping("/users")
    public AppUser signUp(@RequestBody RegistrationForm data) {
    String username=data.getUsername();
    AppUser user=accountService.findUserByUsername(username);
    if(user!=null) throw new RuntimeException("This user already exists, Try with an other username");
    String password=data.getPassword();
    String repassword=data.getRepassword();
    if(! password.equals(repassword))
    throw new RuntimeException("You must confirm your password");
    AppUser u=new AppUser();
    u.setUsername(username); 
    u.setPassword(password);
    accountService.saveUser(u);
    accountService.addRoleToUser(username, "USER");
    return (u);
    }
    }
