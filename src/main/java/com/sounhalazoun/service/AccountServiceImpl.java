package com.sounhalazoun.service;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.sounhalazoun.dao.AppRoleRepository;
import com.sounhalazoun.dao.AppUserRepository;
import com.sounhalazoun.entities.AppRole;
import com.sounhalazoun.entities.AppUser;


@Service
@Transactional
public class AccountServiceImpl implements AccountService {
    @Autowired
    private AppUserRepository     userRepository;
    @Autowired
    private AppRoleRepository     roleRepository;
    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;
    
    

    @Override
    public AppUser saveUser( AppUser u ) {
        u.setPassword( bCryptPasswordEncoder.encode( u.getPassword() ) );
        return userRepository.save( u );
    }

    @Override
    public AppRole saveRole( AppRole r ) {
        return roleRepository.save( r );
    }

    @Override
    public AppUser findUserByUsername( String username ) {
        return userRepository.findByUsername( username );
    }

    @Override
    public void addRoleToUser( String username, String roleName ) {
        AppUser user = userRepository.findByUsername( username );
        AppRole role = roleRepository.findByRole( roleName );
        user.getRoles().add( role );
    }

}
