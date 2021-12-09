package com.facu.disney.service.impl;

import com.facu.disney.dto.ActorBasicDTO;
import com.facu.disney.dto.ActorDTO;
import com.facu.disney.dto.ActorFiltersDTO;
import com.facu.disney.entity.Actor;
import com.facu.disney.exception.InvalidParam;
import com.facu.disney.mapper.ActorMapper;
import com.facu.disney.repository.ActorRepository;
import com.facu.disney.repository.specification.ActorSpecification;
import org.springframework.stereotype.Service;
import com.facu.disney.service.ActorService;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import org.springframework.beans.factory.annotation.Autowired;

@Service
public class ActorServiceImpl implements ActorService {

    @Autowired
    ActorMapper actorMapper;
    @Autowired
    ActorRepository actorRepository;
    @Autowired
    ActorSpecification actorSpecification;

    //method save actor
    @Override
    public ActorDTO save(ActorDTO actorDTO) {
        Actor actor = actorMapper.actorDTO2Entity(actorDTO);
        Actor actorSaved = actorRepository.save(actor);
        ActorDTO result = actorMapper.actorEntity2DTO(actorSaved, false);

        return result;
    }

    //get basic list actors
    @Override
    public List<ActorBasicDTO> getBasicList() {
        List<Actor> actors = actorRepository.findAll();
        List<ActorBasicDTO> result = actorMapper.actorEntityList2DTOBasicList(actors);

        return result;
    }

    //method update actor
    @Override
    public ActorDTO update(ActorDTO actorDTO, Long idActor) {

        Optional<Actor> actor = actorRepository.findById(idActor);

        if (!actor.isPresent()) {
            throw new InvalidParam("El id ingresado no existe.");
        }
        actorMapper.actorEntityUpdate(actor.get(), actorDTO);
        Actor actorSaved = actorRepository.save(actor.get());
        ActorDTO result = actorMapper.actorEntity2DTO(actorSaved, false);

        return result;
    }

    //method delete actor
    @Override
    public void delete(Long idActor) {
        Optional<Actor> actorOp = actorRepository.findById(idActor);

        if (!actorOp.isPresent()) {
            throw new InvalidParam("El id ingresado no existe.");
        }
        Actor actor = actorOp.get();
        actor.setDeleted(true);
        actorRepository.save(actor);
    }

    //get details by id
    @Override
    public ActorDTO getDetailsById(Long idActor) {

        Optional<Actor> actorOp = actorRepository.findById(idActor);

        if (!actorOp.isPresent()) {
            throw new InvalidParam("El id ingresado no existe.");
        }

        ActorDTO actorDTO = actorMapper.actorEntity2DTO(actorOp.get(), true);

        return actorDTO;
    }

    //get filters details by id
    @Override
    public List<ActorDTO> getDetailsByFilters(String name, Long age, Set<Long> movie) {

        ActorFiltersDTO filtersDTO = new ActorFiltersDTO(name, age, movie);
        List<Actor> actors = actorRepository.findAll(actorSpecification.getActorByFilters(filtersDTO));
        List<ActorDTO> actorDTO = actorMapper.actorEntityList2DTOList(actors, true);

        return actorDTO;
    }

}
