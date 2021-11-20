/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.facu.disney.entity;

import java.time.LocalDate;
import java.util.*;
import javax.persistence.*;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name = "pelicula")
@Data
public class Pelicula {

    @Id
    @Column(name = "id_pelicula")
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long idPelicula;
    
    private String imagen;
    
    private String titulo;
    
    @Column(name = "fecha_creacion")
    @DateTimeFormat(pattern = "yyyy/MM/dd")
    private LocalDate fechaCreacion;
    
    private Long calificacion;
    
    //relaciones muchos a uno (muchas peliculas pueden tener un genero)
    //lo usamos para pedir informacion como una lista peliculas y sus generos
    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinColumn(name = "id_genero", insertable = false, updatable = false)
    private Genero genero;
    
    //lo usamos para guardar o modificar
    @Column(name = "id_genero", nullable = false)
    private Long idGenero;
    
    //muchos paises pueden tener muchos iconos y viceversa
    @ManyToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    @JoinTable(name = "personaje_pelicula", 
            joinColumns = @JoinColumn(name = "id_pelicula"),
            inverseJoinColumns = @JoinColumn(name = "id_personaje"))
    private Set<Personaje> personajes = new HashSet<>();
}
