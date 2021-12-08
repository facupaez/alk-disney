package com.facu.disney.mapper;

import com.facu.disney.dto.ActorDTO;
import com.facu.disney.dto.MovieBasicDTO;
import com.facu.disney.dto.MovieDTO;
import com.facu.disney.entity.MovieEntity;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class MovieMapper {

    @Autowired
    ActorMapper actorMapper;

    // movieDTO to movieEntity
    public MovieEntity movieDTO2Entity(MovieDTO dto) {
        MovieEntity entity = new MovieEntity();
        entity.setImage(dto.getImage());
        entity.setTitle(dto.getTitle());
        entity.setCreationDate(this.string2LocalDate(dto.getCreationDate()));
        entity.setQualification(dto.getQualification());
        entity.setGenreId(dto.getGenreId());

        return entity;
    }

    // movieEntity to movieDTO
    public MovieDTO movieEntity2DTO(MovieEntity entity, boolean loadActors) {
        MovieDTO dto = new MovieDTO();
        dto.setIdMovie(entity.getIdMovie());
        dto.setImage(entity.getImage());
        dto.setTitle(entity.getTitle());
        dto.setCreationDate(entity.getCreationDate().toString());
        dto.setQualification(entity.getQualification());
        dto.setGenreId(entity.getGenreId());
        //load actors list
        if (loadActors) {
            List<ActorDTO> actorsDTO = actorMapper.actorEntityList2DTOList(entity.getActors(), false);
            dto.setActors(actorsDTO);
        }
        return dto;
    }

    // movieEntity list to movieDTO list
    public List<MovieDTO> movieEntityList2DTOList(List<MovieEntity> entities, boolean loadActors) {
        List<MovieDTO> moviesDTO = new ArrayList<>();
        for (MovieEntity entity : entities) {
            moviesDTO.add(this.movieEntity2DTO(entity, loadActors));
        }
        return moviesDTO;
    }

    //movieEntity list to movieDTO list
    public List<MovieBasicDTO> movieEntityList2DTOBasicList(List<MovieEntity> entities) {
        List<MovieBasicDTO> moviesDTO = new ArrayList<>();
        for (MovieEntity entity : entities) {
            moviesDTO.add(this.movieEntity2DTOBasic(entity));
        }
        return moviesDTO;
    }

    //actorEntity to actorBasicDTO
    public MovieBasicDTO movieEntity2DTOBasic(MovieEntity entity) {
        MovieBasicDTO dto = new MovieBasicDTO();
        //dto.setIdActor(entity.getIdActor());
        dto.setImage(entity.getImage());
        dto.setTitle(entity.getTitle());
        dto.setCreationDate(entity.getCreationDate().toString());

        return dto;
    }

    //date type to string date type
    private LocalDate string2LocalDate(String creationDate) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        LocalDate date = LocalDate.parse(creationDate, formatter);
        return date;
    }

    //update movie
    public void movieEntityUpdate(MovieEntity entity, MovieDTO dto) {
        entity.setImage(dto.getImage());
        entity.setTitle(dto.getTitle());
        entity.setCreationDate(this.string2LocalDate(dto.getCreationDate()));
        entity.setQualification(dto.getQualification());
        entity.setGenreId(dto.getGenreId());
    }
}
