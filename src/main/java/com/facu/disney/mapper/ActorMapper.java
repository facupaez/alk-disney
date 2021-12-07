package com.facu.disney.mapper;

import com.facu.disney.dto.ActorBasicDTO;
import com.facu.disney.dto.ActorDTO;
import com.facu.disney.dto.MovieDTO;
import com.facu.disney.entity.ActorEntity;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ActorMapper {

    @Autowired
    MovieMapper movieMapper;

    //actorDTO to actorEntity
    public ActorEntity actorDTO2Entity(ActorDTO dto) {
        ActorEntity entity = new ActorEntity();
        entity.setImage(dto.getImage());
        entity.setName(dto.getName());
        entity.setAge(dto.getAge());
        entity.setWeight(dto.getWeight());
        entity.setHistory(dto.getHistory());

        return entity;
    }

    //actorEntity to actorDTO
    public ActorDTO actorEntity2DTO(ActorEntity entity, boolean loadMovies) {
        ActorDTO dto = new ActorDTO();
        dto.setIdActor(entity.getIdActor());
        dto.setImage(entity.getImage());
        dto.setName(entity.getName());
        dto.setAge(entity.getAge());
        dto.setWeight(entity.getWeight());
        dto.setHistory(entity.getHistory());
        // load movies list
        if (loadMovies) {
            List<MovieDTO> moviesDTO = movieMapper.movieEntityList2DTOList(entity.getMovies(), false);
            dto.setMovies(moviesDTO);
        }
        return dto;
    }

    //actorEntity list to actorDTO list
    public List<ActorBasicDTO> actorEntityList2DTOBasicList(List<ActorEntity> entities) {
        List<ActorBasicDTO> actorsDTO = new ArrayList<>();
        for (ActorEntity entity : entities) {
            actorsDTO.add(this.actorEntity2DTOBasic(entity));
        }
        return actorsDTO;
    }

    //actorEntity to actorBasicDTO
    private ActorBasicDTO actorEntity2DTOBasic(ActorEntity entity) {
        ActorBasicDTO basicDTO = new ActorBasicDTO();
        basicDTO.setImage(entity.getImage());
        basicDTO.setName(entity.getName());

        return basicDTO;
    }

    //update actor
    public void actorEntityUpdate(ActorEntity entity, ActorDTO dto) {
        entity.setImage(dto.getImage());
        entity.setName(dto.getName());
        entity.setAge(dto.getAge());
        entity.setWeight(dto.getWeight());
        entity.setHistory(dto.getHistory());
    }
    
     // actorEntity list to actorDTO list
    public List<ActorDTO> actorEntityList2DTOList(Collection<ActorEntity> entities, boolean loadMovies) {
        List<ActorDTO> dtos = new ArrayList<>();
        for (ActorEntity entity : entities) {
            dtos.add(this.actorEntity2DTO(entity, loadMovies));
        }

        return dtos;
    }

}
