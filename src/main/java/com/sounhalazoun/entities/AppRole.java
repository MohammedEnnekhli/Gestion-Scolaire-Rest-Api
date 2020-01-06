package com.sounhalazoun.entities;

import javax.persistence.*;
import lombok.*;
@Entity
@Data @AllArgsConstructor @NoArgsConstructor
public class AppRole {
@Id @GeneratedValue
private Long id;
private String role;
}
