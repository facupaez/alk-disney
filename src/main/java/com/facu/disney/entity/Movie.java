package com.facu.disney.entity;

import java.time.LocalDate;
import java.util.*;
import javax.persistence.*;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name = "movie")
@Data
public class Movie {

    @Id
    @Column(name = "id_pelicula")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idMovie;
    
    private String image;
    
    private String title;
    
    @Column(name = "creation_date")
    @DateTimeFormat(pattern = "yyyy/MM/dd")
    private LocalDate creationDate;
    
    private Long qualification;
    
    //relaciones muchos a uno (muchas peliculas pueden tener un genero)
    //lo usamos para pedir informacion como una lista peliculas y sus generos
    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinColumn(name = "id_genre", insertable = false, updatable = false)
    private Genre genre;
    
    //lo usamos para guardar o modificar
    @Column(name = "id_genre", nullable = false)
    private Long idGenre;
    
    //muchos paises pueden tener muchos iconos y viceversa
    @ManyToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    @JoinTable(name = "character_movie", 
            joinColumns = @JoinColumn(name = "id_movie"),
            inverseJoinColumns = @JoinColumn(name = "id_character"))
    private Set<Character> characters = new HashSet<>();
}
