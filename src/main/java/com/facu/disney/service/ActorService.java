package com.facu.disney.service;

import com.facu.disney.dto.ActorBasicDTO;
import com.facu.disney.dto.ActorDTO;
import java.util.List;
import java.util.Set;

public interface ActorService {

    public ActorDTO save(ActorDTO actor);

    public List<ActorBasicDTO> getBasicList();

    public ActorDTO update(ActorDTO actor, Long idActor);

    public void delete(Long idActor);

    public ActorDTO getDetailsById(Long idActor);

    public List<ActorDTO> getDetailsByFilters(String name, Long age, Set<Long> movies);
    
}
