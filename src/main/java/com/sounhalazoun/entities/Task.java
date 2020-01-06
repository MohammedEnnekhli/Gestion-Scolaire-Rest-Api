package com.sounhalazoun.entities;
import javax.persistence.*;
import lombok.*;
@Entity
@Data @AllArgsConstructor @NoArgsConstructor
public class Task {
@Id @GeneratedValue
private Long id;
private String taskName;
}