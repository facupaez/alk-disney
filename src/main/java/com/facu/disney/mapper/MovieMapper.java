package com.facu.disney.mapper;

import com.facu.disney.dto.ActorDTO;
import com.facu.disney.dto.MovieDTO;
import com.facu.disney.entity.MovieEntity;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class MovieMapper {

    @Autowired
    ActorMapper actorMapper;

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
    List<MovieDTO> movieEntityList2DTOList(List<MovieEntity> entities, boolean loadActors) {
        List<MovieDTO> moviesDTO = new ArrayList<>();
        for (MovieEntity entity : entities) {
            moviesDTO.add(this.movieEntity2DTO(entity, loadActors));
        }
        return moviesDTO;
    }

}
