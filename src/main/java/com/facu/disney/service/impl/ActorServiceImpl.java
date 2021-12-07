package com.facu.disney.service.impl;

import com.facu.disney.dto.ActorBasicDTO;
import com.facu.disney.dto.ActorDTO;
import com.facu.disney.dto.ActorFiltersDTO;
import com.facu.disney.entity.ActorEntity;
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
    public ActorDTO save(ActorDTO dto) {
        ActorEntity entity = this.actorMapper.actorDTO2Entity(dto);
        ActorEntity actorSaved = this.actorRepository.save(entity);
        ActorDTO result = this.actorMapper.actorEntity2DTO(actorSaved, false);

        return result;
    }

    //get basic list actors
    @Override
    public List<ActorBasicDTO> getBasicList() {
        List<ActorEntity> entities = this.actorRepository.findAll();
        List<ActorBasicDTO> result = this.actorMapper.actorEntityList2DTOBasicList(entities);

        return result;
    }

    //method update actor
    @Override
    public ActorDTO update(ActorDTO dto, Long idActor) {

        Optional<ActorEntity> entity = this.actorRepository.findById(idActor);

        if (!entity.isPresent()) {
            throw new InvalidParam("El id ingresado no existe.");
        }
        this.actorMapper.actorEntityUpdate(entity.get(), dto);
        ActorEntity actorSaved = this.actorRepository.save(entity.get());
        ActorDTO result = this.actorMapper.actorEntity2DTO(actorSaved, false);

        return result;
    }

    //method delete actor
    @Override
    public void delete(Long idActor) {
        this.actorRepository.deleteById(idActor);
    }

    //get details by id
    @Override
    public ActorDTO getDetailsById(Long idActor) {

        Optional<ActorEntity> entity = this.actorRepository.findById(idActor);

        if (!entity.isPresent()) {
            throw new InvalidParam("El id ingresado no existe.");
        }

        ActorDTO actor = this.actorMapper.actorEntity2DTO(entity.get(), true);

        return actor;
    }

    //get filters details by id
    @Override
    public List<ActorDTO> getDetailsByFilters(String name, Long age, Set<Long> movies) {

        ActorFiltersDTO filtersDTO = new ActorFiltersDTO(name, age, movies);
        List<ActorEntity> entities = this.actorRepository.findAll(this.actorSpecification.getActorByFilters(filtersDTO));
        List<ActorDTO> dtos = this.actorMapper.actorEntityList2DTOList(entities, true);

        return dtos;
    }

}
