package com.facu.disney.mapper;

import com.facu.disney.dto.GenreDTO;
import com.facu.disney.entity.GenreEntity;
import java.util.ArrayList;
import java.util.List;
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

    // genre entity list to genre dto list
    public List<GenreDTO> genreEntityList2DTOList(List<GenreEntity> entities) {
        
        List<GenreDTO> dtoList = new ArrayList<>();
        for(GenreEntity entity : entities){
            dtoList.add(this.genreEntity2DTO(entity));
        }
        
        return dtoList;
    }
}
