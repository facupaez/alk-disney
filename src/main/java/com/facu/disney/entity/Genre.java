package com.facu.disney.entity;

import javax.persistence.*;
import lombok.Data;

@Entity
@Table(name = "genre")
@Data
public class Genre {

    @Id
    @Column(name = "id_genre")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idGenre;
    
    private String name;
    
    private String image;
    
}
