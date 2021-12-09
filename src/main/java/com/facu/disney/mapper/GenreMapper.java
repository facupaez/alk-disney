package com.facu.disney.mapper;

import com.facu.disney.dto.GenreDTO;
import com.facu.disney.entity.Genre;
import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Component;

@Component
public class GenreMapper {
    
    //genreDTO to genreEntity
    public Genre genreDTO2Entity(GenreDTO genreDTO){
        Genre genre = new Genre();
        genre.setName(genreDTO.getName());
        genre.setImage(genreDTO.getImage());
        
        return genre;
    }
    
    //genreEntity to genreDTO
    public GenreDTO genreEntity2DTO(Genre genre){
        GenreDTO genreDTO = new GenreDTO();
        genreDTO.setIdGenre(genre.getIdGenre());
        genreDTO.setName(genre.getName());
        genreDTO.setImage(genre.getImage());
        
        return genreDTO;
    }

    // genre entity list to genre dto list
    public List<GenreDTO> genreEntityList2DTOList(List<Genre> genres) {
        
        List<GenreDTO> genresDTO = new ArrayList<>();
        for(Genre genre : genres){
            genresDTO.add(this.genreEntity2DTO(genre));
        }
        
        return genresDTO;
    }
}
