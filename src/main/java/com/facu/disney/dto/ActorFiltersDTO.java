package com.facu.disney.dto;

import java.util.Set;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ActorFiltersDTO {
    
    private String name;
    private Long age;
    private Set<Long> movies;
    
    public ActorFiltersDTO(String name, Long age, Set<Long> movies){
        this.name = name;
        this.age = age;
        this.movies = movies;
    }
}
