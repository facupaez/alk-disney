package com.facu.disney.dto;

import java.util.List;
import lombok.*;

@Getter
@Setter
public class ActorDTO {
    
    private Long idActor;
    private String image;
    private String name;
    private Long age;
    private Long weight;
    private String history;
    private List<MovieDTO> movies;
}
