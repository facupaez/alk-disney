package com.facu.disney.dto;

import java.util.List;
import lombok.*;

@Getter
@Setter
public class MovieDTO {

    private Long idMovie;
    private String image;
    private String titile;
    private String creationDate;
    private Long qualification;
    private Long genreId;
    private List<ActorDTO> actors;
}
