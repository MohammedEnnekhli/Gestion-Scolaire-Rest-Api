package com.sounhalazoun.entities;

import java.util.*;
import javax.persistence.*;
import lombok.*;
@Entity
@Data @AllArgsConstructor @NoArgsConstructor
public class AppUser {
@Id @GeneratedValue
private Long id;
private String username;
private String password;
@ManyToMany(fetch=FetchType. EAGER)
private Collection<AppRole> roles=new ArrayList<>();

}