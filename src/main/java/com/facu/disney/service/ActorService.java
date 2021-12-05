package com.facu.disney.service;

import com.facu.disney.dto.ActorBasicDTO;
import com.facu.disney.dto.ActorDTO;
import java.util.List;

public interface ActorService {

    public ActorDTO save(ActorDTO actor);

    public List<ActorBasicDTO> getBasic();

    public ActorDTO update(ActorDTO actor, Long idActor);

    public void delete(Long idActor);

    public ActorDTO getDetailsById(Long idActor);
    
}
