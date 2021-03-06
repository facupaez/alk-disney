package com.facu.disney.entity;

import java.time.LocalDate;
import java.util.*;
import javax.persistence.*;
import lombok.Data;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;
import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name = "movie")
@Data
//diferencia los estados de los eliminados y no eliminados
@Where(clause = "deleted=false")
public class Movie {

    @Id
    @Column(name = "id_movie")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idMovie;

    private String image;

    private String title;

    @Column(name = "creation_date")
    @DateTimeFormat(pattern = "yyyy/MM/dd")
    private LocalDate creationDate;

    private Long qualification;

    private boolean deleted = Boolean.FALSE;

    //relaciones muchos a uno (muchas peliculas pueden tener un genero)
    //lo usamos para pedir informacion como una lista peliculas y sus generos
    @ManyToOne
    @JoinColumn(name = "id_genre")
    private Genre genre;

    //muchas peliculas pueden tener muchos actores y viceversa
    @ManyToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    @JoinTable(name = "actor_movie",
            joinColumns = @JoinColumn(name = "id_movie"),
            inverseJoinColumns = @JoinColumn(name = "id_actor"))
    private Set<Actor> actors = new HashSet<>();
}
