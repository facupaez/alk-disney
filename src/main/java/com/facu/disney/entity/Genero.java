/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.facu.disney.entity;

import javax.persistence.*;
import lombok.Data;

@Entity
@Table(name = "genero")
@Data
public class Genero {

    @Id
    @Column(name = "id_genero")
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long idGenero;
    
    private String nombre;
    
    private String imagen;
    
}
