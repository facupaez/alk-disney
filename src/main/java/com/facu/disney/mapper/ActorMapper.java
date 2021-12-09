package com.facu.disney.mapper;

import com.facu.disney.dto.ActorBasicDTO;
import com.facu.disney.dto.ActorDTO;
import com.facu.disney.dto.MovieDTO;
import com.facu.disney.entity.Actor;
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
    public Actor actorDTO2Entity(ActorDTO actorDTO) {
        Actor actor = new Actor();
        actor.setImage(actorDTO.getImage());
        actor.setName(actorDTO.getName());
        actor.setAge(actorDTO.getAge());
        actor.setWeight(actorDTO.getWeight());
        actor.setHistory(actorDTO.getHistory());

        return actor;
    }

    //actorEntity to actorDTO
    public ActorDTO actorEntity2DTO(Actor actor, boolean loadMovies) {
        ActorDTO actorDTO = new ActorDTO();
        actorDTO.setIdActor(actor.getIdActor());
        actorDTO.setImage(actor.getImage());
        actorDTO.setName(actor.getName());
        actorDTO.setAge(actor.getAge());
        actorDTO.setWeight(actor.getWeight());
        actorDTO.setHistory(actor.getHistory());
        // load movies list
        if (loadMovies) {
            List<MovieDTO> moviesDTO = movieMapper.movieEntityList2DTOList(actor.getMovies(), false);
            actorDTO.setMovies(moviesDTO);
        }
        return actorDTO;
    }

    //actorEntity list to actorDTO list
    public List<ActorBasicDTO> actorEntityList2DTOBasicList(List<Actor> actors) {
        List<ActorBasicDTO> actorsDTO = new ArrayList<>();
        for (Actor actor : actors) {
            actorsDTO.add(this.actorEntity2DTOBasic(actor));
        }
        return actorsDTO;
    }

    //actorEntity to actorBasicDTO
    private ActorBasicDTO actorEntity2DTOBasic(Actor actor) {
        ActorBasicDTO actorBasicDTO = new ActorBasicDTO();
        actorBasicDTO.setImage(actor.getImage());
        actorBasicDTO.setName(actor.getName());

        return actorBasicDTO;
    }

    //update actor
    public void actorEntityUpdate(Actor actor, ActorDTO actorDTO) {
        actor.setImage(actorDTO.getImage());
        actor.setName(actorDTO.getName());
        actor.setAge(actorDTO.getAge());
        actor.setWeight(actorDTO.getWeight());
        actor.setHistory(actorDTO.getHistory());
    }
    
     // actorEntity list to actorDTO list
    public List<ActorDTO> actorEntityList2DTOList(Collection<Actor> actors, boolean loadMovies) {
        List<ActorDTO> actorsDTO = new ArrayList<>();
        for (Actor actor : actors) {
            actorsDTO.add(this.actorEntity2DTO(actor, loadMovies));
        }

        return actorsDTO;
    }

}
