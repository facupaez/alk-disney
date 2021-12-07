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
//soft delete
@SQLDelete(sql = "UPDATE movie SET deleted = true WHERE id_movie=?")
//diferencia los estados de los eliminados y no eliminados
@Where(clause = "deleted=false")
public class MovieEntity {

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
    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinColumn(name = "id_genre", insertable = false, updatable = false)
    private GenreEntity genre;

    //lo usamos para guardar o modificar
    @Column(name = "id_genre", nullable = false)
    private Long genreId;

    //muchas peliculas pueden tener muchos actores y viceversa
    @ManyToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    @JoinTable(name = "actor_movie",
            joinColumns = @JoinColumn(name = "id_movie"),
            inverseJoinColumns = @JoinColumn(name = "id_actor"))
    private Set<ActorEntity> actors = new HashSet<>();
}
