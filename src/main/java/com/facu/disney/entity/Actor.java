package com.facu.disney.entity;

import java.util.*;
import javax.persistence.*;
import lombok.Data;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;

@Entity
@Table(name = "actor")
@Data
//diferencia los estados de los eliminados y no eliminados
@Where(clause = "deleted=false")
public class Actor {

    @Id
    @Column(name = "id_actor")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idActor;

    private String image;

    private String name;

    private Long age;

    private Long weight;

    private String history;
    
    private boolean deleted = Boolean.FALSE;

    @ManyToMany(mappedBy = "actors", cascade = CascadeType.MERGE)
    private List<Movie> movies = new ArrayList<>();
}
