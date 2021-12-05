package com.facu.disney.mapper;

import com.facu.disney.dto.GenreDTO;
import com.facu.disney.entity.GenreEntity;
import org.springframework.stereotype.Component;

@Component
public class GenreMapper {
    
    //genreDTO to genreEntity
    public GenreEntity genreDTO2Entity(GenreDTO dto){
        GenreEntity entity = new GenreEntity();
        entity.setName(dto.getName());
        entity.setImage(dto.getImage());
        
        return entity;
    }
    
    //genreEntity to genreDTO
    public GenreDTO genreEntity2DTO(GenreEntity entity){
        GenreDTO dto = new GenreDTO();
        dto.setIdGenre(entity.getIdGenre());
        dto.setName(entity.getName());
        dto.setImage(entity.getImage());
        
        return dto;
    }
}
