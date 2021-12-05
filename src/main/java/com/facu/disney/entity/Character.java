package com.facu.disney.entity;

import java.util.*;
import javax.persistence.*;
import lombok.Data;

@Entity
@Table(name = "character")
@Data
public class Character {

    @Id
    @Column(name = "id_character")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idCharacter;
    
    private String image;
    
    private String name;
    
    private Long age;
    
    private Long weight;
    
    private String history;
    
    @ManyToMany(mappedBy = "characters", cascade = CascadeType.ALL)
    private List<Movie> movies = new ArrayList<>();
}
