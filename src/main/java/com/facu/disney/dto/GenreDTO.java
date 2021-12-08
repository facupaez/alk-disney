package com.facu.disney.dto;

import java.util.List;
import lombok.*;

@Getter
@Setter
public class GenreDTO {
    
    private Long idGenre;
    private String name;
    private String image;
    private List<MovieDTO> movies;
}
