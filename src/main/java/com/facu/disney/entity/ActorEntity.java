package com.facu.disney.entity;

import java.util.*;
import javax.persistence.*;
import lombok.Data;

@Entity
@Table(name = "actor")
@Data
public class ActorEntity {

    @Id
    @Column(name = "id_actor")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idActor;
    
    private String image;
    
    private String name;
    
    private Long age;
    
    private Long weight;
    
    private String history;
    
    @ManyToMany(mappedBy = "actors", cascade = CascadeType.MERGE)
    private List<MovieEntity> movies = new ArrayList<>();
}
