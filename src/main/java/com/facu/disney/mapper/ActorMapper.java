package com.facu.disney.mapper;

import com.facu.disney.dto.ActorBasicDTO;
import com.facu.disney.dto.ActorDTO;
import com.facu.disney.entity.ActorEntity;
import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Component;

@Component
public class ActorMapper {

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
    public ActorDTO actorEntity2DTO(ActorEntity entity) {
        ActorDTO dto = new ActorDTO();
        dto.setIdActor(entity.getIdActor());
        dto.setImage(entity.getImage());
        dto.setName(entity.getName());
        dto.setAge(entity.getAge());
        dto.setWeight(entity.getWeight());
        dto.setHistory(entity.getHistory());

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
        basicDTO.setIdActor(entity.getIdActor());
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

}
