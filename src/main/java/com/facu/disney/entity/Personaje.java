/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.facu.disney.entity;

import java.util.*;
import javax.persistence.*;
import lombok.Data;

@Entity
@Table(name = "personaje")
@Data
public class Personaje {

    @Id
    @Column(name = "id_personaje")
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long idPersonaje;
    
    private String imagen;
    
    private String nombre;
    
    private Long edad;
    
    private Long peso;
    
    private String historia;
    
    @ManyToMany(mappedBy = "personajes", cascade = CascadeType.ALL)
    private List<Pelicula> peliculas = new ArrayList<>();
}
