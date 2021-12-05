package com.facu.disney.dto;

import lombok.*;

@Getter
@Setter
public class ActorBasicDTO {

    //controlar si es necesario id para listar por name e image
    private Long idActor;
    private String image;
    private String name;
}
